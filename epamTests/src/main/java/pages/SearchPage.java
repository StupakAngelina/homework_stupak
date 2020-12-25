package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPage extends BaseClass {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = ".title--center")
    public WebElement searchTitle;

    @FindBy(how = How.ID, using = "new_form_search")
    public WebElement searchInput;

    @FindBy(how = How.CSS, using = ".header-search__submit")
    public WebElement findButton;


    public String getSearchTitle() {
        System.out.println("Get search title" + searchTitle.getText());
        return searchTitle.getText();
    }

    public SearchPage setSearchKey(String searchWord) {
        System.out.println("Set" + searchWord + "to search input field");
        searchInput.sendKeys(searchWord);
        return this;
    }

    public SearchPage clickFindButton() {
        System.out.println("Click find button");
        findButton.click();
        return this;
    }
}
