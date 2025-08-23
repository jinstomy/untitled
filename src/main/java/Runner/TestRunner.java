package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import javax.swing.text.html.HTML;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/main/java/features",


glue = {"stepdefenition"},
        tags = "@smoke",
plugin = {"pretty", "html:target/cucumber-reports.html","rerun:target/failed_scenarios.txt"})

public class TestRunner {





}
