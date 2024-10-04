package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.MainPage;
import page.PayPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class PayPageTest {

    public static final String SUM_BUTTON_TEXT = "Оплатить 0.10 BYN";
    private MainPage mainPage;
    private PayPage payPage;
    private WebDriver driver;
    private static final String PAYMENT_EXPECTED_TITLE = "Оплата: Услуги связи Номер:375297777777";
    private static final String TEXT_SUM = "0.10 BYN";
    private static final String[] expected = {"Номер карты","Срок действия",
            "CVC","Имя держателя (как на карте)"};
    private static final String[] xPaths = {
            "//label[@class='ng-tns-c46-1 ng-star-inserted']",
            "//label[@class='ng-tns-c46-4 ng-star-inserted']",
            "//label[@class='ng-tns-c46-5 ng-star-inserted']",
            "//label[@class='ng-tns-c46-3 ng-star-inserted']"};

    @BeforeMethod
    public void beforeMethods() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.mts.by");
        mainPage = new MainPage(driver);
        try {
            driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]")).click();
        } catch (Exception e) {
            Reporter.log("cookie not found");
        }
        var phone = mainPage.getPhone();
        phone.click();
        phone.sendKeys("297777777");
        var sum = mainPage.getPaymentSum();
        sum.click();
        sum.sendKeys("0.1");
        mainPage.getPaymentButton().click();
        driver.switchTo().frame(mainPage.getPaymentFrame());
        payPage = new PayPage(driver);
    }
    @Test
    public void testPaymentInfo() {
        assertEquals(payPage.getDescriptionText().getText(), PAYMENT_EXPECTED_TITLE);
    }
    @Test
    public void testSum() {
        assertEquals(payPage.getSumText().getText(), TEXT_SUM);
        assertEquals(payPage.getSumButton().getText(), SUM_BUTTON_TEXT);
    }
    @Test
    public void testPlaceHolders() {
        String[] actual = payPage.getPlaceHoldersByXPaths(xPaths);
        assertEquals(actual, expected);
    }
    @AfterMethod
    public void finalizeTests() {
        driver.quit();
    }
}