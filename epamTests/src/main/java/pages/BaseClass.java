package pages;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;


public abstract class BaseClass extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    public static boolean bResult;

    public BaseClass(WebDriver driver){
        BaseClass.driver = driver;
        BaseClass.bResult = true;
    }

    @AfterSuite(alwaysRun = true)
    public void quit()  {
        driver.quit();
    }

    protected void scrollToElement(WebElement element) throws InterruptedException {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(100);
    }

    protected void scrollToFooter () throws InterruptedException {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(100);
    }
}

