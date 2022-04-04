package pages.Bookings;

import org.openqa.selenium.By;
import pages.Base;

public class SearchResultPage extends Base {

    public void  clickStarRating(String star) // 3,4,5
    {
        By rating  = By.xpath("//div[@data-filters-group='class']//input[@name='class="+star+"']");

        clickOn(rating);

    }
}
