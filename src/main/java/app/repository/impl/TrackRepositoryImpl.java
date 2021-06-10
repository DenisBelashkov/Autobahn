package app.repository.impl;

import app.model.Track;
import app.repository.TrackCellRepository;
import app.repository.TrackRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TrackRepositoryImpl implements TrackRepository {

    private final SessionFactory sessionFactory;
    private final TrackCellRepository trackCellRepository;

    @Autowired
    public TrackRepositoryImpl(SessionFactory sessionFactory, TrackCellRepository roadBlockRepository) {
        this.sessionFactory = sessionFactory;
        this.trackCellRepository = roadBlockRepository;
    }


    @Override
    public Optional<Track> get(Long id) {
        Session session = sessionFactory.openSession();
        var result = session.get(Track.class, id);
        if (result == null) {
            var c = 0;
        }

        result.getCellList().size();

        for (int i = 0; i < result.getLength(); i++) {
            result.getCellList().set(i, trackCellRepository.get(result.getCellList().get(i).getId()).get());
        }
        session.close();
        return Optional.of(result);
    }


    @Override
    public List<Track> getAll() {
        Session session = sessionFactory.openSession();
        var query = session.createQuery("from tracks");
        var result = query.getResultList();

        session.close();
        return result;
    }

    @Override
    public void save(Track line) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(line);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Track line) {
        var current = get(line.getId());
        Session session = sessionFactory.openSession();
        var trans = session.beginTransaction();
        //session.evict(current);
        session.update(line);
        trans.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        var session = sessionFactory.openSession();
        var trans = session.beginTransaction();
        var curr = session.get(Track.class, id);
        session.delete(curr);
        trans.commit();
        session.close();
    }

    @Override
    public void delete(Track line) {
        var session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        var curr = session.get(Track.class, line.getId());
        session.delete(curr);
        transaction.commit();
        session.close();
    }

    @Override
    public void clear() {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            session.createQuery("DELETE from tracks ").executeUpdate();
            transaction.commit();
            session.close();
        } catch (SQLGrammarException ignored) {
        }
    }
}
