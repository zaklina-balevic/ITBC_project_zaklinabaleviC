package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {


    @Test
    public void userClickOnAlertButton() {

        getAlertsPage().open();
        scrollToTheEnd();
        getAlertsPage().clickOnButtonAlert();
        Alert alert = getWait().until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        Assert.assertEquals("You clicked a button", alertText);
        alert.accept();
    }

    @Test
    public void userClickOnAlertButtonAlertShowsAfter5s() {
        getAlertsPage().open();
        scrollToTheEnd();
        getAlertsPage().clickOnButtonAlertAfter5s();
        getWait().until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals("This alert appeared after 5 seconds", alertText);
        alert.accept();
    }

    @Test
    public void userClickOnConfirmBoxButton() {
        getAlertsPage().open();
        scrollToTheEnd();
        getAlertsPage().clickOnConfirmButton();

        Alert alert = getWait().until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        Assert.assertEquals("Do you confirm action?", alertText);
        alert.accept();

        String result = getAlertsPage().getConfirmText().getText();
        Assert.assertEquals("You selected Ok", result);
    }

    @Test
    public void userClickCancelOnConfirmBoxButton() {
        getAlertsPage().open();
        scrollToTheEnd();
        getAlertsPage().clickOnConfirmButton();
        Alert alert = getWait().until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();

        Assert.assertEquals("Do you confirm action?", alertText);
        alert.dismiss();

        String result = getAlertsPage().getConfirmText().getText();
        Assert.assertEquals("You selected Cancel", result);
    }

    @Test
    public void userClickOnPromptBoxButton() {
        getAlertsPage().open();
        scrollToTheEnd();

        getAlertsPage().clickOnPromptBoxButton();
        Alert alert = getWait().until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        Assert.assertEquals("Please enter your name", alertText);
        String name = "Zaklina";
        alert.sendKeys(name);
        alert.accept();

        String result = getAlertsPage().getPromptText().getText();
        Assert.assertEquals("You entered " + name, result);
    }
}
