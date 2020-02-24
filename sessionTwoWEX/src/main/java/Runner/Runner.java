package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/resources/feat/cheapest_book_task.feature",
		glue = "Steps",
		plugin = "pretty",
		monochrome = true,
		dryRun = false
		)
public class Runner {}