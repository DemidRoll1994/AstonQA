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
import page.PayPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainPageTest {
    private MainPage mainPage;
    private PayPage payPage;
    private WebDriver driver;
    private static final String ABOUT_PAYMENT_EXPECTED_URI = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

    private static final String PAYMENT_EXPECTED_TITLE = "Оплата: Услуги связи Номер:375297777777";

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
    public Object[][] testPaymentSystems() {
        return new Object[][]{
                {mainPage.getVisaPaymentSystemElement()},
                {mainPage.getVerifiedPaymentSystemElement()},
                {mainPage.getMastercardSystemElement()},
                {mainPage.getMSSecurePaymentSystemElement()},
                {mainPage.getBelkartPaymentSystemElement()}
        };
    }

    @Test(dataProvider = "testPaymentSystems", testName = "Payment System displaying")
    public void testPaymentSystems(WebElement paymentSystem) {
        assertTrue(paymentSystem.isDisplayed());
    }

    @Test
    public void testAboutButton() {
        mainPage.getAboutButton().click();
        assertEquals(driver.getCurrentUrl(), ABOUT_PAYMENT_EXPECTED_URI);
    }

    @Test
    public void testPayment() {
        var phone = mainPage.getPhone();
        phone.click();
        phone.sendKeys("297777777");
        var sum = mainPage.getPaymentSum();
        sum.click();
        sum.sendKeys("0.1");
        mainPage.getPaymentButton().click();
        driver.switchTo().frame(mainPage.getPaymentFrame());
        payPage = new PayPage(driver);
        assertEquals(payPage.getDescriptionText(), PAYMENT_EXPECTED_TITLE);

//        driver.switchTo().frame(iframe);
//        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.className("pay-description__text")));
//        String expectedTitle = "Оплата: Услуги связи Номер:375297777777";
//        assertEquals(element.getText(), expectedTitle);

    }

    @DataProvider
    public Object[][] placeHolderProvider() {

        return new Object[][][]{
                {new String[]{"Номер телефона", "Сумма", "E-mail для отправки чека"},
                        new String[]{"connection-phone", "connection-sum", "connection-email"}},
                {new String[]{"Номер абонента", "Сумма", "E-mail для отправки чека"},
                        new String[]{"internet-phone", "internet-sum", "internet-email"}},
                {new String[]{"Номер счета на 44", "Сумма", "E-mail для отправки чека"},
                        new String[]{"score-instalment", "instalment-sum", "instalment-email"}},
                {new String[]{"Номер счета на 2073", "Сумма", "E-mail для отправки чека"},
                        new String[]{"score-arrears", "arrears-sum", "arrears-email"}}};
    }

    @Test(dataProvider = "placeHolderProvider")
    public void testPlaceHolders(String[] expected, String[] classNames) {
        String[] actual = mainPage.getPlaceHoldersByClassnames(classNames);
        assertEquals(actual, expected);
    }
/*
    @Test
    public void testPlaceholdersInPaymentFields() {
        mainPage.selectTab("Услуги связи");
        mainPage.checkPlaceholdersForFields(
                new String[]{"Номер телефона", "Сумма", "E-mail для отправки чека"}
        );
    }

    @Test
    public void testPlaceholdersInHomeInternetPaymentFields() {
        mainPage.selectTab("Домашний интернет");
        mainPage.checkPlaceholdersForFields(
                new String[]{"Номер абонента", "Сумма", "E-mail для отправки чека"}
        );
    }

    @Test
    public void testPlaceholdersInInstalmentPaymentFields() {
        mainPage.selectTab("Рассрочка");
        mainPage.checkPlaceholdersForFields(
                new String[]{"Номер счета на 44", "Сумма", "E-mail для отправки чека"}
        );
    }

    @Test
    public void testPlaceholdersInArrearsPaymentFields() {
        mainPage.selectTab("Задолженность");
        mainPage.checkPlaceholdersForFields(
                new String[]{"Номер счета на 2073", "Сумма", "E-mail для отправки чека"}
        );
    }
*/
    @AfterMethod
    public void finalizeTests() {
        driver.quit();
    }
}
