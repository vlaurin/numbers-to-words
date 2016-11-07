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
public class ThousandsTest {

    private Number thousands;
    private Number hundreds;

    @Before
    public void setUp() {
        thousands = mock(Number.class);
        doAnswer(invocationOnMock -> {
            final StringBuilder description = (StringBuilder) invocationOnMock.getArguments()[0];
            description.append("xxx");
            return null;
        }).when(thousands)
          .describeTo(any(StringBuilder.class));
        hundreds = mock(Number.class);
        doAnswer(invocationOnMock -> {
            final StringBuilder description = (StringBuilder) invocationOnMock.getArguments()[0];
            description.append(" yyy");
            return null;
        }).when(hundreds)
          .describeTo(any(StringBuilder.class));
    }

    public String describe(Number number) {
        final StringBuilder description = new StringBuilder();
        number.describeTo(description);
        return description.toString();
    }

    @Test
    public void testToWords() {
        final Number number = new Thousands(thousands, hundreds);
        assertThat(describe(number), equalTo("xxx thousand yyy"));
        verify(thousands).describeTo(any(StringBuilder.class));
        verify(hundreds).describeTo(any(StringBuilder.class));
    }

    @Test
    public void emptyThousandsShouldBeSilent() {
        final Number number = new Thousands(mock(Number.class), hundreds);
        assertThat(describe(number), equalTo(" yyy"));
        verify(hundreds).describeTo(any(StringBuilder.class));
    }

    @Test
    public void emptyHundredsShouldBeSilent() {
        final Number number = new Thousands(thousands, mock(Number.class));
        assertThat(describe(number), equalTo("xxx thousand"));
        verify(thousands).describeTo(any(StringBuilder.class));
    }
}