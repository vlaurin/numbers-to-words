package eu.vlaurin.numberstowords.number;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @since 1.0
 */
public class DigitTest {

    public String describe(Number number) {
        final StringBuilder description = new StringBuilder();
        number.describeTo(description);
        return description.toString();
    }

    @Test(expected = IllegalArgumentException.class)
    public void digitCannotBeLessThan0() {
        new Digit(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void digitCannotBeGreatherThan9() {
        new Digit(10);
    }

    @Test
    public void zeroShouldBeSilent() {
        assertThat(describe(new Digit(0)), equalTo(""));
    }

    @Test
    public void testToWords_one() {
        assertThat(describe(new Digit(1)), equalTo(Digit.ONE));
    }

    @Test
    public void testToWords_two() {
        assertThat(describe(new Digit(2)), equalTo(Digit.TWO));
    }

    @Test
    public void testToWords_three() {
        assertThat(describe(new Digit(3)), equalTo(Digit.THREE));
    }

    @Test
    public void testToWords_four() {
        assertThat(describe(new Digit(4)), equalTo(Digit.FOUR));
    }

    @Test
    public void testToWords_five() {
        assertThat(describe(new Digit(5)), equalTo(Digit.FIVE));
    }

    @Test
    public void testToWords_six() {
        assertThat(describe(new Digit(6)), equalTo(Digit.SIX));
    }

    @Test
    public void testToWords_seven() {
        assertThat(describe(new Digit(7)), equalTo(Digit.SEVEN));
    }

    @Test
    public void testToWords_eight() {
        assertThat(describe(new Digit(8)), equalTo(Digit.EIGHT));
    }

    @Test
    public void testToWords_nine() {
        assertThat(describe(new Digit(9)), equalTo(Digit.NINE));
    }
}