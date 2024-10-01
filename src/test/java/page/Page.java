package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Page {
    WebDriver driver;
    WebDriverWait wait;
    public Page(WebDriver driver){
        this.driver=driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    protected WebElement awaitElement (By path){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(path));
    }
}
