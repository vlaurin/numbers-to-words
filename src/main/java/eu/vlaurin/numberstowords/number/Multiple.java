package eu.vlaurin.numberstowords.number;

/**
 * @since 1.0
 */
public abstract class Multiple implements Number {

    private final Number integerPart;
    private final Number fractionalPart;

    Multiple(Number integerPart, Number fractionalPart) {
        this.integerPart = integerPart;
        this.fractionalPart = fractionalPart;
    }

    protected abstract String getName();

    @Override
    public void describeTo(StringBuilder description) {
        final int length = description.length();

        integerPart.describeTo(description);

        if (length != description.length()) {
            description.append(" ")
                       .append(getName());
        }

        fractionalPart.describeTo(description);
    }
}
