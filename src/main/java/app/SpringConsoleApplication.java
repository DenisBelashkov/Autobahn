package app;


<<<<<<< HEAD
import app.DTO.CarDTO;
import app.config.ApplicationConfig;
import app.service.CarGenerationService;
import app.service.CarMovingService;
import app.service.TrackGenerationService;
=======
import app.config.ApplicationConfig;
>>>>>>> origin/master
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
@ComponentScan(basePackageClasses = {ApplicationConfig.class})
public class SpringConsoleApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConsoleApplication.class);
//        var block = context.getBean(RoadGenerationService.class);
//
//        block.initRoad();

//        test.setTrafficLightState(TrafficLightState.RED);
//        var test = new RoadBlock();
//        test.setIsCrossroad(true);
//        block.save(test);
//        var test1 = new RoadBlock();
//        test1.setTrafficLightState(TrafficLightState.RED);
//        test1.setIsCrossroad(true);
//        block.save(test1);


        TrackGenerationService trackService = context.getBean(TrackGenerationService.class);
        trackService.initRoad();
        run();

    }

    private static void run() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConsoleApplication.class);
        TrackGenerationService roadService = context.getBean(TrackGenerationService.class);
        CarGenerationService carGenerationService = context.getBean(CarGenerationService.class);
        CarMovingService carMovingService = context.getBean(CarMovingService.class);


        if (!roadService.isRoadInitiated())
            roadService.initRoad();

        System.out.println("Road Generated");


        carGenerationService.generateCars(8);

        while (carMovingService.getAllCars().size() != 0) {


            System.out.println("Before moving: ");
            printCarsToConsole(carMovingService.getAllCars());

            carMovingService.moveAllCars();

            System.out.println("After moving: ");
            printCarsToConsole(carMovingService.getAllCars());


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printCarsToConsole(List<CarDTO> cars) {
        System.out.println("Car list:");
        cars.forEach(auto -> {
            System.out.println("auto with ID " + auto.getId() + " stands on road block with ID " + auto.getTrackCell().getId().toString() + "\n");
        });
    }


}

