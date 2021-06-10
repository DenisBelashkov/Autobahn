package app.repository;

import app.model.TrackCell;

import java.util.List;
import java.util.Optional;

public interface TrackCellRepository {

    Optional<TrackCell> get(Long id);

    List<TrackCell> getAll();

    void save(TrackCell entity);

    void update(TrackCell entity);

<<<<<<< HEAD
    static void updateSavingNextCells(TrackCell entity) {

    }
=======
    void updateSavingNextBlocks(TrackCell entity);
>>>>>>> origin/master

    void delete(Long id);

    void delete(TrackCell entity);

    void clear();
<<<<<<< HEAD

    void updateSavingNextBlocks(TrackCell entity);
=======
>>>>>>> origin/master
}
