package app.repository.impl;

import app.model.Car;
import app.model.TrackCell;
import app.repository.TrackCellRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.SQLGrammarException;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TrackCellRepositoryImpl implements TrackCellRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public TrackCellRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<TrackCell> get(Long id) {
        Session session = sessionFactory.openSession();
        var result = session.get(TrackCell.class, id);


        var proxyCar = (HibernateProxy) result.getCar();
        if (proxyCar != null)
            proxyCar.getHibernateLazyInitializer().getImplementation();

        session.close();
        return Optional.of(result);
    }

    @Override
    public List<TrackCell> getAll() {
        Session session = sessionFactory.openSession();
        var query = session.createQuery("From trackcells ");
        var result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public void save(TrackCell entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(TrackCell entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        var session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        var curr = session.get(Car.class, id);
        session.delete(curr);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(TrackCell entity) {
        var session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        var curr = session.get(TrackCell.class, entity.getId());
        session.delete(curr);
        transaction.commit();
        session.close();
    }

    @Override
    public void clear() {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            session.createQuery("delete from trackcells ").executeUpdate();
            transaction.commit();
        } catch (SQLGrammarException ignored) {
        }
    }

    @Override
    public void updateSavingNextBlocks(TrackCell entity) {
        var curr = get(entity.getId());
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        entity.setNextCell(curr.get().getNextCell());

        session.update(entity);
        transaction.commit();
        session.close();

    }


}
