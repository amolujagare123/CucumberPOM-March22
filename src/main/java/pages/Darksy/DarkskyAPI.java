package pages.Darksy;

import org.openqa.selenium.By;

public class DarkskyAPI extends DarkSkyHome{

    By loginLink = By.xpath("//a[@class='button']");

    public void clickLoginLink()
    {
        clickOn(loginLink);
    }
}
