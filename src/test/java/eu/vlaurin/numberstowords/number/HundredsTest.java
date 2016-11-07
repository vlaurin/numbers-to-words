package eu.vlaurin.numberstowords.number;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @since 1.0
 */
public class HundredsTest {

    private Digit hundreds;
    private Tens tens;

    @Before
    public void setUp() {
        hundreds = mock(Digit.class);
        doAnswer(invocationOnMock -> {
            final StringBuilder description = (StringBuilder) invocationOnMock.getArguments()[0];
            description.append("xxx");
            return null;
        }).when(hundreds)
          .describeTo(any(StringBuilder.class));
        when(hundreds.getDigit()).thenReturn(1);
        tens = mock(Tens.class);
        doAnswer(invocationOnMock -> {
            final StringBuilder description = (StringBuilder) invocationOnMock.getArguments()[0];
            description.append(" yyy");
            return null;
        }).when(tens)
          .describeTo(any(StringBuilder.class));
    }

    public String describe(Number number) {
        final StringBuilder description = new StringBuilder();
        number.describeTo(description);
        return description.toString();
    }

    @Test
    public void testToWords() {
        final Hundreds number = new Hundreds(hundreds, tens);
        assertThat(describe(number), equalTo("xxx hundred yyy"));
        verify(hundreds).describeTo(any(StringBuilder.class));
        verify(tens).describeTo(any(StringBuilder.class));
    }

    @Test
    public void trailingZerosShouldBeSilent() {
        final Hundreds hundreds = new Hundreds(new Digit(1), mock(Tens.class));
        assertThat(describe(hundreds), equalTo("one hundred"));
    }

    @Test
    public void leadingZeroShouldBeSilent() {
        final Hundreds hundreds = new Hundreds(new Digit(0), tens);
        assertThat(describe(hundreds), equalTo(" yyy"));
        verify(tens).describeTo(any(StringBuilder.class));
    }
}