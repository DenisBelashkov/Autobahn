package app.component;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SampleComponent {

    public Date getCurrentDate() {
        return new Date();
    }
}
