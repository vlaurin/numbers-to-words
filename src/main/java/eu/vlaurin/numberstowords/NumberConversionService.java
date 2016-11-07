package eu.vlaurin.numberstowords;

import eu.vlaurin.numberstowords.number.NumberBuilder;

/**
 * @since 1.0
 */
public class NumberConversionService {
    /**
     * Converts a number to its equivalent in British English words.
     *
     * @param number
     *         the number to convert in the range 0 to 999,999,999 inclusive
     * @return the British English words representing the given number
     */
    public String convert(Integer number) {
        final StringBuilder description = new StringBuilder();
        NumberBuilder.parse(number)
                     .build()
                     .describeTo(description);
        return description.toString();
    }
}
