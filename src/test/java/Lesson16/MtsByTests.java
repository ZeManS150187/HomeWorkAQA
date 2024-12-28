package Lesson16;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class MtsByTests {

    private WebDriver driver;
    private MtsPaymentPage paymentPage;

    @BeforeEach
    public void setUp() {
        // Инициализация драйвера
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.mts.by");

        // Инициализация Page Object
        paymentPage = new MtsPaymentPage(driver);
    }

    @AfterEach
    public void tearDown() {
        // Закрываем браузер
        driver.quit();
    }

    @Test
    public void testBlockTitle() {
        // Проверяем название блока
        String blockTitle = paymentPage.getBlockTitle();
        assert blockTitle.contains("Онлайн пополнение") : "Название блока некорректно";
        assert blockTitle.contains("без комиссии") : "Подзаголовок блока некорректен";
    }

    @Test
    public void testFieldPlaceholders() {
        // Проверяем наличие подсказок в незаполненных полях
        assert paymentPage.getPhoneNumberPlaceholder().equals("Номер телефона") : "Подсказка в поле 'Номер телефона' некорректна";
        assert paymentPage.getSumPlaceholder().equals("Сумма") : "Подсказка в поле 'Сумма' некорректна";
        assert paymentPage.getEmailPlaceholder().equals("E-mail для отправки чека") : "Подсказка в поле 'E-mail' некорректна";
    }

    @Test
    public void testFormSubmission() {
        // Заполняем форму для услуги "Услуги связи" и проверяем результат
        paymentPage.selectServiceType("Услуги связи");
        paymentPage.enterPhoneNumber("297777777");
        paymentPage.enterSum("100");
        paymentPage.enterEmail("test@example.com");
        paymentPage.clickContinueButton();


    }


}
