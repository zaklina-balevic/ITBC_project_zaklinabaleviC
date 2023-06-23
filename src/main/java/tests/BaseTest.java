package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private FormPage formPage;
    private AlertsPage alertsPage;
    private PracticeFormPage practiceFormPage;
    private LoginPage loginPage;

    private JavascriptExecutor js;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://Users//hp//Desktop//webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        homePage = new HomePage(driver, wait);
        formPage = new FormPage(driver, wait);
        practiceFormPage = new PracticeFormPage(driver, wait);
        alertsPage = new AlertsPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        js = (JavascriptExecutor) driver;

    }

    @BeforeMethod
    public void beforeEachTest() {
        getDriver().manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public FormPage getFormPage() {
        return formPage;
    }

    public PracticeFormPage getPracticeFormPage() {
        return practiceFormPage;
    }

    public AlertsPage getAlertsPage() {
        return alertsPage;
    }

    public JavascriptExecutor getJs() {
        return js;
    }


    public LoginPage getLoginPage() {
        return loginPage;
    }


    public void scrollDown(int numberOfPixels) {
        getJs().executeScript("window.scrollBy(0," + numberOfPixels + ")", "");
    }

    public void scrollIntoView(WebElement element) {
        getJs().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickOnElement(WebElement element) {
        getJs().executeScript("arguments[0].click()", element);
    }


    public void waitForVisibility(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToTheEnd() {
        getJs().executeScript("window.scrollBy(0,250)", "");
    }


    @AfterClass
    public void cleanUp() {
        driver.close();
    }
}
