package app.repository;

import app.model.TrackCell;

import java.util.List;
import java.util.Optional;

public interface TrackCellRepository {

    Optional<TrackCell> get(Long id);

    List<TrackCell> getAll();

    void save(TrackCell entity);

    void update(TrackCell entity);

    void updateSavingNextBlocks(TrackCell entity);

    void delete(Long id);

    void delete(TrackCell entity);

    void clear();
}
