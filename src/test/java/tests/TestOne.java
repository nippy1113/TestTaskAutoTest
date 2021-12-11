package tests;

import basetestclass.BaseTest;
import org.junit.jupiter.api.Test;

public class TestOne extends BaseTest {

    @Test
    public void registrationTest() throws InterruptedException {
        pageManager.getHomePage()
                .inputEmail("i.muzhev97@mail.ru")
                .selectRegistrationType("Студент медицинского ВУЗа")
                .inputName("Игорь")
                .inputFamilyName("Мужев")
                .inputMiddleName("Александрович")
                .fillField("university", "Шанхайский Университет Науки и Технологий")
                .fillField("finishDate", "2022")
                .clickRegistrationButton(); // Чтобы регистрация была успешной необходимо выполнить тест а это автоматизировать уже затруднительно
    }

}
