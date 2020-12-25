package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ContactPage extends BaseClass {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = ".title-ui.title--center")
    public WebElement title;

    @FindBy(how = How.CSS, using = "a.button-ui.bg-color-light-blue")
    public WebElement contactUsButton;

    @FindBy(how = How.CSS, using = ".form_row .button-ui-wrapper button")
    public WebElement submitButton;

    @FindBy(how = How.CSS, using = ".checkbox")
    public WebElement checkbox;

    @FindBy(how = How.CSS, using = ".dropdown-list-ui .validation-tooltip .validation-text")
    public WebElement applicationError;


    public String getTitleOnContactPage() throws InterruptedException {
       System.out.println("Check title on contact page");
        Thread.sleep(500);
        return title.getText();
    }

    public ContactPage clickOnContactUs() throws InterruptedException {
        System.out.println("Click on the contact us");
        scrollToFooter();
        contactUsButton.click();
        return this;
    }

    public ContactPage clickSubmitApplication() throws InterruptedException {
        System.out.println("Click submit application button");
        scrollToElement(checkbox);
        submitButton.click();
        return this;
    }

    public boolean applicationErrorIsDisplayed() throws InterruptedException {
        System.out.println("Click submit application button");
        scrollToElement(applicationError);
        return applicationError.isEnabled();
    }


}
