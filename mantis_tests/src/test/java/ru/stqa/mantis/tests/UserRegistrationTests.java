package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;
import java.util.regex.Pattern;

public class UserRegistrationTests extends TestBase{

    @Test
     void canRegisterUser() {
        app.jamesCli().addUser("user2@localhost", "password"); // создать адрес на почтовом сервере (James Helper)
        app.driver().get("http://localhost/mantisbt-2.26.4/login_page.php"); // Open Browser
        app.user().signUpANewAccount();
        var message = app.mail().receive("user2@localhost", "password", Duration.ofSeconds(10)); // ждем почту (MailHelper)
        var text = message.get(0).content();
        var pattern = Pattern.compile("http://\\S*"); // извлекаем ссылку
        var matcher = pattern.matcher(text);
        if (matcher.find()) {
            var url = text.substring(matcher.start(), matcher.end());
            System.out.println(url);
        }
    }
}
