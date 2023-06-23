package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTest extends BaseTest {

    @Test
    public void verifyThatFormsBtnLeadsUsToFormsPageAndOpenPracticeForm() {
        getHomePage().open();
        scrollDown(300);
        getHomePage().clickOnForms();
        scrollDown(300);

        Assert.assertTrue(getDriver().getCurrentUrl().contains("/forms"));

        getFormPage().clickOnButton("Practice Form");
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/automation-practice-form"));
    }

    @Test
    public void verifyIfTheUseCanSubmitTheFormWithoutFillingAnyFields() {
        getPracticeFormPage().open();
        clickOnElement(getPracticeFormPage().getSubmitButton());
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://demoqa.com/automation-practice-form");
    }

    @Test
    public void verifyIfTheUserCanSubmitTheFormWithFillingOnlyMandatoryFields() {
        getPracticeFormPage().open();
        scrollIntoView(getPracticeFormPage().getFirstNameField());
        getPracticeFormPage().enterFirstName("Test1");
        getPracticeFormPage().enterLastName("Test2");
        getPracticeFormPage().clickOnGenderButton("Male");
        getPracticeFormPage().enterMobilePhoneNumber("1234567890");
        clickOnElement(getPracticeFormPage().getSubmitButton());
        waitForVisibility(getPracticeFormPage().getCloseSubmitBtn());
        Assert.assertEquals(getPracticeFormPage().getAssertionMessage().getText(), "Thanks for submitting the form");
    }

    @Test
    public void verifySelectionOfMultipleHobbies() {
        getPracticeFormPage().open();
        scrollIntoView(getPracticeFormPage().getFirstNameField());
        getPracticeFormPage().enterFirstName("Test1");
        getPracticeFormPage().enterLastName("Test2");
        getPracticeFormPage().clickOnGenderButton("Female");
        getPracticeFormPage().enterMobilePhoneNumber("1234567890");
        getPracticeFormPage().selectHobbies("Sports");
        getPracticeFormPage().selectHobbies("Reading");
        getPracticeFormPage().selectHobbies("Music");
        clickOnElement(getPracticeFormPage().getSubmitButton());

        Assert.assertEquals(getPracticeFormPage().getAssertionMessage().getText(), "Thanks for submitting the form");

    }
}
