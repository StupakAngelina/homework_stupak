package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HealthcarePage extends BaseClass {
    public HealthcarePage(WebDriver driver) {
        super(driver);
    }

    public String solutionForAdvocate4MeCustomer="The nation’s largest health carrier," +
            " UnitedHealthcare, recognized the need to be more customer-centric." +
            " When EPAM Continuum started working with UHC, the Affordable Care Act was imminent, and the organiza­tion " +
            "was ready to define a future-forward vision for their ideal service experience. They wanted to help " +
            "members quickly resolve their medical issues so they could focus " +
            "on what mattered most: their health and their family.";


    @FindBy(how = How.CSS, using = ".rollover-blocks__block a.rollover-blocks__link")
    public WebElement learnMoreButton;

    @FindBy(how = How.CSS, using = ".left-column-container .text-ui")
    public WebElement solutionText;

    @FindBy(how = How.CSS, using =".rollover-blocks__content")
    public WebElement customers;



    public HealthcarePage clickLearnMoreButton() throws InterruptedException {
        System.out.println("Click learn more button at CUSTOMER SOLUTIONS");
        scrollToElement(learnMoreButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(customers).build().perform();;
        learnMoreButton.click();
        return this;
    }

    public String  getSolutionText() {
        System.out.println("Get solution text");
        return solutionText.getText();
    }
}

