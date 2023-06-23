package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends BasePage {

    private WebElement alertButton1;
    private WebElement alertButton2;
    private WebElement alertButton3;
    private WebElement confirmText;
    private WebElement alertButton4;
    private WebElement promptText;

    public AlertsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getAlertButton1() {

        return alertButton1 = getDriver().findElement(By.id("alertButton"));
    }

    public WebElement getAlertButton2() {

        return alertButton2 = getDriver().findElement(By.id("timerAlertButton"));
    }

    public WebElement getAlertButton3() {
        return alertButton3 = getDriver().findElement(By.id("confirmButton"));
    }

    public WebElement getAlertButton4() {

        return alertButton4 = getDriver().findElement(By.id("promtButton"));
    }

    public WebElement getConfirmText() {

        return confirmText = getDriver().findElement(By.id("confirmResult"));
    }


    public WebElement getPromptText() {

        return promptText = getDriver().findElement(By.id("promptResult"));
    }


    public void clickOnButtonAlert() {
        getAlertButton1().click();
    }

    public void clickOnButtonAlertAfter5s() {

        getAlertButton2().click();
    }

    public void clickOnConfirmButton() {

        getAlertButton3().click();
    }

    public void clickOnPromptBoxButton() {

        getAlertButton4().click();
    }

    public void open() {
        getDriver().get("https://demoqa.com/alerts");

    }

}

