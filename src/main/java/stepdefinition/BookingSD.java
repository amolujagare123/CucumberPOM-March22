package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Bookings.SearchResultPage;

public class BookingSD {

   SearchResultPage searchResultPage = new SearchResultPage();

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen() throws Throwable {

    }

    @When("^I select option for stars as (.+)$")
    public void i_select_option_for_stars_as(String stars) throws Throwable {
        // 5 stars

        searchResultPage.clickStarRating(stars.split(" ")[0]);
    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) throws Throwable {

    }
}
