package pages.Bookings;

import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import pages.Base;

import java.util.ArrayList;

import static stepdefinition.SharedSD.getDriver;

public class SearchResultPage extends Base {

    By ratings = By.xpath("//div[@data-testid='rating-stars']");
    By totalStarsOnPage = By.xpath("//div[@data-testid='rating-stars']/span");

    By hotelList = By.xpath("//div[@data-testid='title']");

    By priceList = By.xpath("//span[contains(text(),'₹')]");

    public ArrayList<Integer> getPriceList()
    {
        ArrayList<String> priceListRow = getElementTextList(priceList);
        System.out.println(priceListRow);
        ArrayList<Integer> priceListInt = new ArrayList<>();

        for (int i=0;i<priceListRow.size();i++)
        {
            //₹ 6,999
            String priceWithoutRS = priceListRow.get(i).split(" ")[1]; // 6,999
            System.out.println(priceWithoutRS);
            String priceWithoutComma ="";
            for(int j=0;j<priceWithoutRS.length();j++)
            {
                if(priceWithoutRS.charAt(j)!=',')
                    priceWithoutComma=priceWithoutComma+priceWithoutRS.charAt(j);

            }

            int price = Integer.parseInt(priceWithoutComma); // 6999

            priceListInt.add(price);
        }

        System.out.println(priceListInt);
        return priceListInt;
    }


    public ArrayList<String> getHotelsList()
    {
        return getElementTextList(hotelList);
    }



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
