package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DarkSkyHome;

import java.util.ArrayList;
import java.util.Collections;

import static stepdefinition.SharedSD.getDriver;

public class DarksySD {

    DarkSkyHome darkSkyHome = new DarkSkyHome();

    @Given("I am on Darksky Home Page")
    public void iAmOnDarkskyHomePage() {

        // check this is the darksky home page or not

        Assert.assertEquals("this is not a darksky home page",
                "Dark Sky - Sansad Marg, New Delhi, Delhi",
                getDriver().getTitle());
    }

    @Then("I verify current temp is equal to Temperature from Daily Timeline")
    public void iVerifyCurrentTempIsEqualToTemperatureFromDailyTimeline() {

        int expected = darkSkyHome.getTimelineTemp();
        int actual = darkSkyHome.getCurrentTemp();

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals("temperatures are different",expected,actual);

    }

    @Then("I verify timeline is displayed with two hours incremented")
    public void iVerifyTimelineIsDisplayedWithTwoHoursIncremented() {

        ArrayList<Integer> timeList = darkSkyHome.getTimelist(); // 11-> last index - 10
        ArrayList<Integer> timeDiffList = new ArrayList<>(); // 10

        for(int i=0;i<timeList.size()-1;i++) // iterate 11 times (0-10)
        {
            int time1 = timeList.get(i); // 10
            int time2 = timeList.get(i+1); // 11
            int timeDiff = 0;

            if(time2>time1)
                timeDiff = time2 - time1;
            if(time2<time1)
                timeDiff = (time2+12) - time1;

            timeDiffList.add(timeDiff);
        }

        System.out.println(timeDiffList);
        int size = timeDiffList.size();
        int frequency = Collections.frequency(timeDiffList,2);

        boolean result = (size == frequency);

        Assert.assertTrue("all the differences are not 2",result);
    }


}
