package pl.koko.helper;

/**
 * Sprawdza, czy rok jest przestępny
 */
public class LeapYearValidator {

    public boolean validateYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
}
