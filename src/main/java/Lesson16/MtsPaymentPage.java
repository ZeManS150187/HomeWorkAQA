package Lesson16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsPaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MtsPaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Локаторы
    private By blockTitleLocator = By.xpath("//*[@id='pay-section']//h2");
    private By serviceTypeLocator = By.xpath("//button[contains(., 'Услуги связи')]");
    private By dropdownLocator = By.xpath("//button[contains(., 'Услуги связи')]");
    private By phoneNumberLocator = By.xpath("//*[@id='connection-phone']");
    private By sumLocator = By.xpath("//*[@id='connection-sum']");
    private By emailLocator = By.xpath("//*[@id='connection-email']");
    private By continueButtonLocator = By.xpath("//form[@id='pay-connection']//button[text()='Продолжить']");
    private By confirmationMessageLocator = By.xpath("//span[contains(text(), 'Оплата: Услуги связи')]");

    // Методы взаимодействия
    public String getBlockTitle() {
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitleLocator));
        return blockTitle.getText();
    }

    public String getServiceTypePlaceholder() {
        WebElement serviceType = wait.until(ExpectedConditions.presenceOfElementLocated(serviceTypeLocator));
        return serviceType.getAttribute("placeholder");
    }

    public String getPhoneNumberPlaceholder() {
        WebElement phoneNumber = wait.until(ExpectedConditions.presenceOfElementLocated(phoneNumberLocator));
        return phoneNumber.getAttribute("placeholder");
    }

    public String getSumPlaceholder() {
        WebElement sum = wait.until(ExpectedConditions.presenceOfElementLocated(sumLocator));
        return sum.getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(emailLocator));
        return email.getAttribute("placeholder");
    }

    public void selectServiceType(String serviceType) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(serviceTypeLocator));
        dropdown.sendKeys(serviceType);
    }

    public void enterPhoneNumber(String phoneNumber) {
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(phoneNumberLocator));
        phoneInput.sendKeys(phoneNumber);
    }

    public void enterSum(String sum) {
        WebElement sumInput = wait.until(ExpectedConditions.elementToBeClickable(sumLocator));
        sumInput.sendKeys(sum);
    }

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(emailLocator));
        emailInput.sendKeys(email);
    }

    public void clickContinueButton() {
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
        continueButton.click();
    }

    public boolean isConfirmationDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessageLocator)).isDisplayed();
    }

    public String getConfirmationDetails() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessageLocator));
        return confirmationMessage.getText();
    }

    // Метод для выбора услуги
    public void selectServiceTypes(String serviceType) {
        // Нажимаем на кнопку, чтобы открыть выпадающий список
        WebElement serviceTypeButton = driver.findElement(serviceTypeLocator);
        serviceTypeButton.click();

        // Ждём, пока откроется выпадающий список и станет доступным нужный элемент
        By dropdownOptionLocator = By.xpath("//button[contains(.,  '" + serviceType + "')]");
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(dropdownOptionLocator));
        option.click();
    }
}