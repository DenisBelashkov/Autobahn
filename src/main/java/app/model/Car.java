package app.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String ID; // или это ID????
    private List<TrackCell> coordinatePoints; // длина машины -- 4 метра
    private double startVelocity; // метров в секунду, задается в км/ч
    private double acceleration;
    private State state;
    private int bodyLength;


}
