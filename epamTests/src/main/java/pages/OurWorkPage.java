package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OurWorkPage extends BaseClass {
    public OurWorkPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = "li:nth-child(8).in-page-navigation__item")
    public WebElement healthcare;

    public HealthcarePage clickHealthcareButton() {
        System.out.println("Click healthcare button");
        healthcare.click();
        return PageFactory.initElements(driver, HealthcarePage.class);
    }
}
