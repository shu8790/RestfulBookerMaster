package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false,features="src/test/java/Features/BookingValidation.feature",
					plugin ={ "pretty","json:target/jsonReports/cucumber-report.json"},
					glue= {"StepDefinition"},
					monochrome = true
					)
public class TestRunner {
	
}
