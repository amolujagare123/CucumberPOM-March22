package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DarkSkyHome;

public class DarksySD {

    DarkSkyHome darkSkyHome = new DarkSkyHome();

    @Given("I am on Darksky Home Page")
    public void iAmOnDarkskyHomePage() {

        // check this is the darksky home page or not
    }

    @Then("I verify current temp is equal to Temperature from Daily Timeline")
    public void iVerifyCurrentTempIsEqualToTemperatureFromDailyTimeline() {

        int expected = darkSkyHome.getTimelineTemp();
        int actual = darkSkyHome.getCurrentTemp();

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals("temperatures are different",expected,actual);

    }
}
