package app.service;


import app.component.SampleComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    private SampleComponent sampleComponent;

    public void printHello(String name) {
        System.out.println(sampleComponent.getCurrentDate());
        System.out.println("Hello " + name);
    }

    @Autowired
    public void setSampleComponent(SampleComponent sampleComponent) {
        this.sampleComponent = sampleComponent;
    }
}
