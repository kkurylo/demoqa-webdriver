package pl.koko.generator;

import org.apache.commons.lang3.RandomStringUtils;
import pl.koko.helper.ConverterPolishLetters;

/**
 * Generuje login i hasło
 */
public class InternetGenerator {

    ConverterPolishLetters converterPolishLetters = new ConverterPolishLetters();

    public String createUsername(String firstName, String lastName, int usernameLength) {
        int basicUsernameLength = (firstName + lastName).length();
        String fullUsername = (firstName + lastName + RandomStringUtils.randomNumeric(usernameLength - basicUsernameLength)).toUpperCase();
        return converterPolishLetters.replacePolishLetters(fullUsername);
    }

    public String createPassword(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }
}
