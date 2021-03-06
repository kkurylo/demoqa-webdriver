package pl.koko.domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Rejestracja konta w demoqa.com bez ustawiania zdjęcia profilowego
 */
public class RegistrationPage { //TODO wybieranie zdjęcia profilowego

    private WebDriver driver;

    @FindBy(id = "name_3_firstname")
    private WebElement firstNameField;

    @FindBy(id = "name_3_lastname")
    private WebElement lastNameField;

    @FindBy(name = "radio_4[]")
    private List<WebElement> maritalStatusRadioBox;

    @FindBy(name = "checkbox_5[]")
    private List<WebElement> hobbyCheckBox;

    @FindBy(id = "dropdown_7")
    private WebElement countryField;

    @FindBy(id = "mm_date_8")
    private WebElement monthField;

    @FindBy(id = "dd_date_8")
    private WebElement dayField;

    @FindBy(id = "yy_date_8")
    private WebElement yearField;

    @FindBy(id = "phone_9")
    private WebElement phoneField;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "email_1")
    private WebElement emailField;

    @FindBy(id = "description")
    private WebElement descriptionField;

    @FindBy(id = "password_2")
    private WebElement passwordField;

    @FindBy(id = "confirm_password_password_2")
    private WebElement confirmPasswordField;

    @FindBy(name = "pie_submit")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"post-49\"]/div/p")
    private WebElement notificationBox;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get("http://demoqa.com/registration/");
    }

    public void setFirstNameField(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void setLastNameField(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void selectMaritalStatus(int maritalStatus) {
        maritalStatusRadioBox.get(maritalStatus).click();
    }

    public void selectHobby(int hobby) {
        hobbyCheckBox.get(hobby).click();
    } //TODO można wybrać więcej niż jedno hobby

    public void selectCountryField(String country) {
        Select options = new Select(countryField);
        options.selectByVisibleText(country);
    }

    public void selectMonthField(String month) {
        Select options = new Select(monthField);
        options.selectByVisibleText(month);
    }

    public void selectDayField(String day) {
        Select options = new Select(dayField);
        options.selectByVisibleText(day);
    }

    public void selectYearField(String year) {
        Select options = new Select(yearField);
        options.selectByVisibleText(year);
    }

    public void setPhoneField(String phone) {
        phoneField.sendKeys(phone);
    }

    public void setUsernameField(String username) {
        usernameField.sendKeys(username);
    }

    public void setEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void setDescriptionField(String description) {
        descriptionField.sendKeys(description);
    }

    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void setConfirmPasswordField(String password) {
        confirmPasswordField.sendKeys(password);
    }

    public void submit() {
        submitButton.click();
    }

    public boolean tellIfSeeNotificationBoxThanksForRegistration() {
        return notificationBox.isDisplayed();
    }

}
