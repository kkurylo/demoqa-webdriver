package pl.koko.helper;

/**
 * Zamienia w słowie polskie litery z ogonkami na łacińskie bez ogonków
 */
public class ConverterPolishLetters {

    public String replacePolishLetters(String word) {
        return word
                .replace("ą", "a")
                .replace("ć", "c")
                .replace("ę", "e")
                .replace("ł", "l")
                .replace("ń", "n")
                .replace("ó", "o")
                .replace("ś", "s")
                .replace("ź", "z")
                .replace("ż", "z");
    }
}
