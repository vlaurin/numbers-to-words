package eu.vlaurin.numberstowords.number;

/**
 * @since 1.0
 */
public interface Number {
    /**
     * Writes the number as words in the description provided.
     *
     * @param description
     *         the description where the number is written
     */
    void describeTo(StringBuilder description);
}
