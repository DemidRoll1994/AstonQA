package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.MainPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainPageTest {
    private MainPage mainPage;
    private WebDriver driver;
    private static final String ABOUT_PAYMENT_EXPECTED_URI = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

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
    public Object[][] testPaymentSystems(){
        return new Object[][]{
                {mainPage.getVisaPaymentSystemElement()},
                {mainPage.getVerifiedPaymentSystemElement()},
                {mainPage.getMastercardSystemElement()},
                {mainPage.getMSSecurePaymentSystemElement()},
                {mainPage.getBelkartPaymentSystemElement()}
        };
    }

    @Test
    public void testVisaPaymentSystemLogo() {
        assertTrue(mainPage.getVisaPaymentSystemElement().isDisplayed());
    }@Test
    public void testVerifiedPaymentSystemLogo() {
        assertTrue(mainPage.getVerifiedPaymentSystemElement().isDisplayed());
    }@Test
    public void testMastercardPaymentSystemLogo() {
        assertTrue(mainPage.getMastercardSystemElement().isDisplayed());
    }@Test
    public void testMSSecurePaymentSystemLogo() {
        assertTrue(mainPage.getMSSecurePaymentSystemElement().isDisplayed());
    }@Test
    public void testBelkartPaymentSystemLogo() {
        assertTrue(mainPage.getBelkartPaymentSystemElement().isDisplayed());
    }

    @Test
    public void testAboutButton() {
        mainPage.getAboutButton().click();
        assertEquals(driver.getCurrentUrl(), ABOUT_PAYMENT_EXPECTED_URI);
    }

    @DataProvider
    public Object[][] placeHolderProvider() {
        return new Object[][][]{
                {new String[]{"Номер телефона", "Сумма", "E-mail для отправки чека"},
                        new String[]{"#connection-phone", "#connection-sum",
                                "#connection-email"}},
                {new String[]{"Номер абонента", "Сумма", "E-mail для отправки чека"},
                        new String[]{"#internet-phone", "#internet-sum", "#internet-email"}},
                {new String[]{"Номер счета на 44", "Сумма", "E-mail для отправки чека"},
                        new String[]{"#score-instalment", "#instalment-sum", "#instalment-email"}},
                {new String[]{"Номер счета на 2073", "Сумма", "E-mail для отправки чека"},
                        new String[]{"#score-arrears", "#arrears-sum", "#arrears-email"}}};
    }

    @Test(dataProvider = "placeHolderProvider")
    public void testPlaceHolders(String[] expected, String[] classNames) {
        String[] actual = mainPage.getPlaceHoldersByClassnames(classNames);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void finalizeTests() {
        driver.quit();
    }
}