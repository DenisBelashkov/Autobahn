package app.repository.impl;

import app.model.Car;
import app.repository.CarRepository;
import app.repository.TrackCellRepository;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class CarRepositoryImpl implements CarRepository {


    private final SessionFactory sessionFactory;

    private final TrackCellRepository trackCellRepository;


    @Autowired
    public CarRepositoryImpl(SessionFactory sessionFactory, TrackCellRepository trackCellRepository) {
        this.sessionFactory = sessionFactory;
        this.trackCellRepository = trackCellRepository;
    }

    @Override
    public Optional<Car> get(Long id) {
        Session session = sessionFactory.openSession();
        var result = session.get(Car.class, id);

        if (result.getTrackCell() instanceof HibernateProxy) {
            var proxy = (HibernateProxy) result.getTrackCell();
            if (proxy != null) {
                proxy.getHibernateLazyInitializer().getImplementation();
            }
        }

        session.close();
        return Optional.of(result);
    }

    @Override
    public List<Car> getAll() {
        Session session = sessionFactory.openSession();
        var query = session.createQuery("FROM cars");
        List<Car> result = query.getResultList();

        result.forEach(res -> {

            if (res.getTrackCell() != null)
                res.setTrackCell(trackCellRepository.get(res.getTrackCell().getId()).get());
        });

        session.close();
        return result;
    }

    @Override
    public void save(Car entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Car entity) {
        var current = get(entity.getId());
        Session session = sessionFactory.openSession();
        var trans = session.beginTransaction();
        session.update(entity);
        trans.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        var session = sessionFactory.openSession();
        var trans = session.beginTransaction();
        var curr = session.get(Car.class, id);

        curr.getTrackCell().setCar(null);
        trans.commit();
        session.close();
        trackCellRepository.update(curr.getTrackCell());

        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        //curr.setRoadBlock(null);

        session.delete(curr);
        trans.commit();
        session.close();
    }

    @Override
    public void delete(Car entity) {
        var session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        var curr = session.get(Car.class, entity.getId());
        session.delete(curr);
        transaction.commit();
        session.close();
    }

    @Override
    public void clear() {
        try (var session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("delete from cars").executeUpdate();
            transaction.commit();
        } catch (Exception ignored) {
        }
    }
}
