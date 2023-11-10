package DuckDuckGoSearch;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuckDuckGoMainPage {

    // WebElements for search input and search button
    @FindBy(id = "searchbox_input")
    private WebElement searchInput;
    @FindBy(className = "searchbox_searchButton__F5Bwq")
    private WebElement searchButton;

    // Constructor to initialize the page elements using PageFactory
    public DuckDuckGoMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Method to fill the search input with the provided search phrase
    public void fillSearchInput(String searchPhrase) {
        searchInput.sendKeys(searchPhrase);
    }

    // Method to fill the search input with the provided search phrase and press Enter
    public void fillSearchInputAndEnter(String searchPhrase) {
        searchInput.sendKeys(searchPhrase + Keys.ENTER);
    }

    // Method to click the search button
    public void clickSearchButton() {
        searchButton.click();
    }
}