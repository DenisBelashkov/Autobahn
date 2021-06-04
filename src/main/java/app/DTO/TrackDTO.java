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
    private TrackCell startCell;

    public TrackDTO(int trackLength, TrackCell startCell) {
        this.trackLength = trackLength;
        this.startCell = startCell;
    }
}
