package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/Features",
		glue= {"stepDefinitions"},
		//tags= "@activity1_1" 
		//tags= "@activity1_2" 
	    tags= "@activity2_5", 
		//tags="@jobboard_1",
		//plugin = {"html:reports/Htmlreport.html"},
	    monochrome = true
	
		)

public class ActivitiesRunner {

}
