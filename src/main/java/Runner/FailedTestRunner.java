package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="@target/failed_scenarios.txt",
        glue = {"stepdefenition"},
        plugin = {"pretty", "html:target/rerun-reports.html"})
public class FailedTestRunner {
}
