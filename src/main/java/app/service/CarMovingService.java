package app.service;

<<<<<<< HEAD
import app.DTO.CarDTO;
import app.DTO.TrackCellDTO;
import app.mapper.MainMapper;
import app.repository.CarRepository;
import app.repository.TrackCellRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CarMovingService {
    private final TrackCellRepository trackCellRepository;
    private final CarRepository carRepository;

    private final MainMapper mapper;

    @Autowired
    public CarMovingService(TrackCellRepository trackCellRepository, CarRepository carRepository, MainMapper mapper) {
        this.trackCellRepository = trackCellRepository;
        this.carRepository = carRepository;
        this.mapper = mapper;
    }


    public void moveAllCars() {
        List<Long> carsToRemove = new ArrayList<>();

        getAllCars().forEach(car -> {
            //for (int i = 0; i < auto.getSpeed(); i++) {
            TrackCellDTO currTrackCellDTO = car.getTrackCell();

            if (currTrackCellDTO != null)
                if (currTrackCellDTO.getLinkNextCell() == null) {

                    moveCar(currTrackCellDTO, null, car);
                    carsToRemove.add(car.getId());

                } else if (currTrackCellDTO.getLinkNextCell() != null) {

                    moveCar(currTrackCellDTO, currTrackCellDTO.getLinkNextCell(), car);
                }
            //}
        });

        carsToRemove.forEach(carRepository::delete);
    }

    public List<CarDTO> getAllCars() {
        return mapper.carToCarDTO(carRepository.getAll());
    }

    private void moveCar(TrackCellDTO currBlock, TrackCellDTO nextBlock, CarDTO car) {

        if (nextBlock == null) {
            currBlock.setCar(null);
            car.setTrackCell(null);
            return;
        }

        //aaaaa
        if (nextBlock.getCar() == null) {

            nextBlock.setCar(car);
            currBlock.setCar(null);
            car.setTrackCell(nextBlock);
        } else
            return;

        var currBlockEnt = mapper.cellDtoToCellNoReccurency(currBlock);
        var nextBlockEnt = mapper.cellDtoToCellNoReccurency(nextBlock);
        var autoEnt = mapper.carDtoToCar(car);
        TrackCellRepository.updateSavingNextCells(currBlockEnt);
        TrackCellRepository.updateSavingNextCells(nextBlockEnt);
        carRepository.update(autoEnt);
    }
}
=======
public class CarMovingService {
}
>>>>>>> origin/master
