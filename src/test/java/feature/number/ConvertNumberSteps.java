package feature.number;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import eu.vlaurin.numberstowords.NumberConversionService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @since 1.0
 */
public class ConvertNumberSteps {

    private NumberConversionService conversionService;
    private String result;

    @Given("^an instance of a number to word conversion service$")
    public void an_instance_of_a_number_to_word_conversion_service() {
        conversionService = new NumberConversionService();
    }

    @When("^I convert the number (\\d+)$")
    public void I_convert_the_number(Integer number) {
        result = conversionService.convert(number);
    }

    @Then("^I should get the words ([a-z ]+)$")
    public void I_should_get_the_words(String words) {
        assertThat(result, equalTo(words));
    }
}
