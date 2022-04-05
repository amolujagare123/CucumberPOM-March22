package pages.Bookings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import pages.Base;

import static stepdefinition.SharedSD.getDriver;

public class SearchResultPage extends Base {

    By ratings = By.xpath("//div[@data-testid='rating-stars']");
    By totalStarsOnPage = By.xpath("//div[@data-testid='rating-stars']/span");


    public int getStarRating()
    {
        getDriver().navigate().refresh();

        int totalRating = getDriver().findElements(ratings).size();

        System.out.println("Total ratings="+totalRating);
        int totalStars = getDriver().findElements(totalStarsOnPage).size();
        System.out.println("totalStars="+totalStars);

        return  (totalStars / totalRating );

    }

    public void  clickStarRating(String star) // 3,4,5
    {
        By rating  = By.xpath("//div[@data-filters-group='class']//input[@name='class="+star+"']");

       // clickOn(rating);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        js.executeScript("arguments[0].click()",webAction(rating));

    }
}
