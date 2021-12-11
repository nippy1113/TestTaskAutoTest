package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'RegistrationForm_selectCustom')]")
    private WebElement choseStatusButton;

    @FindBy(xpath = "//ul[contains(@class, 'RegistrationForm')]/li/a")
    private List<WebElement> listRegisterTypes;

    @FindBy(xpath = "//input[@name = 'email']")
    private WebElement emailInput;


    /**
     * Функция заполнения поля email
     *
     * @param emailString - значение email
     *
     */
    @Step("Вводим значение '{emailString}' в поле email")
    public HomePage inputEmail(String emailString) {
        waitUtilElementToBeClickable(emailInput).click();
        emailInput.sendKeys(emailString);
        return this;
    }

    @Step("Кликнуть на тип регистрации '{registrationType}'")
    public RegistrationPage selectRegistrationType(String registrationType) {
        waitUtilElementToBeVisible(choseStatusButton).click();
        for (WebElement subMenuItem : listRegisterTypes) {
            if (subMenuItem.getText().trim().contains(registrationType)) {
                waitUtilElementToBeClickable(subMenuItem).click();
                return pageManager.getRegistrationPage().checkOpenPage();
            }
        }
        Assertions.fail("Тип регистрации '" + registrationType + "' не было найдено!");
        return pageManager.getRegistrationPage();
    }


}
