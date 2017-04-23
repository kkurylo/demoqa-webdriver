package pl.koko.domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationPageTest {

    WebDriver driver = new ChromeDriver();
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @BeforeMethod
    public void setUp() {
        registrationPage.openPage();
    }

    @Test
    public void shouldRegisterNewUser() throws InterruptedException {
        registrationPage.setFirstNameField("Napoleon");
        registrationPage.setLastNameField("Bonaparte");
        registrationPage.selectMaritalStatus(1);
        registrationPage.selectHobby(2);
        registrationPage.selectCountryField("Brazil");
        registrationPage.selectMonthField("4");
        registrationPage.selectDayField("14");
        registrationPage.selectYearField("2012");
        registrationPage.setPhoneField("4834567890");
        registrationPage.setUsernameField("napoleonBonaparte4567");
        registrationPage.setEmailField("napoleonBonaparte@gmail.com");
        registrationPage.setDescriptionField("Being a lady");
        registrationPage.setPasswordField("Password100pas");
        registrationPage.setConfirmPasswordField("Password100pas");
    }

    @AfterTest
    public void chillOut() {
        driver.close();
    }
}
