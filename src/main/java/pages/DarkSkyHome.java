package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class DarkSkyHome extends Base{

    By currentTempText = By.xpath("//span[@class='summary swap']");
    By timelineTempText = By.xpath("//span[@class='first']//span");
    By timeListRaw = By.xpath("//span[@class='hour']/span");

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
