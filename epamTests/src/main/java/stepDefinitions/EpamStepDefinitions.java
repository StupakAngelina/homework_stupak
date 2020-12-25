package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EpamStepDefinitions {

    public WebDriver driver;

    public EpamStepDefinitions() {
        driver = Hooks.driver;
    }

    @Given("I’m on the epam home page$")
    public void i_am_on_the_epam_home_page() {
        driver.get("http://www.epam.com");
    }

    @When("I click on the search tab and look for \"([^\"]*)\"$")
    public void i_click_on_search_tab(String searchWord) {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickOnButtonSearchTab()
                .setSearchKey(searchWord)
                .clickFindButton();
    }

    @Then("Page title will \"([^\"]*)\"$")
    public void i_should_see_search_page_title(String title) {
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        String pageTitle = searchPage.getSearchTitle();
        assertEquals(title, pageTitle);
    }


    @When("I click on the language tab and select Ukrainian region and English$")
    public void i_click_language_and_select() throws Throwable {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickOnButtonLanguageTab()
                .clickUkrainianRegion();
    }

    @Then("Then the site language will English$")
    public void i_should_see_english_language() throws Throwable {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        String titleAfterChangeRegion = homePage.getTitleOnHomePage();
        assertEquals(titleAfterChangeRegion, "Engineering the Future");
    }

    @Given("I’m on the «careers» page$")
    public void i_am_on_the_epam_careers_page() {
        driver.get("https://careers.epam.ua/");
    }

    @When("I press on a button «contact us$»")
    public void i_press_contact_button() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickOnButtonContactTab();
    }

    @Then("I will go to the «contact» page$")
    public void i_am_on_contact_page() throws InterruptedException {
        ContactPage contactPage = PageFactory.initElements(driver, ContactPage.class);
        String titleOnContactPage = contactPage.getTitleOnContactPage();
        assertEquals(titleOnContactPage, "Head Office in Ukraine");
    }

    @Given("I’m on the «contact» page$")
    public void i_am_on_the_epam_contact_page() {
        driver.get("https://careers.epam.ua/contact");
    }

    @When("I press on a button «submit an application$»")
    public void i_press_submit_application_button() throws InterruptedException {
        ContactPage contactPage = PageFactory.initElements(driver, ContactPage.class);
        contactPage.clickOnContactUs()
                .clickSubmitApplication();
    }

    @Then("The registration form will send$")
    public void i_should_see_application_errors() throws InterruptedException {
        ContactPage contactPage = PageFactory.initElements(driver, ContactPage.class);
        assertTrue(contactPage.applicationErrorIsDisplayed());
    }

    @Given("I'm on the «Our work» page$")
    public void i_am_on_the_epam_our_work_page() {
        driver.get("https://www.epam.com/our-work");
    }

    @When("I press on a button «Healthcare» and click on «Learn more»$")
    public void press_button_healthcare_and_learn_more() throws InterruptedException {
        OurWorkPage ourWorkPage = PageFactory.initElements(driver, OurWorkPage.class);
        ourWorkPage
                .clickHealthcareButton()
                .clickLearnMoreButton();
    }

    @Then("I will go to the page about the solution for this customer$")
    public void i_should_see_page_about_solution() {
        HealthcarePage healthcarePage = PageFactory.initElements(driver, HealthcarePage.class);
        String solutionText = healthcarePage.getSolutionText();
        assertEquals(solutionText, healthcarePage.solutionForAdvocate4MeCustomer);
    }

    @Given("I’m on the «epam» page$")
    public void i_am_on_the_epam_page() {
        driver.get("http://www.epam.com");
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.closeCookiePolicy();

    }

    @When("I scroll down and press on a button «Facebook»$")
    public void i_scroll_down_press_facebook() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.scrollToSocialsIcons()
                .clickFacebookIcon();
    }

    @Then("I will see epam page on Facebook$")
    public void i_should_see_facebook_page() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        String urlInNewTab = driver.getCurrentUrl();
        assertEquals(urlInNewTab, "https://www.facebook.com/EPAM.Global");
    }

    @Given("I’m on any page$")
    public void i_am_on_the_epam_any_page() {
        driver.get("https://careers.epam.ua/contact");
    }

    @When("I press on a button «epam»$")
    public void i_press_logo_epam() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickLogo();
    }

    @Then("I will on the main page$")
    public void i_should_see_main_page() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        driver.getCurrentUrl().contains("https://careers.epam.ua/");
        String titleAfterChangeRegion = homePage.getTitleOnHomePage();
        assertEquals(titleAfterChangeRegion, "Engineering the Future");
    }

    @Given("I’m on the main page$")
    public void i_am_on_the_epam_main_page() {
        driver.get("http://www.epam.com");
    }

    @When("I press on a button «About»$")
    public void i_press_button_about() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickOnButtonLAboutTab();
    }

    @Then("I will go to the page with FAQ$")
    public void i_should_see_page_with_FAQ() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
       String title= homePage.gettitleFAQPage();
       assertEquals(title, "FAQ");
    }
}


