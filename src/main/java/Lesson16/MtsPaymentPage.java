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
    private By phoneNumberLocator = By.xpath("//*[@id='connection-phone']");
    private By sumLocator = By.xpath("//*[@id='connection-sum']");
    private By emailLocator = By.xpath("//*[@id='connection-email']");
    private By continueButtonLocator = By.xpath("//form[@id='pay-connection']//button[text()='Продолжить']");
    private By confirmationMessageLocator = By.xpath("//span[contains(text(), 'Оплата: Услуги связи')]");
    private By numberCardLocator = By.xpath("//label[contains(@class, 'ng-') and contains(text(), 'Номер карты')]");
    private By validityLocator = By.xpath("//label[normalize-space()='Срок действия']");
    private By cvcLocator = By.xpath("//label[text()='CVC']");
    private By nameLocator = By.xpath("//label[text()='Имя держателя (как на карте)']");
    private By popupLocator = By.xpath("//div[contains(@class, 'app-wrapper__content')]");


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


    public String getNumberCard() {
        // Переключение в iframe, если требуется
        WebElement iframe = driver.findElement(By.cssSelector(".bepaid-iframe"));
        driver.switchTo().frame(iframe);

        // Явное ожидание видимости элемента
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement numberCardLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Номер карты']")));

        // Получение текста и возврат
        String text = numberCardLabel.getText().trim();

        // Возврат в основной контекст
        driver.switchTo().defaultContent();
        return text;
    }

    public String getValidity() {
        // Переключение в iframe, если требуется
        WebElement iframe = driver.findElement(By.cssSelector(".bepaid-iframe"));
        driver.switchTo().frame(iframe);

        // Явное ожидание видимости элемента
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement validityLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Срок действия']")));

        String text = validityLabel.getText().trim();


        driver.switchTo().defaultContent();
        return text;
    }

    public String getCVC() {
        WebElement iframe = driver.findElement(By.cssSelector(".bepaid-iframe"));
        driver.switchTo().frame(iframe);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cvcLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='CVC']")));

        String text = cvcLabel.getText().trim();

        driver.switchTo().defaultContent();
        return text;
    }

    public String getName() {
        WebElement iframe = driver.findElement(By.cssSelector(".bepaid-iframe"));
        driver.switchTo().frame(iframe);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nameLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Имя держателя (как на карте)']")));

        String text = nameLabel.getText().trim();

        driver.switchTo().defaultContent();
        return text;
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
        // Нажимаем кнопку "Продолжить"
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(), 'Продолжить')]")));
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