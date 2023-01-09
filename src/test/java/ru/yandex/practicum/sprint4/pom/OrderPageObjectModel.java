package ru.yandex.practicum.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class OrderPageObjectModel {
    WebDriver driver;

    public OrderPageObjectModel(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By orderContentContainer = By.xpath(".//div[contains(@class, 'Order_Content')]");
    By nameInput = By.xpath(".//input[@placeholder='* Имя']");
    By surnameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    By addressInput = By.xpath(".//input[contains(@placeholder, 'Адрес')]");
    By subwayStationInput = By.xpath(".//input[contains(@placeholder, 'Станция метро')]");
    By phoneInput = By.xpath(".//input[contains(@placeholder, 'Телефон')]");
    By dateInput = By.xpath(".//input[contains(@placeholder, 'Когда привезти')]");
    By daysOfRentInput = By.xpath(".//div[contains(text(), 'Срок аренды')]");
    By dropDownMenu = By.xpath(".//div[contains(@class, 'Dropdown-menu')]");
    By blackColorInput = By.id("black");
    By greyColorInput = By.id("grey");
    By commentInput = By.xpath(".//input[contains(@placeholder, 'Комментарий')]");
    By nextButton = By.xpath(".//div[contains(@class, 'Order_Content')]//button[text()='Далее']");
    By orderButton = By.xpath(".//div[contains(@class, 'Order_Content')]//button[text()='Заказать']");
    By confirmButton = By.xpath(".//div[contains(@class, 'Order_Content')]//button[text()='Да']");
    By checkStatusButton = By.xpath(".//div[contains(@class, 'Order_Content')]//button[text()='Посмотреть статус']");
    By orderModalContainer = By.xpath(".//div[contains(@class, 'Order_Modal')]");

    public void setNameInput(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setSurnameInput(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
    }

    public void setAddressInput(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void setSubwayStationInput(String subwayStation) {
        driver.findElement(subwayStationInput).sendKeys(subwayStation);
    }

    public void clickSubwayStationSelect(String subwayStation) {
        driver.findElement(
                By.xpath(".//div[contains(@class, 'Order_Content')]//div[contains(@class, 'Order_Text') and text()='" + subwayStation + "']")
        ).click();
    }

    public void setPhoneInput(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOf(driver.findElement(dateInput)));
        assertTrue(driver.findElement(dateInput).isDisplayed());
    }

    public void setDateInput(String date) {
        driver.findElement(dateInput).sendKeys(date);
    }

    public void clickDaysOfRentInput() {
        driver.findElement(daysOfRentInput).click();
    }

    public void clickDaysOfRentOption(String option) {
        driver.findElement(dropDownMenu).findElement(By.xpath(".//div[text()='" + option + "']")).click();
    }

    public void clickColor(String color) {
        if (color == "black") {
            driver.findElement(blackColorInput).click();
        } else {
            driver.findElement(greyColorInput).click();
        }
    }

    public void setCommentInput(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public void checkOrderModalDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderModalContainer)));
        assertTrue(driver.findElement(orderModalContainer).isDisplayed());
    }

    public void checkOrderContentContainerDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderContentContainer)));
        assertTrue(driver.findElement(orderContentContainer).isDisplayed());
    }

    public void checkCheckStatusButtonDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(checkStatusButton)));
        assertTrue(driver.findElement(checkStatusButton).isDisplayed());
    }

}
