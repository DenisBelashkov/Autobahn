package app.mapper;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import app.DTO.CarDTO;
import app.DTO.TrackCellDTO;
import app.DTO.TrackDTO;
import app.model.Car;
import app.model.Track;
import app.model.TrackCell;
import org.mapstruct.Mapper;

=======

import app.DTO.CarDTO;
import app.DTO.TrackCellDTO;
import app.model.Car;
import app.model.TrackCell;

import java.util.ArrayList;
import java.util.List;
>>>>>>> origin/master

@Mapper(componentModel = "spring")
public abstract class MainMapper {

<<<<<<< HEAD
    public Car carDtoToCar(CarDTO dto) {
        Car car = new Car();

=======
    /*public Car carDtoToCar(CarDTO dto) {
        Car car = new Car();
>>>>>>> origin/master
        car.setSpeed(dto.getSpeed());
        car.setId(dto.getId());

        if (dto.getTrackCell() != null) {
            car.setTrackCell(cellDtoToCellNoReccurency(dto.getTrackCell()));
        }

        return car;
    }

<<<<<<< HEAD
    public CarDTO carToCarDTO(Car ent) {
=======
*//*    public CarDTO carDtoToCarDTO(Car ent) {
>>>>>>> origin/master
        CarDTO dto = new CarDTO();
        dto.setId(ent.getId());
        dto.setSpeed(ent.getSpeed());

        if (ent.getTrackCell() != null) {
<<<<<<< HEAD
            dto.setTrackCell(CellToCellDTOnoReccurencyLazy(ent.getTrackCell()));
=======
            dto.setTrackCell(cellToCellDTOnoReccurencyLazy(ent.getTrackCell()));
>>>>>>> origin/master
            dto.getTrackCell().setCar(dto);
        }

        return dto;
<<<<<<< HEAD
    }


    public List<Car> carDtoToCar(List<CarDTO> dto) {
        List<Car> res = new ArrayList<>();
        for (var item : dto)
            res.add(carDtoToCar(item));
=======
    }*//*

    private CarDTO carToCarDTOLazy(Car ent) {
        CarDTO dto = new CarDTO();
        dto.setId(ent.getId());
        dto.setSpeed(ent.getSpeed());


        return dto;
    }

    public List<Car> carDtoToCar(List<CarDTO> dto) {
        List<Car> res = new ArrayList<>();
        for (var item : dto)
            res.add(this.carDtoToCar(item));
>>>>>>> origin/master

        return res;
    }

    public List<CarDTO> carToCarDTO(List<Car> ent) {
        List<CarDTO> res = new ArrayList<>();
        for (var item : ent)
            res.add(carToCarDTO(item));

        return res;
    }

<<<<<<< HEAD
    public TrackCellDTO CellToCellDTOnoReccurencyLazy(TrackCell ent) {
=======

    public TrackCell cellDtoToCell(TrackCellDTO dto) {
        if (dto == null) {
            return null;
        }

        TrackCell TrackCell = new TrackCell();

        TrackCell.setId(dto.getId());


        if (dto.getLinkNextCell() != null) {
            TrackCell.setNextCell(cellDtoToCell(dto.getLinkNextCell()));

        }

        if (dto.getCar() != null) {
            Car Car = new Car();
            Car.setSpeed(dto.getCar().getSpeed());
            Car.setTrackCell(TrackCell);
            Car.setId(dto.getCar().getId());
            TrackCell.setCar(Car);
        }

        return TrackCell;
    }

    public TrackCell carDtoToCarNoReccurency(TrackCellDTO dto) {
        if (dto == null) {
            return null;
        }

        TrackCell TrackCell = new TrackCell();

        TrackCell.setId(dto.getId());


        if (dto.getLinkNextCell() != null) {
            TrackCell.setNextCell(getTrackCellFromDTOFields(dto.getLinkNextCell()));
        }

        if (dto.getCar() != null) {
            Car Car = new Car();
            Car.setSpeed(dto.getCar().getSpeed());
            Car.setTrackCell(TrackCell);
            Car.setId(dto.getCar().getId());
            TrackCell.setCar(Car);
        }

        return TrackCell;
    }

    public List<TrackCell> carDtoToCarNoReccurency(List<TrackCellDTO> dto) {
        var result = new ArrayList<TrackCell>();
        for (var blockDTO : dto) {
            result.add(cellDtoToCell(blockDTO));
        }
        return result;
    }

    public List<TrackCellDTO> cellToCellDTOnoReccurency(List<TrackCell> ent) {
        var res = new ArrayList<TrackCellDTO>();

        for (var block : ent) {
            res.add(cellToCellDTOnoReccurency(block));
        }

        return res;
    }

    private TrackCell getTrackCellFromDTOFields(TrackCellDTO dto) {
        if (dto == null)
            return null;

        var res = new TrackCell();
        res.setId(dto.getId());
        return res;
    }


    *//*public TrackCellDTO blockToBlockDTO(TrackCell ent) {
>>>>>>> origin/master
        if (ent == null) {
            return null;
        }

        TrackCellDTO dto = new TrackCellDTO();
        dto.setId(ent.getId());

<<<<<<< HEAD
        return dto;
    }

    public TrackDTO TrackToTrackDTO(Track ent) { //only for initialisations
        TrackDTO trackDto = new TrackDTO();
        trackDto.setTrackLength(ent.getLength());
        trackDto.setId(ent.getId());

        ent.getCellList().sort(Comparator.comparingLong(TrackCell::getId));

        var lastCell = cellToCellDTOnoReccurency(ent.getCellList().get(0));
        for (int i = 1; i < ent.getCellList().size(); i++) {
            var newCell = cellToCellDTOnoReccurency(ent.getCellList().get(i));
            // newCell.getLinkNextCell() = lastCell;
            lastCell = newCell;
        }

        trackDto.setStartCell(lastCell);
        return trackDto;
=======

        if (ent.getNextCell() != null) {
            dto.getLinkNextCell()[0] = blockToBlockDTO(ent.getNextCell());
            dto.getCarLinksList()[1] = blockToBlockDTO(ent.getCenterBlock());
            dto.getCarLinksList()[2] = blockToBlockDTO(ent.getRightBlock());
        }

        if (ent.getCar() != null) {
            CarDTO CarDTO = carToCarDTOLazy(ent.getCar());
            CarDTO.setTrackCell(dto);
        }

        return dto;
    }*//*

    public TrackCellDTO cellToCellDTOnoReccurencyLazy(TrackCell ent) {
        if (ent == null) {
            return null;
            
        }

        TrackCellDTO dto = new TrackCellDTO();
        dto.setId(ent.getId());


        if (ent.getCenterBlock() != null) {
            dto.getCarLinksList()[0] = getTrackCellDTOFromFields(ent.getLeftBlock());
            dto.getCarLinksList()[1] = getTrackCellDTOFromFields(ent.getCenterBlock());
            dto.getCarLinksList()[2] = getTrackCellDTOFromFields(ent.getRightBlock());
        }

        return dto;
>>>>>>> origin/master
    }

    public TrackCellDTO cellToCellDTOnoReccurency(TrackCell ent) {
        if (ent == null) {
            return null;
        }

        TrackCellDTO dto = new TrackCellDTO();
        dto.setId(ent.getId());


<<<<<<< HEAD
=======
        if (ent.getCenterBlock() != null) {
            dto.getCarLinksList()[0] = getTrackCellDTOFromFields(ent.getLeftBlock());
            dto.getCarLinksList()[1] = getTrackCellDTOFromFields(ent.getCenterBlock());
            dto.getCarLinksList()[2] = getTrackCellDTOFromFields(ent.getRightBlock());
        }

        if (ent.getCar() != null) {
            dto.setCar(carToCarDTOLazy(ent.getCar()));
            dto.getCar().setTrackCell(dto);
        }

>>>>>>> origin/master
        return dto;
    }


<<<<<<< HEAD

    public TrackCell cellDtoToCellNoReccurency(TrackCellDTO dto) {
        if (dto == null){
            return null;
        }

        TrackCell trackCell = new TrackCell();

        trackCell.setId(dto.getId());


        if (dto.getCar() != null) {
            Car car = new Car();
            car.setSpeed(dto.getCar().getSpeed());
            car.setTrackCell(trackCell);
            car.setId(dto.getCar().getId());
            trackCell.setCar(car);
        }

        return trackCell;
    }

    public TrackDTO lineToLineDTO(Track ent) { //only for initialisations
        TrackDTO lineDto = new TrackDTO();
        lineDto.setTrackLength(ent.getLength());
        lineDto.setId(ent.getId());

        ent.getCellList().sort(Comparator.comparingLong(TrackCell::getId));

        var lastCell = cellToCellDTOnoReccurency(ent.getCellList().get(0));
        for (int i = 1; i < ent.getCellList().size(); i++) {
            var newBlock = cellToCellDTOnoReccurency(ent.getCellList().get(i));
            lastCell = newBlock;
        }

        lineDto.setStartCell(lastCell);
        return lineDto;
    }

}
=======
    private TrackCellDTO getTrackCellDTOFromFields(TrackCell block) {
        if (block == null)
            return null;

        var res = new TrackCellDTO();
        res.setId(block.getId());
        return res;
    }

    public Line lineDtoToLine(LineDTO dto) { // only for generation
        Line line = new Line();
        line.setLineLength(dto.getLineLength());
        line.setId(dto.getId());

        List<TrackCell> lines = new ArrayList<>();
        var block = dto.getStartBlock();

        Stack<TrackCellDTO> stack = new Stack<>();

        while (block != null) {
            stack.add(block);
            block = block.getCarLinksList()[1];
        }

        var lastBlock = blockDtoToBlockNoReccurency(stack.pop());
        lines.add(lastBlock);

        while (stack.size() > 0) {
            var newBlock = blockDtoToBlockNoReccurency(stack.pop());
            newBlock.setCenterBlock(lastBlock);
            lines.add(newBlock);
            lastBlock = newBlock;
        }

        line.setBlockList(lines);
        return line;
    }

    public LineDTO trackToTrackDTO(Line ent) { //only for initialisations
        LineDTO lineDto = new LineDTO();
        lineDto.setLineLength(ent.getLineLength());
        lineDto.setId(ent.getId());

        ent.getBlockList().sort(Comparator.comparingLong(TrackCell::getId));

        var lastBlock = blockToBlockDTOnoReccurency(ent.getBlockList().get(0));
        for (int i = 1; i < ent.getBlockList().size(); i++) {
            var newBlock = blockToBlockDTOnoReccurency(ent.getBlockList().get(i));
            newBlock.getCarLinksList()[1] = lastBlock;
            lastBlock = newBlock;
        }

        lineDto.setStartBlock(lastBlock);
        return lineDto;
    }






*//*    public List<TrackCell> cellDtoToCell(List<TrackCellDTO> dto) {
        List<TrackCell> res = new ArrayList<>();
        for (var dt : dto)
            res.add(blockDtoToBlock(dt));

        return res;
    }


    public List<TrackCellDTO> blockToBlockDTO(List<TrackCell> ent) {
        List<TrackCellDTO> res = new ArrayList<>();
        for (var elem : ent)
            res.add(blockToBlockDTO(elem));

        return res;
    }


    public List<Line> lineDtoToLine(List<LineDTO> dto) {
        List<Line> res = new ArrayList<>();

        for (var item : dto)
            res.add(lineDtoToLine(item));

        return res;
    }*//*


*//*    public List<LineDTO> trackToTrackDTO(List<Line> ent) {
        List<LineDTO> res = new ArrayList<>();

        for (var item : ent)
            res.add(trackToTrackDTO((item)));

        return res;
    }*//*


*/
}

>>>>>>> origin/master
