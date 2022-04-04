package pages.Darksy;

import org.openqa.selenium.By;
import pages.Base;

import java.util.ArrayList;

public class DarkSkyHome extends Base {

    By currentTempText = By.xpath("//span[@class='summary swap']");
    By timelineTempText = By.xpath("//span[@class='first']//span");
    By timeListRaw = By.xpath("//span[@class='hour']/span");

    By lowestTempFront = By.xpath("//span[@class='low-temp-text']");
    By highestTempFront = By.xpath("//span[@class='high-temp-text']");

    By lowestTempToday = By.xpath("//a[@data-day='0']//span[@class='minTemp']");
    By highestTempToday = By.xpath("//a[@data-day='0']//span[@class='maxTemp']"); // 104˚

    By darkskyAPI = By.xpath("//a[normalize-space()='Dark Sky API']");

    public void clickDarkSkyAPI()
    {
        clickOn(darkskyAPI);
    }

    public ArrayList<String> getTodaysTemp()
    {
        String lowTemp = getTextFromElement(lowestTempToday).split("˚") [0];   // 69˚
        // ==> {"69"}
        String highTemp = getTextFromElement(highestTempToday).split("˚") [0];   // 104˚

        ArrayList<String> tempList = new ArrayList<>();
        tempList.add(lowTemp);
        tempList.add(highTemp);

        return tempList;
    }



    public ArrayList<String> getFrontTemp()
    {
        String lowTemp = getTextFromElement(lowestTempFront).split("˚") [0];   // 69˚
        // ==> {"69"}
        String highTemp = getTextFromElement(highestTempFront).split("˚") [0];   // 104˚

        ArrayList<String> tempList = new ArrayList<>();
        tempList.add(lowTemp);
        tempList.add(highTemp);

        return tempList;
    }


    public ArrayList<Integer> getTimelist()
    {
        ArrayList<String> timelistStr = getElementTextList(timeListRaw);
        // [9pm,11pm,3am,......]
        System.out.println(timelistStr);
        ArrayList<Integer> timeList = new ArrayList<>();

        for(int i=0;i<timelistStr.size();i++)
        {
            String temp = timelistStr.get(i); // 9pm / 11pm / 3am
            int l = temp.length();
            String timeStr = temp.substring(0, l - 2); // 9 / 11 / 3
            int time = Integer.parseInt(timeStr);
            timeList.add(time);
        }
        System.out.println(timeList);
        return timeList;
    }

    public int getTimelineTemp()
    {
        String tempText = getTextFromElement(timelineTempText);
        // 93°

        String[] textList = tempText.split("°");
        // {"93"}

        String tempStr = textList[0];

        return Integer.parseInt(tempStr);
    }

    public int getCurrentTemp()
    {
        String tempText = getTextFromElement(currentTempText);
        // 93˚ Clear.

        String[] textList = tempText.split("˚");
       // {"93"," Clear."}

        String tempStr = textList[0];

       return Integer.parseInt(tempStr);
    }
}
