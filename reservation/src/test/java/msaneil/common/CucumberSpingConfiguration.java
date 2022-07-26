package msaneil.common;

import io.cucumber.spring.CucumberContextConfiguration;
import msaneil.ReservationApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ReservationApplication.class })
public class CucumberSpingConfiguration {}
