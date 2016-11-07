package eu.vlaurin.numberstowords.number;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * @since 1.0
 */
public class NumberBuilderTest {

    public String describe(Number number) {
        final StringBuilder description = new StringBuilder();
        number.describeTo(description);
        return description.toString();
    }

    @Test
    public void buildNumber() {
        final Number number = new NumberBuilder().millions(123)
                                                 .thousands(456)
                                                 .hundreds(789)
                                                 .build();
        assertThat(number, is(notNullValue()));
        assertThat(describe(number), equalTo("one hundred and twenty three million four hundred and fifty six thousand seven hundred and eighty nine"));
    }

    @Test
    public void buildZero() {
        final Number number = new NumberBuilder().hundreds(0)
                                                 .build();
        assertThat(number, is(notNullValue()));
        assertThat(describe(number), equalTo("zero"));
    }

    @Test
    public void buildMillionsOnly() {
        final Number number = new NumberBuilder().millions(1)
                                                 .build();
        assertThat(number, is(notNullValue()));
        assertThat(describe(number), equalTo("one million"));
    }

    @Test
    public void buildThousandsOnly() {
        final Number number = new NumberBuilder().thousands(1)
                                                 .build();
        assertThat(number, is(notNullValue()));
        assertThat(describe(number), equalTo("one thousand"));
    }

    @Test
    public void testParse() {
        final NumberBuilder builder = NumberBuilder.parse(123456789);

        assertThat(builder, is(notNullValue()));

        final Number number = builder.build();
        assertThat(number, is(notNullValue()));
        assertThat(describe(number), equalTo("one hundred and twenty three million four hundred and fifty six thousand seven hundred and eighty nine"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void parsingNumberOutOfRangeShouldThrowAnException_oneBillion() {
        NumberBuilder.parse(1000000000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parsingNumberOutOfRangeShouldThrowAnException_minusOne() {
        NumberBuilder.parse(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parsingNullNumberShouldThrowAnException() {
        NumberBuilder.parse(null);
    }

}