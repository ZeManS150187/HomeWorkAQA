package Lesson16;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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





    @Test
    public void testFormSubmissionCard() {
        String expectedSum = "100";
        String phoneNumber = "297777777";

        // Заполняем форму для услуги "Услуги связи" и проверяем результат
        paymentPage.selectServiceType("Услуги связи");
        paymentPage.enterPhoneNumber(phoneNumber);
        paymentPage.enterSum(expectedSum);
        paymentPage.enterEmail("test@example.com");
        paymentPage.clickContinueButton();


        assert paymentPage.getNumberCard().equals("Номер карты") : "Подсказка в поле 'Номер карты' некорректна";
        assert paymentPage.getValidity().equals("Срок действия") : "Подсказка в поле 'Срок действия' некорректна";
        assert paymentPage.getCVC().equals("CVC") : "Подсказка в поле 'CVC' некорректна";
        assert paymentPage.getName().equals("Имя держателя (как на карте)") : "Подсказка в поле 'Имя держателя (как на карте)' некорректна";

        assert paymentPage.isVisaIconPresent() : "Иконка Visa не отображается";
        assert paymentPage.isMasterCardIconPresent() : "Иконка MasterCard не отображается";
        assert paymentPage.isBelCardIconPresent() : "Иконка BelCard не отображается";
        assert paymentPage.isSecondIconAppearingAfterFirst() : "Ни одна из иконок не отображается";
        String displayedSum = paymentPage.getDisplayedSum();
        String expectedSumm = expectedSum + ".00 BYN";
        assert expectedSumm.equals(displayedSum) : "Сумма, отображенная на странице, не совпадает с введенной!";

        String displayedPhone =  paymentPage.getDisplayedPhone();
        String phone = "Оплата: Услуги связи Номер:375" + phoneNumber;
        assert phone.equals(displayedPhone) : "Номер, отображенный на странице, не совпадает с введенной!";

    }





    @Test
    public void testImageIsDisplayed() {
        // Локатор элемента Visa
        By visaImageLocator = By.xpath("//img[@alt='Visa']");
        // Поиск элемента
        WebElement visaImage = driver.findElement(visaImageLocator);
        // Проверка, что элемент отображается на странице
        Assert.assertTrue(visaImage.isDisplayed(), "Элемент Visa не отображается на странице!");


        // Локатор элемента Verified By Visa
        By verifiedByVisaImageLocator = By.xpath("//img[@alt='Verified By Visa']");
        // Поиск элемента
        WebElement verifiedByVisaImage = driver.findElement(verifiedByVisaImageLocator);
        // Проверка, что элемент отображается на странице
        Assert.assertTrue(verifiedByVisaImage.isDisplayed(), "Элемент Verified By Visa не отображается на странице!");

        // Локатор элемента  MasterCard
        By MasterCardImageLocator = By.xpath("//img[@alt='MasterCard']");
        // Поиск элемента
        WebElement MasterCardImage = driver.findElement(MasterCardImageLocator);
        // Проверка, что элемент отображается на странице
        Assert.assertTrue(MasterCardImage.isDisplayed(), "Элемент MasterCard Secure Code не отображается на странице!");

        // Локатор элемента  MasterCard Secure Code
        By masterCardSecureCodeLocator = By.xpath("//img[@alt='MasterCard Secure Code']");
        // Поиск элемента
        WebElement MasterCardSecureCodeImage = driver.findElement(masterCardSecureCodeLocator);
        // Проверка, что элемент отображается на странице
        Assert.assertTrue(MasterCardSecureCodeImage.isDisplayed(), "Элемент MasterCard Secure Code не отображается на странице!");

        // Локатор элемента  Белкарт
        By belCardLocator = By.xpath("//img[@alt='Белкарт']");
        // Поиск элемента
        WebElement belCardImage = driver.findElement(belCardLocator);
        // Проверка, что элемент отображается на странице
        Assert.assertTrue(belCardImage.isDisplayed(), "Элемент Белкарт не отображается на странице!");

    }

    @Test
    public void testDropdownSelectionAndPlaceholders() {
        // Локатор для <select> элемента
        By dropdownLocator = By.id("pay");

        // Инициализация объекта Select для работы с выпадающим списком
        WebElement dropdownElement = driver.findElement(dropdownLocator);
        Select dropdown = new Select(dropdownElement);

        // Перебираем и выбираем каждый элемент списка по очереди
        for (WebElement option : dropdown.getOptions()) {
            String optionText = option.getText(); // Получаем текст текущего элемента
            dropdown.selectByVisibleText(optionText); // Выбираем элемент по тексту

            // Если выбран "Услуги связи", выполняем проверку подсказок
            if (optionText.equals("Услуги связи")) {
                // Проверяем наличие подсказок в полях
                assert paymentPage.getPhoneNumberPlaceholder().equals("Номер телефона") : "Подсказка в поле 'Номер телефона' некорректна";
                assert paymentPage.getSumPlaceholder().equals("Сумма") : "Подсказка в поле 'Сумма' некорректна";
                assert paymentPage.getEmailPlaceholder().equals("E-mail для отправки чека") : "Подсказка в поле 'E-mail' некорректна";
            }
            if(optionText.equals("Домашний интернет")){
                // Проверяем наличие подсказок в полях
                assert paymentPage.getInternetPhonePlaceholder().equals("Номер абонента") : "Подсказка в поле 'Номер абонента' некорректна";
                assert paymentPage.getInternetSumPlaceholder().equals("Сумма") : "Подсказка в поле 'Сумма' некорректна";
                assert paymentPage.getInternetEmailPlaceholder().equals("E-mail для отправки чека") : "Подсказка в поле 'E-mail' некорректна";

            }
            if(optionText.equals("Рассрочка")){
                // Проверяем наличие подсказок в полях
                assert paymentPage.getInstalmentScorePlaceholder().equals("Номер счета на 44") : "Подсказка в поле 'Номер счета на 44' некорректна";
                assert paymentPage.getInstalmentSumPlaceholder().equals("Сумма") : "Подсказка в поле 'Сумма' некорректна";
                assert paymentPage.getInstalmentEmailPlaceholder().equals("E-mail для отправки чека") : "Подсказка в поле 'E-mail' некорректна";

            }
            if(optionText.equals("Задолженность")){
                // Проверяем наличие подсказок в полях
                assert paymentPage.getArrearsScorePlaceholder().equals("Номер счета на 2073") : "Подсказка в поле 'Номер счета на 2073' некорректна";
                assert paymentPage.getArrearsSumPlaceholder().equals("Сумма") : "Подсказка в поле 'Сумма' некорректна";
                assert paymentPage.getArrearsEmailPlaceholder().equals("E-mail для отправки чека") : "Подсказка в поле 'E-mail' некорректна";
            }
        }
    }



    }









