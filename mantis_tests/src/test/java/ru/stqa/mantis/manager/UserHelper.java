package ru.stqa.mantis.manager;

import org.openqa.selenium.By;
import ru.stqa.mantis.tests.TestBase;

import java.time.Duration;
import java.util.regex.Pattern;



public class UserHelper extends HelperBase {
    public UserHelper(ApplicationManager manager) {
        super(manager);
    }

    public void signUpANewAccount(String username, String email) {
        manager.property("web.baseUrl");
        click(By.xpath(String.format("//*[@id=\"login-box\"]/div/div[2]/a")));
        type(By.name("username"), username);
        type(By.name("email"), email);
        click(By.xpath("//*[@id=\"signup-form\"]/fieldset/input[2]"));
    }

    public void approveRegistration(String realname, String password) {
        type(By.name("realname"), realname);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.xpath("//*[@id=\"account-update-form\"]/fieldset/span/button"));
    }


}
