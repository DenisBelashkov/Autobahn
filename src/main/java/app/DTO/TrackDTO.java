package app.DTO;


import app.model.TrackCell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackDTO {

    private Long id;
    private int trackLength;
<<<<<<< HEAD
    private TrackCellDTO startCell;

    public TrackDTO(int trackLength, TrackCellDTO startCell) {
=======
    private TrackCell startCell;

    public TrackDTO(int trackLength, TrackCell startCell) {
>>>>>>> origin/master
        this.trackLength = trackLength;
        this.startCell = startCell;
    }
}
