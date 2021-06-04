package app.repository;

import app.model.Track;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

public interface TrackRepository {
    Optional<Track> get(Long id);

    List<Track> getAll();

    void save(Track line);

    void update(Track line);

    void delete(Long id);

    void delete(Track line);

    void clear();
}
