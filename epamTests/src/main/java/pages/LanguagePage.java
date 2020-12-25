package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LanguagePage extends BaseClass {
    public LanguagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//li[contains (@class, 'location-selector__item') and position()=8]")
    public WebElement regionItem;

    public HomePage clickUkrainianRegion() throws InterruptedException {
        System.out.println("Get search title" + regionItem.getText());
        Thread.sleep(200);
        regionItem.click();
        return PageFactory.initElements(driver, HomePage.class);
    }
}
