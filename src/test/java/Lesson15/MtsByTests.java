package Lesson15;


import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsByTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testBlockTitle() {
        // Убедимся, что страница загрузилась, и элемент присутствует
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pay-section']")));

        // Проверяем заголовок блока
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='pay-section']//h2")));

        Assertions.assertNotNull(blockTitle, "Block title element is null");
        Assertions.assertTrue(blockTitle.getText().contains("Онлайн пополнение"), "Block title is incorrect");
        Assertions.assertTrue(blockTitle.getText().contains("без комиссии"), "Block subtitle is incorrect");
    }
    @Test
    public void testPaymentSystemLogos() {
        // Проверка наличия логотипов платежных систем
        WebElement visa = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img")
        ));
        Assertions.assertTrue(visa.isDisplayed(), "Payment logos block is not displayed");

        WebElement verifiedByVisa = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]/img")
        ));
        Assertions.assertTrue(verifiedByVisa.isDisplayed(), "Payment logos block is not displayed");

        WebElement masterCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img")
        ));
        Assertions.assertTrue(masterCard.isDisplayed(), "Payment logos block is not displayed");

        WebElement masterCardSecureCode = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]/img")
        ));
        Assertions.assertTrue(masterCardSecureCode.isDisplayed(), "Payment logos block is not displayed");

        WebElement belCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]/img")
        ));
        Assertions.assertTrue(belCard.isDisplayed(), "Payment logos block is not displayed");
    }

    @Test
    public void testLinkAboutService() {
        // Проверка работы ссылки "Подробнее о сервисе"
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Подробнее о сервисе')]")
        ));
        link.click();

        // Ожидаем, что откроется страница с ожидаемым URL
        wait.until(ExpectedConditions.urlContains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
                "URL does not contain expected value");
    }

    @Test
    public void testFormSubmission() {
        // Проверяем работу кнопки "Продолжить" (если есть форма для ввода)
        WebElement serviceType = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]")));
        serviceType.sendKeys("Услуги связи"); // Выбираем вариант "Услуги связи"

        WebElement phoneNumber = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phoneNumber.sendKeys("297777777"); // Вводим тестовый номер

        WebElement sum = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        phoneNumber.sendKeys("100"); //Вводим сумму

        WebElement email = driver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        phoneNumber.sendKeys("zemans@gmail.com"); //Вводим e-mail

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        submitButton.click();

        // Проверяем, что появляется подтверждение или переходим на новую страницу
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/app-root/div/div")
        ));
        Assertions.assertNotNull(confirmationMessage, "Confirmation message not found");

    }
}

