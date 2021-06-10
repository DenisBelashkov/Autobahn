package app.service;

<<<<<<< HEAD
import app.DTO.CarDTO;
import app.DTO.TrackCellDTO;
import app.DTO.TrackDTO;
import app.component.RoadComponent;
import app.mapper.MainMapper;
import app.repository.CarRepository;
import app.repository.TrackCellRepository;
import app.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class CarGenerationService {


    private final TrackRepository TrackRepository;
    private final CarRepository carRepository;

    private final RoadComponent roadComponent;
    private final TrackCellRepository TrackCellRepository;
=======
import app.repository.CarRepository;
import app.repository.TrackRepository;

public class CarGenerationService {

    private final TrackRepository trackRepository;
    private final CarRepository carRepository;
    private final RoadComponent roadComponent;
    private final RoadBlockRepository roadBlockRepository;
>>>>>>> origin/master

    private final MainMapper mapper;

    @Autowired
<<<<<<< HEAD
    public CarGenerationService(TrackRepository TrackRepository, CarRepository carRepository, RoadComponent roadComponent, TrackCellRepository TrackCellRepository, MainMapper mapper) {
        this.TrackRepository = TrackRepository;
        this.carRepository = carRepository;
        this.roadComponent = roadComponent;
        this.TrackCellRepository = TrackCellRepository;
        this.mapper = mapper;
    }


    public void generateCars(int count) {
        Random random = new Random();


        for (int i = 0; i < count && i < roadComponent.getLinesPerSide() * 4; i++) {
            TrackDTO ln;

            do {
                int TrackNum = random.nextInt(roadComponent.getLinesPerSide() * 4);
                ln = mapper.TrackToTrackDTO(TrackRepository.get(TrackNum + 1L).get()); //fixed
            }
            while (ln == null || (ln != null && ln.getStartCell().getCar() != null));

            TrackCellDTO startBlock = ln.getStartCell();
            int autoSpeed = random.nextInt(roadComponent.getMaxAutoSpeed() - roadComponent.getMinAutoSpeed());

            CarDTO CarDTO = new CarDTO((long) (autoSpeed + roadComponent.getMinAutoSpeed()),
                    startBlock);
            startBlock.setCar(CarDTO);
            CarDTO.setTrackCell(startBlock);

            var auto = mapper.carDtoToCar(CarDTO);
            carRepository.save(auto);
            CarDTO.setId(auto.getId());
            startBlock.setCar(CarDTO);

            auto = mapper.carDtoToCar(CarDTO);
            carRepository.update(auto);
            TrackCellRepository.update(auto.getTrackCell());
        }


    }
=======
    public CarGenerationService(MainMapper mapper, LineRepository lineRepository,
                                RoadBlockRepository roadBlockRepository,
                                AutomobileRepository automobileRepository,
                                RoadComponent roadComponent) {
        this.mapper = mapper;
        this.lineRepository = lineRepository;
        this.roadBlockRepository = roadBlockRepository;
        this.automobileRepository = automobileRepository;
        this.roadComponent = roadComponent;
    }

    public void generateCars(int count){
        Random random = new Random();


        for (int i = 0; i < count && i < roadComponent.getLinesPerSide() * 4; i++){
            LineDTO ln;

            do{
                int lineNum = random.nextInt(roadComponent.getLinesPerSide() * 4);
                ln = mapper.lineToLineDTO(lineRepository.get(lineNum + 1L).get()); //fixed
            }
            while (ln == null || (ln != null && ln.getStartBlock().getAutomobile() != null));

            RoadBlockDTO startBlock = ln.getStartBlock();
            int autoSpeed  = random.nextInt(roadComponent.getMaxAutoSpeed() - roadComponent.getMinAutoSpeed());

            AutomobileDTO automobileDTO = new AutomobileDTO(autoSpeed + roadComponent.getMinAutoSpeed(),
                    DriveModel.values()[random.nextInt(DriveModel.values().length)],
                    startBlock);
            startBlock.setAutomobile(automobileDTO);
            automobileDTO.setRoadBlock(startBlock);

            var auto = mapper.autoDtoToAuto(automobileDTO);
            automobileRepository.save(auto);
            automobileDTO.setId(auto.getId());
            startBlock.setAutomobile(automobileDTO);

            auto = mapper.autoDtoToAuto(automobileDTO);
            automobileRepository.update(auto);
            roadBlockRepository.update(auto.getRoadBlock());
        }

        var d = automobileRepository.getAll();
        var aaaaaaa = 0;

>>>>>>> origin/master
}
