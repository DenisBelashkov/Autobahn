package app.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    private Long id;
    private Integer speed;
   // private DriveModel driveModel;
    private TrackCellDTO trackCell;

<<<<<<< HEAD
    public CarDTO(Long id,  TrackCellDTO trackCell) {
=======
    public CarDTO(Long id, DriveModel driveModel, TrackCellDTO trackCell) {
>>>>>>> origin/master
        this.id = id;
      //  this.driveModel = driveModel;
        this.trackCell = trackCell;
    }
}
