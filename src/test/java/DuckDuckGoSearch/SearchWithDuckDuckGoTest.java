package DuckDuckGoSearch;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/DuckDuckGoSearchCucu.feature",
        plugin = {"pretty"
                , "json:target/cucumber-reports/Cucumber.json"
                , "junit:target/cucumber-reports/Cucumber.xml"
                , "html:target/cucumber-reports/cucumber-report.html"
        })
public class SearchWithDuckDuckGoTest {
    // This class is a Cucumber test class for the 'search-with-duck-duck-go.feature' feature.

    // It uses the CucumberOptions annotation to define various configurations:
    // - The location of the feature file ('src/cucumber/features/search-with-duck-duck-go.feature').
    // - Plugins for generating different types of reports (pretty, json, junit, html).
    //   The reports are stored in the 'target/cucumber-reports/' directory.

    // The @RunWith(Cucumber.class) annotation is used to specify that JUnit should use Cucumber as the test runner.
}
