package DuckDuckGoSearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DuckDuckGoSearchResultsPage {

    // List of WebElements representing search result links
    @FindBy(css = "ol.react-results--main li article h2 a")
    private List<WebElement> resultsLinks;

    // Constructor to initialize the page elements using PageFactory
    public DuckDuckGoSearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Method to retrieve the text from each search result link and store it in a list
    public List<String> getTextsFromResultsLinks() {
        List<String> result = new ArrayList<>();

        // Loop through each WebElement in resultsLinks and add its text to the result list
        for (WebElement we : resultsLinks) {
            result.add(we.getText());
        }

        return result;
    }
}