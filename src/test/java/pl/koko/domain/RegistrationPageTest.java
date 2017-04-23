package pl.koko.domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test poprawnej rejestracji konta w demoqa.com
 */
public class RegistrationPageTest {

    WebDriver driver = new ChromeDriver();
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @BeforeMethod
    public void setUp() {
        registrationPage.openPage();
    }

    @Test
    public void shouldRegisterNewUser() {
        registrationPage.setFirstNameField("Robinson");
        registrationPage.setLastNameField("Cruzoe");
        registrationPage.selectMaritalStatus(1);
        registrationPage.selectHobby(2);
        registrationPage.selectCountryField("Afghanistan");
        registrationPage.selectMonthField("3");
        registrationPage.selectDayField("15");
        registrationPage.selectYearField("2011");
        registrationPage.setPhoneField("48765456789");
        registrationPage.setUsernameField("robinson4567");
        registrationPage.setEmailField("robinsonC@gmail.com");
        registrationPage.setDescriptionField("Being a big man");
        registrationPage.setPasswordField("Password100asskeep");
        registrationPage.setConfirmPasswordField("Password100asskeep");
        registrationPage.submit();

        Assert.assertTrue(registrationPage.tellIfSeeNotificationBoxThanksForRegistration());
    }

    @AfterTest
    public void chillOut() {
        driver.close();
    }
}
