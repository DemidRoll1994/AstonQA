package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends Page {
    private static final By ABOUT_TEXT = By.partialLinkText("Подробнее о " +
            "сервисе");
    private static final By VISA_LOGO = By.cssSelector("#pay-section .pay__partners" +
            " > ul > li:nth-child(1) > img");
    private static final By VERIFIED_BY_VISA_LOGO = By.cssSelector("#pay-section .pay__partners > ul > li:nth-child(2) > img");
    private static final By MASTERCARD_LOGO = By.cssSelector("#pay-section .pay__partners > ul > li:nth-child(3) > img");
    private static final By MS_SECURE_LOGO = By.cssSelector("#pay-section .pay__partners > ul > li:nth-child(4) > img");
    private static final By BELKART_LOGO = By.cssSelector("#pay-section .pay__partners > ul > li:nth-child(5) > img");
    private static final By PAYMENT_FRAME = By.className("bepaid-iframe");
    private static final By PHONE = By.cssSelector("#connection-phone");
    private static final By SUM = By.cssSelector("#connection-sum");
    private static final By PAY_BUTTON = By.cssSelector("#pay-connection button");

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


    public String[] getPlaceHoldersByClassnames(String[] className) {
        String[] actual = new String[className.length];
        for (int i = 0; i <className.length; i++) {
            actual [i] = driver.findElement(By.cssSelector(className[i])).getAttribute("placeholder");
    }
        return actual;
    }
}
