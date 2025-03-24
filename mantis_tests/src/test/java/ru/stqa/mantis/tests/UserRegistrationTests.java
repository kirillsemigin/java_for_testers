package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.manager.MailHelper;
import ru.stqa.mantis.model.UserData;

import java.time.Duration;
import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class UserRegistrationTests extends TestBase{

    public static Stream<String> userProvider() {
        var a = 5;
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {return CommonFunctions.randomString(a);
            }
        };
        var count = 1;
        var stream = Stream.generate(supplier).limit(count);
        return stream;
    }

    @ParameterizedTest
    @MethodSource("userProvider")
     void canRegisterUser(String username) {
        var email = String.format("%s@localhost", username);
        var password = CommonFunctions.randomString(8);

        app.jamesCli().addUser(email, password); // Create email
        app.mail().drain(email, password); // Clean emailbox
        app.user().signUpANewAccount(username, email); // Open browser and start registration
        var message = app.mail().receive(email, password, Duration.ofSeconds(10)); // Wait for a mail
        var text = message.get(0).content();
        var pattern = Pattern.compile("http://\\S*"); // Get URL to continue
        var matcher = pattern.matcher(text);
        if (matcher.find()) {
            var url = text.substring(matcher.start(), matcher.end());
            System.out.println(url);
            app.driver().get(url); // Go to URL from
        }
        app.user().approveRegistration(username, password); // Finish registration
        app.http().login(username, password); // Try to log-in
        Assertions.assertTrue(app.http().isLoggedIn()); // Check if log-in is successful
    }

    @ParameterizedTest
    @MethodSource("userProvider")
    void canRegistrateUserWithRestApi(String username) {
        var email = String.format("%s@localhost", username);
        var password = CommonFunctions.randomString(8);
        app.jamesApi().addUser(email, password);
        app.user().signUpANewAccount(username, email);
        var messages = app.mail().receive(email, password, Duration.ofSeconds(10));
        var url = MailHelper.getLinkFromMail(messages.get(0).content());
        app.driver().get(url);
        app.user().approveRegistration(username, password);
        app.http().login(username, password);
        Assertions.assertTrue(app.http().isLoggedIn());
    }

}
