package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;
import java.util.regex.Pattern;

public class UserRegistrationTests extends TestBase{

    @Test
     void canRegisterUser() {
        app.jamesCli().addUser("user1@localhost", "password"); // Create email
        app.mail().drain("user1@localhost", "password"); // Clean emailbox
        app.driver().get("http://localhost/mantisbt-2.26.4/login_page.php"); // Open browser
        app.user().signUpANewAccount(); // Start registration
        var message = app.mail().receive("user1@localhost", "password", Duration.ofSeconds(10)); // Wait for a mail
        var text = message.get(0).content();
        var pattern = Pattern.compile("http://\\S*"); // Get URL to continue
        var matcher = pattern.matcher(text);
        if (matcher.find()) {
            var url = text.substring(matcher.start(), matcher.end());
            System.out.println(url);
            app.driver().get(url); // Go to URL from
        }
        app.user().approveRegistration(); // Finish registration
        app.http().login("user1", "test_password"); // Try to log-in
        Assertions.assertTrue(app.http().isLoggedIn()); // Check if log-in is successful
    }
}
