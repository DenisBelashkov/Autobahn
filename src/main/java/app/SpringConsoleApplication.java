package app;


import app.component.DumbComponent;
import app.config.ApplicationConfig;
import app.service.DumbService;
import app.service.SampleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackageClasses = {DumbService.class,
                ApplicationConfig.class,
                DumbComponent.class})
public class  SpringConsoleApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConsoleApplication.class);
        SampleService sampleService = context.getBean(SampleService.class);
        sampleService.printHello("John");
    }

}

