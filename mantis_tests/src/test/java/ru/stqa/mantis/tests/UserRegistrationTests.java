package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;

public class UserRegistrationTests extends TestBase{

    @Test
    void canRegisterUser() {
        app.jamesApi().addUser(String.format("%s@localhost", CommonFunctions.randomString(8)), "password"); // создать адрес на почтовом сервере (James Helper)
        app.driver().get("http://localhost/mantisbt-2.26.0/login_page.php"); // Open Browser
        app.user().signUpANewAccount();
        // ждем почту (MailHelper)
        // извлекаем ссылку
        // проходим по ссылке и завершаем регистрацию (браузер)
        // проверяем что пользователь может залогиниться (HttpSessionHelper)

    }
}
