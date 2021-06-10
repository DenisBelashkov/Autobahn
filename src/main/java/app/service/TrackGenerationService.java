package app.service;

<<<<<<< HEAD
import app.DTO.TrackCellDTO;
import app.DTO.TrackDTO;
import app.component.RoadComponent;
import app.mapper.MainMapper;
import app.repository.TrackCellRepository;
import app.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TrackGenerationService {
    private final RoadComponent roadComponent;

    private final TrackRepository trackRepository;
    private final TrackCellRepository trackCellRepository;

    private final MainMapper mapper;

    @Autowired
    public TrackGenerationService(RoadComponent roadComponent, TrackRepository trackRepository, TrackCellRepository trackCellRepository, MainMapper mapper) {
        this.roadComponent = roadComponent;
        this.trackRepository = trackRepository;
        this.trackCellRepository = trackCellRepository;
        this.mapper = mapper;
    }


    public void initRoad() {

        generateRoad();
        initTrafficLights();
    }

    public boolean isRoadInitiated() {
        return trackCellRepository.getAll().size() == roadComponent.getLineLength() * roadComponent.getLinesPerSide() * 4;
    }

    private void generateRoad() {
        //инициирует дороги и связывает однонаправленные

        List<TrackDTO> tracks = new ArrayList<>();

        for (int index = 0; index < 4; index++) {
            for (int j = 0; j < roadComponent.getLinesPerSide(); j++) {
                //lineRepository.save(new Line(roadComponent.getLineLength()));
                initLine(roadComponent.getLineLength());

                if (j > 0) {
                    var firstLine = trackRepository.get((long) (index * roadComponent.getLinesPerSide() + j)).get();
                    if (!tracks.stream().anyMatch(dto -> dto.getId() == firstLine.getId()))
                        tracks.add(mapper.lineToLineDTO(firstLine));

                    var aaa = mapper.lineToLineDTO(firstLine);

                    var secLine = trackRepository.get((long) (index * roadComponent.getLinesPerSide() + j + 1)).get(); // FIXED COUNTER
                    if (!tracks.stream().anyMatch(dto -> dto.getId() == secLine.getId()))
                        tracks.add(mapper.lineToLineDTO(secLine));


                }
            }
        }

        //  List<Line> linesList = lineRepository.getAll();
        final int LINES_PER_SIDE = roadComponent.getLinesPerSide();
        final int LINE_LENGTH = roadComponent.getLineLength();
        final int LINE_COUNT = roadComponent.getLinesPerSide() * 4;


    }

    public void initLine(int lineLength) {

        TrackCellDTO startBlock = new TrackCellDTO();
        TrackCellDTO curr = startBlock;

        //roadBlockRepository.save(startBlock);

        for (int i = 0; i < lineLength - 1; i++) {
            TrackCellDTO next = new TrackCellDTO();
            curr = next;
        }

    }

    private void linkRoadBlocksByIndex(TrackCellDTO from, TrackCellDTO to, int index) {
        if (index < 0 || index > 2)
            return;


    }

    private TrackCellDTO getRoadBlockShiftByIndex(TrackCellDTO stratBlock, int index) {
        TrackCellDTO block = stratBlock;
        for (int i = 0; i < index; i++)
            block = block.getLinkNextCell();

        return block;
    }

    private void initTrafficLights() {
        final int LINE_LENGTH = roadComponent.getLineLength();
        final int LINES_PER_SIDE = roadComponent.getLinesPerSide();

        for (int index = 0; index < 4; index++) {
            List<TrackCellDTO> TrackCellDTOS = new ArrayList<>();

            for (int j = 0; j < roadComponent.getLinesPerSide(); j++) {
                TrackCellDTO block = getRoadBlockShiftByIndex(
                        mapper.lineToLineDTO(trackRepository.get((long) (index * roadComponent.getLinesPerSide() + j + 1)).get()).getStartCell(), //fixed
                        (LINE_LENGTH / 2 - LINES_PER_SIDE - 2));

                TrackCellDTOS.add(block);


            }


        }
    }


=======
public class TrackGenerationService {
>>>>>>> origin/master
}
