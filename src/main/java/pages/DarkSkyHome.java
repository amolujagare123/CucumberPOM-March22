package pages;

import org.openqa.selenium.By;

public class DarkSkyHome extends Base{

    By currentTempText = By.xpath("//span[@class='summary swap']");
    By timelineTempText = By.xpath("//span[@class='first']//span");

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
