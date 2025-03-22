package ru.stqa.mantis.manager;

import org.openqa.selenium.By;
import ru.stqa.mantis.tests.TestBase;

import java.time.Duration;
import java.util.regex.Pattern;



public class UserHelper extends HelperBase {
    public UserHelper(ApplicationManager manager) {
        super(manager);
    }

    public void signUpANewAccount() {
        click(By.xpath(String.format("//*[@id=\"login-box\"]/div/div[2]/a")));
        type(By.name("username"), "user1");
        type(By.name("email"), "user1@localhost");
        click(By.xpath("//*[@id=\"signup-form\"]/fieldset/input[2]"));
    }

    public void approveRegistration() {
        type(By.name("realname"), "Kirill");
        type(By.name("password"), "test_password");
        type(By.name("password_confirm"), "test_password");
        click(By.xpath("//*[@id=\"account-update-form\"]/fieldset/span/button"));
    }

}
