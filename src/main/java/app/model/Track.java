package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Track {
    private int length;
    private List<Car> cars;
    private List<TrackCell> cells; 
    //private WHAT???
}
