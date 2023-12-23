package DuckDuckGoSearch;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class SearchWithDuckDuckGoSteps {

    private WebDriver driver;
    private DuckDuckGoMainPage ddgMainPage;
    private DuckDuckGoSearchResultsPage ddgResultsPage;

    // Step for opening the browser and navigating to the given URL
    @Given("Page {word} opened in browser")
    public void pageOpenedInBrowser(String url) {
        this.driver = new FirefoxDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        this.driver.get(url);
        this.ddgMainPage = new DuckDuckGoMainPage(driver);
        this.ddgResultsPage = new DuckDuckGoSearchResultsPage(driver);
    }

    // Step for entering the search phrase in the search input box
    @When("Phrase {string} entered in search input box")
    public void enterPhrase(String searchPhrase) {
        ddgMainPage.fillSearchInput(searchPhrase);
    }

    // Step for clicking the search button
    @And("Search button clicked")
    public void clickSearchButton() {
        ddgMainPage.clickSearchButton();
    }

    // Step for verifying that the specified number of search results contain the given phrase
    @Then("First {int} search result text contain phrase {string}")
    public void resultsShouldContainPhrase(int count, String searchPhrase) {
        List<String> textsFromResultsLinks = ddgResultsPage.getTextsFromResultsLinks();
        for (int i = 0; i < count; i++) {
            String linkTextLower = textsFromResultsLinks.get(i).toLowerCase();
            String searchPhraseLower = searchPhrase.toLowerCase();
            if (!linkTextLower.contains(searchPhraseLower)) {
                Assert.fail(String.format("Search result should contain: %s, but was: %s", searchPhraseLower, linkTextLower));
            }
        }
    }

    // Step for saving a screenshot
    @And("Save screenshot")
    public void saveScreenshot() throws IOException {
        File tmpScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "test", "ddg-search-"+currentDateTime+".png"));
    }

    // Step for closing the browser
    @And("Close browser")
    public void closeBrowser() {
        this.driver.quit();
    }
}
