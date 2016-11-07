package eu.vlaurin.numberstowords.number;

/**
 * @since 1.0
 */
public class Tens implements Number {
    public static final String TEN = "ten";
    public static final String TWENTY = "twenty";
    public static final String THIRTY = "thirty";
    public static final String FORTY = "forty";
    public static final String FIFTY = "fifty";
    public static final String SIXTY = "sixty";
    public static final String SEVENTY = "seventy";
    public static final String EIGHTY = "eighty";
    public static final String NINETY = "ninety";
    public static final String ELEVEN = "eleven";
    public static final String TWELVE = "twelve";
    public static final String THIRTEEN = "thirteen";
    public static final String FOURTEEN = "fourteen";
    public static final String FIFTEEN = "fifteen";
    public static final String SIXTEEN = "sixteen";
    public static final String SEVENTEEN = "seventeen";
    public static final String EIGHTEEN = "eighteen";
    public static final String NINETEEN = "nineteen";
    public static final String AND = " and ";

    private final Digit ones;
    private final Integer tens;

    Tens(Integer tens, Digit ones) {
        this.tens = tens;
        this.ones = ones;
    }

    @Override
    public void describeTo(StringBuilder description) {
        final StringBuilder tmpDescription = new StringBuilder();

        if (1 == tens) {
            tmpDescription.append(specialTensToWord());
        } else {
            tmpDescription.append(regularTensToWord());
            ones.describeTo(tmpDescription);
        }

        if (0 < tmpDescription.length()) {
            if (0 < description.length()) {
                description.append(AND);
            }
            description.append(tmpDescription);
        }
    }

    private String specialTensToWord() {
        switch (ones.getDigit()) {
            case 0:
                return TEN;
            case 1:
                return ELEVEN;
            case 2:
                return TWELVE;
            case 3:
                return THIRTEEN;
            case 4:
                return FOURTEEN;
            case 5:
                return FIFTEEN;
            case 6:
                return SIXTEEN;
            case 7:
                return SEVENTEEN;
            case 8:
                return EIGHTEEN;
            case 9:
                return NINETEEN;
        }
        return "";
    }

    private String regularTensToWord() {
        switch (tens) {
            case 2:
                return TWENTY;
            case 3:
                return THIRTY;
            case 4:
                return FORTY;
            case 5:
                return FIFTY;
            case 6:
                return SIXTY;
            case 7:
                return SEVENTY;
            case 8:
                return EIGHTY;
            case 9:
                return NINETY;
        }
        return "";
    }
}
