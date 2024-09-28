import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestMTS {
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethods() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.mts.by");
        try {
            driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]")).click();
        } catch (Exception e) {
            Reporter.log("cookie not found");
        }
    }

    @Test
    public void testBlockTitle() {
        WebElement blocktitle =
                driver.findElement(By.cssSelector("#pay-section .pay h2"));
        String expectedtitle = "Онлайн пополнение\nбез комиссии";
        String actual = blocktitle.getText();
        assertEquals(actual, expectedtitle);
    }
    @DataProvider
    public Object[][] testPaymentSystems() {
        return new Object[][]{
                {"#pay-section .pay__partners > ul > li:nth-child(1) > img"},
                {"#pay-section .pay__partners > ul > li:nth-child(2) > img"},
                {"#pay-section .pay__partners > ul > li:nth-child(3) > img"},
                {"#pay-section .pay__partners > ul > li:nth-child(4) > img"},
                {"#pay-section .pay__partners > ul > li:nth-child(5) > img"}
        };
    }

    @Test(dataProvider = "testPaymentSystems", testName = "Payment System test")
    public void testPaymentSystems(String classname) {
        assertTrue(driver.findElement(By.cssSelector(classname)).isDisplayed());
    }

    @Test
    public void testAboutButton(){
        driver.findElement(By.partialLinkText("Подробнее о сервисе")).click();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @Test
    public void testAction()  {
        var phone = driver.findElement(By.cssSelector("#connection-phone"));
        var sum = driver.findElement(By.cssSelector("#connection-sum"));
        phone.click();
        phone.sendKeys("297777777");
        sum.click();
        sum.sendKeys("0.1");
        driver.findElement(By.cssSelector("#pay-connection button")).click();
        WebElement iframe = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-iframe")));
        driver.switchTo().frame(iframe);
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("pay-description__text")));
        String expectedTitle = "Оплата: Услуги связи Номер:375297777777";
        assertEquals(element.getText(), expectedTitle);
    }


    @AfterMethod
    public void finalizeTests() {
        driver.quit();
    }
}
