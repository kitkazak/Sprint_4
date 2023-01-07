import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Practicum {

    public static void main(String[] arguments) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.findElement(By.id("rcc-confirm-button")).click();
//        new WebDriverWait(driver, Duration.ofSeconds(5));
//
        driver.findElements(
                By.xpath(".//div[@class='accordion__item']")
        ).get(0).click();
    }
}
