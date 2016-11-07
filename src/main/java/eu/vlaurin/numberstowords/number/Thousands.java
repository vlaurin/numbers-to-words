package eu.vlaurin.numberstowords.number;

/**
 * @since 1.0
 */
public class Thousands extends Multiple {

    private static final String THOUSAND = "thousand";

    Thousands(Number thousands, Number hundreds) {
        super(thousands, hundreds);
    }

    @Override
    protected String getName() {
        return THOUSAND;
    }
}
