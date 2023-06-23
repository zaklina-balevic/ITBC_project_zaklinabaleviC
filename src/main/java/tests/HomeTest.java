package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test

    public void isElementsClickable() {
        getHomePage().open();
        scrollDown(300);
        getHomePage().clickOnElements();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/elements"));
    }


    @Test
    public void isFormsClickable() {
        getHomePage().open();
        scrollDown(300);
        getHomePage().clickOnForms();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/forms"));
    }

    @Test
    public void isAlertsFrameWindowsClickable() {
        getHomePage().open();
        scrollDown(300);
        getHomePage().clickOnAlerts();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/alertsWindows"));
    }

    @Test
    public void isWidgetsClickable() {

        getHomePage().open();
        scrollDown(300);
        getHomePage().clickOnWidgets();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/widgets"));
    }


    @Test
    public void isInteractionClickable() {
        getHomePage().open();
        scrollDown(300);
        getHomePage().clickOnInteractions();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/interaction"));
    }

    @Test
    public void isBooksClickable() {
        getHomePage().open();
        scrollDown(700);
        getHomePage().clickOnBookstore();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/books"));
    }

}
