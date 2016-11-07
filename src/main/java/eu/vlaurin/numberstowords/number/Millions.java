package eu.vlaurin.numberstowords.number;

/**
 * @since 1.0
 */
public class Millions extends Multiple {

    private static final String MILLION = "million";

    Millions(Number millions, Number thousands) {
        super(millions, thousands);
    }

    @Override
    protected String getName() {
        return MILLION;
    }
}
