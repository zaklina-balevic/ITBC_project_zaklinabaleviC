package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void verifyIfUserCanLoginWithValidCredentials() {

        getLoginPage().open();

        scrollIntoView(getLoginPage().getUserName());
        getLoginPage().enterDataInUserNameField("zb");
        getLoginPage().enterDataInPassword("kt!Eu5a2T$9uyi$");
        scrollIntoView(getLoginPage().getLoginBtn());
        getLoginPage().clickLoginBtn();
        getWait().until(ExpectedConditions.urlContains("/profile"));
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/profile"));
    }

    @Test
    public void verifyIfUserCanLoginWithInvalidCredentials() {
        getLoginPage().open();

        scrollIntoView(getLoginPage().getUserName());
        getLoginPage().enterDataInUserNameField("zb");
        getLoginPage().enterDataInPassword("kt!Eu5a2T$9uyi$");
        scrollIntoView(getLoginPage().getLoginBtn());
        getLoginPage().clickLoginBtn();

        Assert.assertTrue(getDriver().getCurrentUrl().contains("/login"));

    }
    @Test
    public void verifyNewUserBtnLeadsToRegisterPage(){
        getLoginPage().open();
        scrollIntoView(getLoginPage().getNewUserBtn());
        getLoginPage().clickNewUserBtn();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/register"));

    }
}

