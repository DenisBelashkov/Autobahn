package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class World {

    private int countCar;
    private int appearanceInterval; //-интервал появления (в тиках -- секундах)
    private int acceptableConvergence; //-допустимое сближение в целах ДА ГДЕ БЛИН ЭТО ХРАНИТЬ ТО, А
    private int minVelocity;
    private int maxVelocity;
    private int inAcceleration; //начальная

    //
}
