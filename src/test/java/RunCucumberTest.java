import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        tags = {"@AllureReportOne", "~@AllureReportTwo"},
        features = "src/test/resources/features",
        plugin = {"pretty"},
        strict = true
)
public class RunCucumberTest {
}
