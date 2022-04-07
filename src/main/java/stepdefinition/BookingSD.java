package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;

import org.junit.Assert;
import pages.Bookings.SearchResultPage;

import java.util.ArrayList;

public class BookingSD {

   SearchResultPage searchResultPage = new SearchResultPage();

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen() throws Throwable {

    }

    @When("^I select option for stars as (.+)$")
    public void i_select_option_for_stars_as(String stars) throws Throwable {
        // 5 stars

        searchResultPage.clickStarRating(stars.split(" ")[0].trim());
    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) throws Throwable {

     // 5 stars
      int expectedRating = Integer.parseInt(stars.split(" ")[0]);

      int actualStarRating = searchResultPage.getStarRating();

     System.out.println("Expected="+expectedRating);
     System.out.println("Actual="+actualStarRating);

     Assert.assertEquals("all ratings are not same or wrongs ratings",expectedRating,actualStarRating);
    }

    @Then("I verify {string} is within search result")
    public void iVerifyIsWithinSearchResult(String expectedHotelName) {

        ArrayList<String> hotelList = searchResultPage.getHotelsList();

        boolean result = false;

        for (int i=0;i<hotelList.size();i++)
        {
           System.out.println(hotelList.get(i));
           if(hotelList.get(i).contains(expectedHotelName));
                result = true;
        }

        Assert.assertTrue("the hotel is not in the list",result);

    }

    @Then("I verify system displays all hotels within {string} rs value")
    public void iVerifySystemDisplaysAllHotelsWithinRsValue(String expectedPriceRange) {

        ArrayList<Integer> priceList = searchResultPage.getPriceList();

        // [6999, 4549, 3299, 2474, 2550, 2833, 2266, 5919, 5309, 3982, 3800, 2280, 7124, 5201, 3167, 2970, 2822, 2000, 1500, 2500, 5072, 3754, 3600, 4000, 3212, 2377, 2918, 1459, 3600, 18400, 16170, 2736, 1779, 3600, 3784, 1892, 7485, 5464, 4786, 2824]

        int priceRangeExpected = Integer.parseInt(expectedPriceRange);

        boolean result = true;

        for(int i=0;i<priceList.size();i++)
        {
            if(priceList.get(i)>priceRangeExpected)
                result = false;
        }

        Assert.assertTrue("Some prices are out of given range", result);
    }
}
