package pl.koko.domain;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.koko.generator.DateGenerator;
import pl.koko.generator.InternetGenerator;
import pl.koko.generator.NumberGenerator;

/**
 * Test poprawnej rejestracji konta w demoqa.com, bez sprawdzania poprawności ustawiania zdjęcia profilowego
 */
public class RegistrationPageTest {

    WebDriver driver = new ChromeDriver();
    RegistrationPage registrationPage = new RegistrationPage(driver);
    Faker faker = new Faker();
    InternetGenerator internetGenerator = new InternetGenerator();
    NumberGenerator numberGenerator = new NumberGenerator();
    DateGenerator dateGenerator = new DateGenerator();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String password = internetGenerator.createPassword(15);
    String country = faker.address().country(); //TODO nie wszystkie wylosowane państwa są do wyboru w rozwijanej liście
    String year = dateGenerator.generateYear();
    String month = dateGenerator.generateMonth();
    String day = dateGenerator.generateDay(month, year);
    String phone = RandomStringUtils.randomNumeric(10);
    String username = internetGenerator.createUsername(firstName, lastName, 14);
    String email = faker.internet().emailAddress();
    String description = "This is description";

    @BeforeMethod
    public void setUp() {
        registrationPage.openPage();
    }

    @Test
    public void shouldRegisterNewUser() {
        registrationPage.setFirstNameField(firstName);
        registrationPage.setLastNameField(lastName);
        registrationPage.selectMaritalStatus(numberGenerator.randomNumberfrom0(3));
        registrationPage.selectHobby(numberGenerator.randomNumberfrom0(3));
        registrationPage.selectCountryField(country);
        registrationPage.selectMonthField(month);
        registrationPage.selectDayField(day);
        registrationPage.selectYearField(year);
        registrationPage.setPhoneField(phone);
        registrationPage.setUsernameField(username);
        registrationPage.setEmailField(email);
        registrationPage.setDescriptionField(description);
        registrationPage.setPasswordField(password);
        registrationPage.setConfirmPasswordField(password);
        registrationPage.submit();

        Assert.assertTrue(registrationPage.tellIfSeeNotificationBoxThanksForRegistration());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
