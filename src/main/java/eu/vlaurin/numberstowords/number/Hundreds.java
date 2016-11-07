package eu.vlaurin.numberstowords.number;

/**
 * @since 1.0
 */
public class Hundreds extends Multiple {

    private static final String HUNDRED = "hundred";

    Hundreds(Integer hundreds, Tens tens) {
        super(new Digit(hundreds), tens);
    }

    Hundreds(Digit hundreds, Tens tens) {
        super(hundreds, tens);
    }

    @Override
    protected String getName() {
        return HUNDRED;
    }
}
