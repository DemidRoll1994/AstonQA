package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PayPage extends Page{

    private static final By PAY_DESCRIPTION_TEXT= By.className("pay-description__text");
    private static final By SUM_TEXT = By.xpath("//div[@class='pay-description__cost']/span[1]");
    private static final By SUM_BUTTON = By.xpath("//button[@class='colored disabled']");

    public PayPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDescriptionText(){
        return awaitElement(PAY_DESCRIPTION_TEXT);
    }
    public WebElement getSumText(){
        return awaitElement(SUM_TEXT);
    }
    public WebElement getSumButton(){
        return awaitElement(SUM_BUTTON);
    }
    public String[] getPlaceHoldersByXPaths(String[] xPaths) {
        String[] actual = new String[xPaths.length];
        for (int i = 0; i <xPaths.length; i++) {
            actual [i] = awaitElement(By.xpath(xPaths[i])).getText();
        }
        return actual;
    }
}
