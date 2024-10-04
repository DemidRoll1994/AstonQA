package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PayPage extends Page{

    By PAY_DESCRIPTION_TEXT= By.className("pay-description__text");

    public PayPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDescriptionText(){
        return awaitElement(PAY_DESCRIPTION_TEXT);
    }
}
