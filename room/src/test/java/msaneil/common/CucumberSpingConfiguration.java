package msaneil.common;

import io.cucumber.spring.CucumberContextConfiguration;
import msaneil.RoomApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { RoomApplication.class })
public class CucumberSpingConfiguration {}
