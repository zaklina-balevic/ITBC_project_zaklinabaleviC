package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FormPage extends BasePage {

    private List<WebElement> buttons;

    public FormPage (WebDriver driver, WebDriverWait wait) {

        super(driver,wait);
    }

    public List<WebElement> getButtons() {
        buttons = getDriver().findElements(By.className("text"));
        return buttons;
    }

    public void clickOnButton(String name) {

        for (int i = 0; i < getButtons().size(); i++) {
            if (getButtons().get(i).getText().equals(name)) {
                getButtons().get(i).click();
                break;
            }
        }
    }


}

