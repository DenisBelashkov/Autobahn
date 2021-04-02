package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackCell {
    // длина около 1м
    // есть машина/нет машины
    private int ID;
    private boolean isCar;

}
