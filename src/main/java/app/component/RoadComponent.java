package app.component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoadComponent {

    private static final int LINES_PER_SIDE = 1;
    private static final int LINE_LENGTH = 100;

    private static final int MIN_AUTO_SPEED = 1;
    private static final int MAX_AUTO_SPEED = 3;

<<<<<<< HEAD

    @Autowired
    public RoadComponent() {

=======
    private final TrackCellRepositoryStubImpl trackCellRepositoryStubImpl;

    @Autowired
    public RoadComponent(TrackCellRepositoryStubImpl roadBlockRepository) {
        this.trackCellRepositoryStubImpl = roadBlockRepository;
>>>>>>> origin/master
    }

    public int getLinesPerSide() {
        return LINES_PER_SIDE;
    }

    public int getLineLength() {
        return LINE_LENGTH;
    }

    public int getMinAutoSpeed() {
        return MIN_AUTO_SPEED;
    }

    public int getMaxAutoSpeed() {
        return MAX_AUTO_SPEED;
    }


}
