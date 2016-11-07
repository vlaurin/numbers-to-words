package eu.vlaurin.numberstowords.number;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * @since 1.0
 */
public class TensTest {

    private static final String ONES = "ones";
    private Digit ones;

    @Before
    public void setUp() {
        ones = mock(Digit.class);
        doAnswer(invocationOnMock -> {
            final StringBuilder description = (StringBuilder) invocationOnMock.getArguments()[0];
            description.append(" xxx");
            return null;
        }).when(ones)
          .describeTo(any(StringBuilder.class));
        when(ones.getDigit()).thenReturn(1);
    }

    public String describe(Number number) {
        final StringBuilder description = new StringBuilder();
        number.describeTo(description);
        return description.toString();
    }

    @Test
    public void testToWords_ten() {
        final Number ten = new Tens(1, new Digit(0));
        assertThat(describe(ten), equalTo(Tens.TEN));
    }

    @Test
    public void testToWords_eleven() {
        final Number eleven = new Tens(1, new Digit(1));
        assertThat(describe(eleven), equalTo(Tens.ELEVEN));
    }

    @Test
    public void testToWords_twelve() {
        final Number twelve = new Tens(1, new Digit(2));
        assertThat(describe(twelve), equalTo(Tens.TWELVE));
    }

    @Test
    public void testToWords_thirteen() {
        final Number thirteen = new Tens(1, new Digit(3));
        assertThat(describe(thirteen), equalTo(Tens.THIRTEEN));
    }

    @Test
    public void testToWords_fourteen() {
        final Number fourteen = new Tens(1, new Digit(4));
        assertThat(describe(fourteen), equalTo(Tens.FOURTEEN));
    }

    @Test
    public void testToWords_fifteen() {
        final Number fifteen = new Tens(1, new Digit(5));
        assertThat(describe(fifteen), equalTo(Tens.FIFTEEN));
    }

    @Test
    public void testToWords_sixteen() {
        final Number sixteen = new Tens(1, new Digit(6));
        assertThat(describe(sixteen), equalTo(Tens.SIXTEEN));
    }

    @Test
    public void testToWords_seventeen() {
        final Number seventeen = new Tens(1, new Digit(7));
        assertThat(describe(seventeen), equalTo(Tens.SEVENTEEN));
    }

    @Test
    public void testToWords_eighteen() {
        final Number eighteen = new Tens(1, new Digit(8));
        assertThat(describe(eighteen), equalTo(Tens.EIGHTEEN));
    }

    @Test
    public void testToWords_nineteen() {
        final Number nineteen = new Tens(1, new Digit(9));
        assertThat(describe(nineteen), equalTo(Tens.NINETEEN));
    }

    @Test
    public void testToWords_twenty() {
        final Number twenty = new Tens(2, ones);
        assertThat(describe(twenty), equalTo("twenty xxx"));
        verify(ones).describeTo(any(StringBuilder.class));
    }

    @Test
    public void testToWords_thirty() {
        final Number thirty = new Tens(3, ones);
        assertThat(describe(thirty), equalTo("thirty xxx"));
        verify(ones).describeTo(any(StringBuilder.class));
    }

    @Test
    public void testToWords_forty() {
        final Number forty = new Tens(4, ones);
        assertThat(describe(forty), equalTo("forty xxx"));
        verify(ones).describeTo(any(StringBuilder.class));
    }

    @Test
    public void testToWords_fifty() {
        final Number fifty = new Tens(5, ones);
        assertThat(describe(fifty), equalTo("fifty xxx"));
        verify(ones).describeTo(any(StringBuilder.class));
    }

    @Test
    public void testToWords_sixty() {
        final Number sixty = new Tens(6, ones);
        assertThat(describe(sixty), equalTo("sixty xxx"));
        verify(ones).describeTo(any(StringBuilder.class));
    }

    @Test
    public void testToWords_seventy() {
        final Number seventy = new Tens(7, ones);
        assertThat(describe(seventy), equalTo("seventy xxx"));
        verify(ones).describeTo(any(StringBuilder.class));
    }

    @Test
    public void testToWords_eighty() {
        final Number eighty = new Tens(8, ones);
        assertThat(describe(eighty), equalTo("eighty xxx"));
        verify(ones).describeTo(any(StringBuilder.class));
    }

    @Test
    public void testToWords_ninety() {
        final Number ninety = new Tens(9, ones);
        assertThat(describe(ninety), equalTo("ninety xxx"));
        verify(ones).describeTo(any(StringBuilder.class));
    }

    @Test
    public void trailingZeroShouldBeSilent() {
        final Number forty = new Tens(4, new Digit(0));
        assertThat(describe(forty), equalTo("forty"));
    }

    @Test
    public void doubleZeroShouldBeSilent() {
        final Number zeros = new Tens(0, new Digit(0));
        assertThat(describe(zeros), equalTo(""));
    }

    @Test
    public void leadingZeroShouldBeSilent() {
        final Number four = new Tens(0, new Digit(4));
        assertThat(describe(four), equalTo("four"));
    }

    @Test
    public void shouldPrependAndWhenPrecededByNumber() {
        final StringBuilder description = new StringBuilder("one hundred");
        final Number four = new Tens(0, new Digit(4));
        four.describeTo(description);
        assertThat(description.toString(), equalTo("one hundred and four"));
    }
}