package eu.vlaurin.numberstowords.number;

/**
 * @since 1.0
 */
public class Digit implements Number {
    public static final Number ZERO = description -> description.append("zero");

    public static final String ONE = "one";
    public static final String TWO = "two";
    public static final String THREE = "three";
    public static final String FOUR = "four";
    public static final String FIVE = "five";
    public static final String SIX = "six";
    public static final String SEVEN = "seven";
    public static final String EIGHT = "eight";
    public static final String NINE = "nine";

    private static final String SPACE = " ";

    private final Integer digit;

    Digit(Integer digit) {
        if (0 > digit || 9 < digit)
            throw new IllegalArgumentException("Digit must between 0 and 9");
        this.digit = digit;
    }

    @Override
    public void describeTo(StringBuilder description) {
        final String digitWords = toWords();
        if (0 < digitWords.length()) {
            if (0 < description.length()) {
                description.append(SPACE);
            }
            description.append(digitWords);
        }
    }

    private String toWords() {
        switch (digit) {
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            case 6:
                return SIX;
            case 7:
                return SEVEN;
            case 8:
                return EIGHT;
            case 9:
                return NINE;
        }
        return "";
    }

    public Integer getDigit() {
        return digit;
    }
}
