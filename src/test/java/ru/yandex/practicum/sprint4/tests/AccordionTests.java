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

@RunWith(Parameterized.class)
public class AccordionTests {
    private final int accordionItemIndex;
    private final String accordionExpectedText;

    public AccordionTests(int accordionItemIndex, String accordionExpectedText) {
        this.accordionItemIndex = accordionItemIndex;
        this.accordionExpectedText = accordionExpectedText;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {
                    0,
                    "Сутки — 400 рублей. Оплата курьеру — наличными или картой."
                },
                {
                    1,
                    "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."
                },
                {
                    3,
                    "Только начиная с завтрашнего дня. Но скоро станем расторопнее."
                }
        };
    }

    private WebDriver driver;

    @Test
    public void checkAccordionItemOpensAndShowsExpectedText() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageObjectModel homePage = new HomePageObjectModel(driver);
        homePage.clickRccConfirmButton();
        homePage.checkAccordionItemOpensAndShowsExpectedText(accordionItemIndex, accordionExpectedText);
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
