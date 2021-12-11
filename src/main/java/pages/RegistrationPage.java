package pages;

import io.qameta.allure.Step;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//h1")
    private WebElement title;

    @FindBy(xpath = "//div[@class='box']//input[@name]")
    private List<WebElement> listInputFields;

    @FindBy(xpath = "//strong[text()='ЗАРЕГИСТРИРОВАТЬСЯ']")
    private WebElement registrationButton;

    @FindBy(xpath = "//input[@name = 'firstName']")
    private WebElement firstNameInputField;

    @FindBy(xpath = "//input[@name = 'lastName']")
    private WebElement lastNameInputField;

    @FindBy(xpath = "//input[@name = 'middleName']")
    private WebElement middleNameInputField;

    @Step("Проверяем открытие страницы с заголовком '{title.getText()}'")
    public RegistrationPage checkOpenPage() {
        Assertions.assertEquals("РЕГИСТРАЦИЯ НОВОГО ПОЛЬЗОВАТЕЛЯ", title.getText().trim(), "Заголовок отсутствует на странице!");
        return this;
    }

    @Step("Заполняем поле Имя значением '{value}' ")
    public RegistrationPage inputName(String value) {
        waitUtilElementToBeVisible(firstNameInputField).sendKeys(value);

        return this;
    }

    @Step("Заполняем поле Фамилия значением '{value}' ")
    public RegistrationPage inputFamilyName(String value) {
        waitUtilElementToBeVisible(lastNameInputField).sendKeys(value);

        return this;
    }

    @Step("Заполняем поле Отчество значением '{value}' ")
    public RegistrationPage inputMiddleName(String value) {
        waitUtilElementToBeVisible(middleNameInputField).sendKeys(value);

        return this;
    }

    /**
     * Функция заполнения полей страна, город, область, вуз и год выпуска
     * Реализована отдельно от заполнения ФИО из-за различных особенностей взаимодействия с этими веб элементами
     *
     *
     */
    @Step("Заполняем поле '{fieldName}' значением '{value}'")
    public RegistrationPage fillField(String fieldName, String value) {
        for (WebElement element : listInputFields) {
            if (element.getAttribute("name").equals(fieldName)) {
                WebElement input = element.findElement(By.xpath("./..//div[contains(@style, 'display')]/input"));
                waitUtilElementToBeVisible(input).sendKeys(value + "\n");
                return this;
            }
        }
        Assertions.fail("Поле '" + fieldName + "' не было найдено на странице!");
        return this;
    }

    @Step("Кликаем на кнопку Зарегистрироваться ")
    public RegistrationPage clickRegistrationButton() {
       waitUtilElementToBeClickable(registrationButton).click();
        return this;
    }

}
