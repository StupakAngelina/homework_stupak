package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = ".header-search__button")
    public WebElement searchTab;
    @FindBy(how = How.CSS, using = ".location-selector__button")
    public WebElement languageTab;
    @FindBy(how = How.CSS, using = ".title-ui.title--center")
    public WebElement title;
    @FindBy(how = How.CSS, using = ".title")
    public WebElement titleFAQPage;
    @FindBy(how = How.XPATH, using = "//li[contains (@class, 'top-navigation__item') and position()=6]")
    public WebElement contactTab;
    @FindBy(how = How.CSS, using = ".header__logo")
    public WebElement logoEpam;
    @FindBy(how = How.CSS, using = ".footer__socials")
    public WebElement socialsIcons;
    @FindBy(how = How.CSS, using = "li:nth-child(3) .footer__social-link")
    public WebElement facebookIcon;
    @FindBy(how = How.CSS, using = ".cookie-disclaimer__button")
    public WebElement cookiePolice;
    @FindBy(how = How.XPATH, using = "//li[contains (@class, 'top-navigation__item') and position()=5]")
    public WebElement aboutTab;
    @FindBy(how = How.XPATH, using = "//li[contains (@class, 'top-navigation__sub-item') and  contains (.,'FAQ')]")
    public WebElement FAQ;

    public SearchPage clickOnButtonSearchTab() {
        System.out.println("Click on the search tab");
        searchTab.click();
        return PageFactory.initElements(driver, SearchPage.class);
    }

    public LanguagePage clickOnButtonLanguageTab() {
        System.out.println("Click on the language tab");
        languageTab.click();
        return PageFactory.initElements(driver, LanguagePage.class);
    }

    public ContactPage clickOnButtonContactTab() {
        System.out.println("Click on the contact tab");
        contactTab.click();
        return PageFactory.initElements(driver, ContactPage.class);
    }

    public String getTitleOnHomePage() throws InterruptedException {
        System.out.println("Check title on home page");
        Thread.sleep(200);
        return title.getText();
    }

    public HomePage clickLogo() throws InterruptedException {
        System.out.println("Click logo");
        logoEpam.click();
        Thread.sleep(200);
        return this;
    }

    public HomePage scrollToSocialsIcons() throws InterruptedException {
        System.out.println("Scroll to facebook icon");
        scrollToElement(socialsIcons);
        return this;
    }

    public void clickFacebookIcon() throws InterruptedException {
        System.out.println("Click facebook icon");
        facebookIcon.click();
        Thread.sleep(500);
    }

    public void closeCookiePolicy () {
        cookiePolice.click();
    }

    public HomePage clickOnButtonLAboutTab() throws InterruptedException {
        System.out.println("Click on the about tab");
        Actions actions = new Actions(driver);
        actions.moveToElement(aboutTab).build().perform();
        FAQ.click();
        return this;
    }

    public String  gettitleFAQPage () {
       return titleFAQPage.getText();
    }
}

