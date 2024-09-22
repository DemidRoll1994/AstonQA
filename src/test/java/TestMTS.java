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

public class TestMTS {
    private WebDriver driver;

    @BeforeSuite
    public void testInit() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethods() {
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
                driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        String expectedtitle = "Онлайн пополнение\nбез комиссии";
        assertEquals(blocktitle.getText(), expectedtitle);
    }

    @DataProvider
    public Object[][] testPaymentSystems() {
        return new Object[][]{
                {"//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]/img", "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg"},
                {"//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img", "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg"},
                {"//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img", "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg"},
                {"//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]/img", "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg"},
                {"//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]/img", "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg"}};
    }

    @Test(dataProvider = "testPaymentSystems", testName = "Payment System test")
    public void testPaymentSystems(String xpath, String pictureUrl) {
        WebElement blocktitle = driver.findElement(By.xpath(xpath));
        assertEquals(blocktitle.getAttribute("src"), pictureUrl);
    }

    @Test
    public void testAboutButton(){
        driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pay-description__text")));
        String expectedtitle = "Порядок оплаты и безопасность интернет платежей";
        assertEquals(element.getText(), expectedtitle);
    }

    @Test
    public void testAction()  {
        var phone = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[2]/form[1]/div[1]/input"));
        var sum = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[2]/form[1]/div[2]/input"));
        phone.click();
        phone.sendKeys("297777777");
        sum.click();
        sum.sendKeys("0.1");
        driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[2]/form[1]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pay-description__text")));
        String expectedTitle = "Оплата: Услуги связи Номер:375297777777";
        assertEquals(element.getText(), expectedTitle);
    }


    @AfterSuite
    public void finalizeTests() {
        driver.close();
    }
}
