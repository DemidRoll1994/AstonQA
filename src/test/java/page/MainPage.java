package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainPage extends Page {
    private static final String ABOUT_EXPECTED_URI = "https://www.mts" +
            ".by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
    By ABOUT_TEXT = By.partialLinkText("Подробнее о сервисе");
    By VISA_LOGO = By.cssSelector("#pay-section .pay__partners > ul > li:nth-child(1) > img");
    By VERIFIED_BY_VISA_LOGO = By.cssSelector("#pay-section .pay__partners > ul > li:nth-child(2) > img");
    By MASTERCARD_LOGO = By.cssSelector("#pay-section .pay__partners > ul > li:nth-child(3) > img");
    By MS_SECURE_LOGO = By.cssSelector("#pay-section .pay__partners > ul > li:nth-child(4) > img");
    By BELKART_LOGO = By.cssSelector("#pay-section .pay__partners > ul > li:nth-child(5) > img");
    By PAYMENT_FRAME = By.className("bepaid-iframe");
    By PHONE = By.cssSelector("#connection-phone");
    By SUM = By.cssSelector("#connection-sum");
    By PAY_BUTTON = By.cssSelector("#pay-connection button");
    @FindBy(xpath = "//ul[@class = 'select__list']//li//p")
    private List<WebElement> dropDownList;
    @FindBy(xpath = "//*[@class = 'select__now']")
    private WebElement tab;
    @FindBy(xpath = "//form[@class = 'pay-form opened']//input")
    private List<WebElement> listPlaceholders;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getVisaPaymentSystemElement() {
        return awaitElement(VISA_LOGO);
    }

    public WebElement getVerifiedPaymentSystemElement() {
        return awaitElement(VERIFIED_BY_VISA_LOGO);
    }

    public WebElement getMastercardSystemElement() {
        return awaitElement(MASTERCARD_LOGO);
    }

    public WebElement getMSSecurePaymentSystemElement() {
        return awaitElement(MS_SECURE_LOGO);
    }

    public WebElement getBelkartPaymentSystemElement() {
        return awaitElement(BELKART_LOGO);
    }

    public WebElement getAboutButton() {
        return awaitElement(ABOUT_TEXT);
    }

    public WebElement getPaymentFrame() {
        return awaitElement(PAYMENT_FRAME);
    }

    public WebElement getPhone() {
        return awaitElement(PHONE);
    }

    public WebElement getPaymentSum() {
        return awaitElement(SUM);
    }

    public WebElement getPaymentButton() {
        return awaitElement(PAY_BUTTON);
    }


    public void testAction() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("pay-description__text")));
        String expectedTitle = "Оплата: Услуги связи Номер:375297777777";
        assertEquals(element.getText(), expectedTitle);
    }

    public void selectTab(String value) {
        tab.click();
        for (WebElement element : dropDownList) {
            if (element.getText().equals(value)) {
                element.click();
                break;
            }
        }
    }

    public void checkPlaceholdersForFields(String[] expectedPlaceholders) {
        for (int i = 0; i < listPlaceholders.size(); i++) {
            String actualPlaceholder = listPlaceholders.get(i).getAttribute("placeholder");
            System.out.println("actualPlaceholder = " + actualPlaceholder + ", expectedPlaceholders = " + expectedPlaceholders[i]);
            assertEquals(expectedPlaceholders[i], actualPlaceholder, "Placeholder для поля '" + expectedPlaceholders[i] + "' некорректен");
        }
    }

    public String[] getPlaceHoldersByClassnames(String[] className) {
        String[] actual = new String[className.length];
        for (int i = 0; i <className.length; i++) {
//            actual [i] = awaitElement(By.cssSelector("#" + className[i])).getAttribute("placeholder");
        actual [i] = driver.findElement(By.cssSelector("#" + className[i])).getAttribute(
                "placeholder");
    }
        return actual;
    }
}
