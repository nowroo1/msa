package msaneil.common;

import io.cucumber.spring.CucumberContextConfiguration;
import msaneil.ViewpageApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ViewpageApplication.class })
public class CucumberSpingConfiguration {}
