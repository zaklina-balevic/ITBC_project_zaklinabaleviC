package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private WebElement userName;
    private WebElement password;

    private WebElement loginBtn;
    private WebElement newUserBtn;


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getUserName() {
        return userName = getDriver().findElement(By.id("userName"));
    }

    public WebElement getPassword() {
        return password = getDriver().findElement(By.id("password"));
    }

    public WebElement getLoginBtn() {
        return loginBtn = getDriver().findElement(By.id("login"));
    }


    public WebElement getNewUserBtn() {
        return newUserBtn = getDriver().findElement(By.id("newUser"));
    }

    public void enterDataInUserNameField(String userName) {
        getUserName().sendKeys(userName);
    }

    public void enterDataInPassword(String password) {
        getPassword().sendKeys(password);
    }

    public void clickLoginBtn() {
        getLoginBtn().click();
    }

    public void clickNewUserBtn() {
        getNewUserBtn().click();
    }

    public void open() {
        getDriver().get("https://demoqa.com/login");
    }


}
