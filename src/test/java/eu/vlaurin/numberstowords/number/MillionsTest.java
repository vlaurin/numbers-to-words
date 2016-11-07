package eu.vlaurin.numberstowords.number;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * @since 1.0
 */
public class MillionsTest {
    private Number millions;
    private Number thousands;

    @Before
    public void setUp() {
        millions = mock(Number.class);
        doAnswer(invocationOnMock -> {
            final StringBuilder description = (StringBuilder) invocationOnMock.getArguments()[0];
            description.append("xxx");
            return null;
        }).when(millions)
          .describeTo(any(StringBuilder.class));
        thousands = mock(Number.class);
        doAnswer(invocationOnMock -> {
            final StringBuilder description = (StringBuilder) invocationOnMock.getArguments()[0];
            description.append(" yyy");
            return null;
        }).when(thousands)
          .describeTo(any(StringBuilder.class));
    }

    public String describe(Number number) {
        final StringBuilder description = new StringBuilder();
        number.describeTo(description);
        return description.toString();
    }

    @Test
    public void testToWords() {
        final Number number = new Millions(millions, thousands);
        assertThat(describe(number), equalTo("xxx million yyy"));
        verify(millions).describeTo(any(StringBuilder.class));
        verify(thousands).describeTo(any(StringBuilder.class));
    }

    @Test
    public void emptyMillionsShouldBeSilent() {
        final Number number = new Millions(mock(Number.class), thousands);
        assertThat(describe(number), equalTo(" yyy"));
        verify(thousands).describeTo(any(StringBuilder.class));
    }

    @Test
    public void emptyThousandsShouldBeSilent() {
        final Number number = new Millions(millions, mock(Number.class));
        assertThat(describe(number), equalTo("xxx million"));
        verify(millions).describeTo(any(StringBuilder.class));
    }
}