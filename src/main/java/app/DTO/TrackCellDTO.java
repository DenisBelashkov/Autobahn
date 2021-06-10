package app.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackCellDTO {

    private Long id;
    private TrackCellDTO linkNextCell = new TrackCellDTO();
    private CarDTO car;

<<<<<<< HEAD
    public TrackCellDTO(int lineLength, TrackCellDTO startBlock) {
    }

=======
>>>>>>> origin/master
    @Override
    public String toString() {
        return "TrackCellDTO{" +
                "id=" + id +
                ", linkNextCell=" + (linkNextCell == null ? "null" : linkNextCell.id) +
                ", carId=" + (car == null ? "null" : car.getId()) +
                '}';
    }
}
