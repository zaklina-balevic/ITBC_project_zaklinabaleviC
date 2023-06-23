package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PracticeFormPage extends BasePage {
    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement emailField;
    private List<WebElement> gendersRadioBtns;
    private WebElement mobileNumberField;
    private WebElement dateOfBirth;
    private WebElement monthDropDown;
    private WebElement monthPicker;
    private WebElement yearDropDown;
    private WebElement yearPicker;
    private List<WebElement> dayPick;
    private List<WebElement> subjectsAutoComplete;
    private List<WebElement> hobbiesCheckBoxes;
    private WebElement uploadPictureButton;
    private WebElement addressTextArea;
    private WebElement selectState;
    private WebElement city;
    private WebElement submitButton;
    private WebElement assertionMessage;
    private WebElement closeSubmitBtn;

    public PracticeFormPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getFirstNameField() {
        firstNameField = getDriver().findElement(By.id("firstName"));
        return firstNameField;
    }

    public WebElement getLastNameField() {
        lastNameField = getDriver().findElement(By.id("lastName"));
        return lastNameField;
    }

    public WebElement getEmailField() {
        emailField = getDriver().findElement(By.id("userEmail"));
        return emailField;
    }

    public List<WebElement> getGendersRadioBtns() {
        gendersRadioBtns = getDriver().findElements (By.cssSelector(".custom-control.custom-radio.custom-control-inline"));
        return gendersRadioBtns;
    }

    public WebElement getDateOfBirth() {
        dateOfBirth = getDriver().findElement(By.id("dateOfBirthInput"));
        return dateOfBirth;
    }

    public WebElement getMobileNumberField() {
        mobileNumberField = getDriver().findElement(By.id("userNumber"));
        return mobileNumberField;
    }

    public WebElement getMonthDropDown() {
        monthDropDown = getDriver().findElement(By.className("react-datepicker__month-dropdown-container"));
        return monthDropDown;
    }

    public WebElement getMonthPicker() {
        monthPicker = getDriver().findElement(By.className("react-datepicker__month-select"));
        return monthPicker;
    }

    public WebElement getYearDropDown() {
        yearDropDown = getDriver().findElement(By.className("react-datepicker__year-dropdown-container"));
        return yearDropDown;
    }

    public WebElement getYearPicker() {
        yearPicker = getDriver().findElement(By.className("react-datepicker__year-select"));
        return yearPicker;
    }

    public List<WebElement> getDayPick() {
        dayPick = getDriver().findElements(By.className("react-datepicker__day"));
        return dayPick;
    }

    public List<WebElement> getSubjectsAutoComplete() {
        subjectsAutoComplete = getDriver().findElements(By.className("subjects-auto-complete__value-container--is-multi"));
        return subjectsAutoComplete;
    }

    public List<WebElement> getHobbiesCheckBoxes() {
        hobbiesCheckBoxes = getDriver().findElements(By.id("custom-control-input"));
        return hobbiesCheckBoxes;
    }

    public WebElement getUploadPictureButton() {
        uploadPictureButton = getDriver().findElement(By.id("uploadPicture"));
        return uploadPictureButton;
    }

    public WebElement getAddressTextArea() {
        addressTextArea = getDriver().findElement(By.id("currentAddress"));
        return addressTextArea;
    }

    public WebElement getSelectState() {
        selectState = getDriver().findElement(By.id("state"));
        return selectState;
    }

    public WebElement getCity() {
        city = getDriver().findElement(By.id("city"));


        return city;
    }

    public WebElement getSubmitButton() {
        submitButton = getDriver().findElement(By.id("submit"));
        return submitButton;
    }

    public WebElement getAssertionMessage() {
        assertionMessage = getDriver().findElement(By.id("example-modal-sizes-title-lg"));
        return assertionMessage;
    }

    public WebElement getCloseSubmitBtn() {
        return closeSubmitBtn = getDriver().findElement(By.id("closeLargeModal"));
    }

    public void enterFirstName(String firstName) {
        getFirstNameField().click();
        firstNameField.sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        getLastNameField().click();
        lastNameField.sendKeys(lastName);
    }
    public void enterEmail(String email) {
        getEmailField().click();
       emailField.sendKeys(email);
    }

    public void clickOnGenderButton(String gender) {

        List<WebElement> genderButtons = getGendersRadioBtns();

        for (WebElement genderButton : genderButtons) {
            if (genderButton.getText().equals(gender)) {
                genderButton.click();
                return;
            }
        }

        System.out.println("Gender button not found: " + gender);
    }


    public void enterMobilePhoneNumber(String phoneNumber) {
        getMobileNumberField().click();
        mobileNumberField.sendKeys(phoneNumber);
    }
    public String getMobileNumberFieldBorderColor() {
        return mobileNumberField.getCssValue("border-color");
    }

    public void selectDateOfBirth(String month, String year) {
        dateOfBirth.click();
        monthDropDown.click();
        selectOptionFromDropdown(monthPicker, month);
        yearDropDown.click();
        selectOptionFromDropdown(yearPicker, year);
    }

    private void selectOptionFromDropdown (WebElement dropdown, String option) {
        List<WebElement> options = dropdown.findElements(By.tagName("option"));
        for (WebElement optionElement : options) {
            if (optionElement.getText().equals(option)) {
                optionElement.click();
                return;
            }
        }
        System.out.println("Option not found in dropdown: " + option);
    }

    public void selectDayOfBirth(String day) {
        for (WebElement dayElement : dayPick) {
            if (dayElement.getText().equals(day)) {
                dayElement.click();
                return;
            }
        }
        System.out.println("Invalid day of birth: " + day);
    }

    public void addSubjects(String subject) {
        for (WebElement subjectElement : subjectsAutoComplete) {
            if (subjectElement.getText().equals(subject)) {
                subjectElement.click();
                return;
            }
        }
        System.out.println("Subject not found: " + subject);
    }

    public void selectHobbies(String hobby) {

        List<WebElement> hobbies = getHobbiesCheckBoxes();

        for (WebElement hobbyElement : hobbiesCheckBoxes) {
            if (hobbyElement.getText().equals(hobby)) {
                hobbyElement.click();
                return;
            }
        }
        System.out.println("Hobby not found: " + hobby);
    }

    public void uploadPhoto(String filePath) {
        filePath = "C://Users//hp//Desktop";
        uploadPictureButton.sendKeys(filePath);
    }

    public void addCurrentAddress(String adress) {
       addressTextArea.sendKeys(adress);
    }

    public void addStateAndCity(String state, String city) {
        selectState.sendKeys(state);
        this.city.sendKeys(city);
    }
    public void open (){
        getDriver().get("https://demoqa.com/automation-practice-form");
    }
}
