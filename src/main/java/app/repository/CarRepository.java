package app.repository;

import app.model.Car;
import app.model.World;

public interface CarRepository {

    void move();

    void stop();

    void speedUp();

    Car create(World world);



}
