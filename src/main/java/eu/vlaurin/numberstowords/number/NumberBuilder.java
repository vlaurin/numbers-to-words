package eu.vlaurin.numberstowords.number;

/**
 * @since 1.0
 */
public class NumberBuilder {
    private Integer millions = 0;
    private Integer thousands = 0;
    private Integer hundreds = 0;

    public NumberBuilder millions(Integer millions) {
        // TODO Add validation (range 0 - 999)
        this.millions = millions;
        return this;
    }

    public NumberBuilder thousands(Integer thousands) {
        // TODO Add validation (range 0 - 999)
        this.thousands = thousands;
        return this;
    }

    public NumberBuilder hundreds(Integer hundreds) {
        // TODO Add validation (range 0 - 999)
        this.hundreds = hundreds;
        return this;
    }

    public Number build() {
        if (0 == hundreds
                && 0 == thousands
                && 0 == millions) {
            return Digit.ZERO;
        } else {
            Number number = buildAHundreds(hundreds);
            if (thousands > 0) {
                number = new Thousands(buildAHundreds(thousands), number);
            }

            if (millions > 0) {
                number = new Millions(buildAHundreds(millions), number);
            }

            return number;
        }
    }

    private Hundreds buildAHundreds(Integer number) {
        final Integer ones = number % 10;
        final Integer tens = (number / 10) % 10;
        final Integer hundreds = (number / 100) % 10;

        return new Hundreds(hundreds, new Tens(tens, new Digit(ones)));
    }

    /**
     * Creates a number builder initialised with the number parsed.
     *
     * @param number a number in the range 0 to 999,999,999 inclusive
     * @return a number builder initialised with the number parsed
     */
    public static NumberBuilder parse(Integer number) {
        if (null == number) {
            throw new IllegalArgumentException("Number cannot be null");
        }

        if (0 > number || 999999999 < number) {
            throw new IllegalArgumentException("Number must be in range 0 to 999,999,999");
        }

        final NumberBuilder builder = new NumberBuilder();

        builder.hundreds(number % 1000);
        number = number / 1000;
        builder.thousands(number % 1000);
        number = number / 1000;
        builder.millions(number % 1000);

        return builder;
    }
}
