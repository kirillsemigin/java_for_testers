package ru.stqa.mantis.manager;

import org.openqa.selenium.By;
import ru.stqa.mantis.tests.TestBase;

public class UserHelper extends HelperBase {
    public UserHelper(ApplicationManager manager) {
        super(manager);
    }

    public void signUpANewAccount() {
        click(By.xpath(String.format("//*[@id=\"login-box\"]/div/div[2]/a")));
    }
}
