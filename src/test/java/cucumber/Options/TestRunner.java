package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = true,features="src/test/java/Features/BookingValidation.feature",
					plugin ="json:target/jsonReports/cucumber-report.json",
					glue= {"StepDefinition"})
public class TestRunner {
	
}
