package ru.yandex.practicum.sprint4.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.practicum.sprint4.pom.HomePageObjectModel;
import ru.yandex.practicum.sprint4.pom.OrderPageObjectModel;

import java.time.Duration;

@RunWith(Parameterized.class)
public class OrderTests {

    private final int homePageOrderButtonIndex;
    private final String name;
    private final String surname;
    private final String address;
    private final String subwayStation;
    private final String phone;
    private final String date;
    private final String daysOfRentOption;
    private final String color;
    private final String comment;

    public OrderTests(int homePageOrderButtonIndex, String name, String surname, String address, String phone, String subwayStation, String date, String daysOfRentOption, String color, String comment) {
        this.homePageOrderButtonIndex = homePageOrderButtonIndex;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phone = phone;
        this.date = date;
        this.daysOfRentOption = daysOfRentOption;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {0, "Никита", "Казак", "г. Москва, ул. Собянина, д. 1", "88008008080", "Лубянка", "01.01.2024", "сутки", "black", "Привет!"},
                {1, "Вася", "Пупкин", "г. Москва, ул. Собянина, д. 2", "88008008081", "Сокольники", "02.01.2024", "трое суток", "grey", "Пока!"},
                {0, "Иван", "Иванов", "г. Москва, ул. Собчак, д. 3", "88008008082", "Красные Ворота", "02.01.2024", "трое суток", "black", "Хай!"}
        };
    }
    private WebDriver driver;

    @Test
    public void checkOrder() throws InterruptedException {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        (new HomePageObjectModel(driver)).clickRccConfirmButton();
        (new HomePageObjectModel(driver)).clickOrderButton(homePageOrderButtonIndex);

        OrderPageObjectModel orderPage = new OrderPageObjectModel(driver);
        orderPage.checkOrderContentContainerDisplayed();
        orderPage.setNameInput(name);
        orderPage.setSurnameInput(surname);
        orderPage.setAddressInput(address);
        orderPage.setSubwayStationInput(subwayStation);
        orderPage.clickSubwayStationSelect(subwayStation);
        orderPage.setPhoneInput(phone);
        orderPage.clickNextButton();
        orderPage.setDateInput(date);
        orderPage.clickColor(color);
        orderPage.clickDaysOfRentInput();
        orderPage.clickDaysOfRentOption(daysOfRentOption);
        orderPage.setCommentInput(comment);
        orderPage.clickOrderButton();
        orderPage.checkOrderModalDisplayed();
        orderPage.clickConfirmButton();
        orderPage.checkCheckStatusButtonDisplayed();
    }

    @BeforeClass
    public static void setupClass() {
        // WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        // driver = new FirefoxDriver();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
