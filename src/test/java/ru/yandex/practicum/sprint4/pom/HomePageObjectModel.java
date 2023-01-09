package ru.yandex.practicum.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class HomePageObjectModel {
    WebDriver driver;

    public HomePageObjectModel(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By rccConfirmButton = By.id("rcc-confirm-button");
    By orderButtons = By.xpath(".//button[text()='Заказать']");
    By accordionItems = By.xpath(".//div[@class='accordion__item']");

    public void clickRccConfirmButton() {
        driver.findElement(rccConfirmButton).click();
    }

    public void clickOrderButton(int index) {
        driver.findElements(orderButtons).get(index).click();
    }

    public void clickAccordionItem(int index) {
        driver.findElements(accordionItems).get(index).click();
    }

    public void checkAccordionItemPanelDisplayed(int index) {
        WebElement accordionItemPanel = driver.findElements(accordionItems).get(index)
                .findElement(By.xpath(".//div[@class='accordion__panel']"));

        assertTrue(accordionItemPanel.isDisplayed());
    }

    public void checkAccordionItemTextMatchesExpectedText(int index, String expectedText) {
        String accordionItemText = driver.findElements(accordionItems).get(index)
                        .findElement(By.xpath(".//div[@class='accordion__panel']/p"))
                        .getText();

        assertTrue(accordionItemText.equals(expectedText));
    }

    // Step
    public void checkAccordionItemOpensAndShowsExpectedText(int index, String expectedText) {
        clickAccordionItem(index);
        checkAccordionItemPanelDisplayed(index);
        checkAccordionItemTextMatchesExpectedText(index, expectedText);
    }
}
