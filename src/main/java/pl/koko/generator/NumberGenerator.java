package pl.koko.generator;

import java.util.Random;

/**
 * Generuje liczby z zakresu <0, maxNumber-1>
 */
public class NumberGenerator {

    Random random = new Random();

    public int randomNumberfrom0(int maxNumber) {
        return random.nextInt(maxNumber);
    }
}
