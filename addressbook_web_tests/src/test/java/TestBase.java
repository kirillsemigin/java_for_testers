import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

public class TestBase {

    protected static ApplicationManager app; // ссылка на ApplicationManager

    protected void removeGroup() {
        ApplicationManager.driver.findElement(By.name("selected[]")).click();
        ApplicationManager.driver.findElement(By.name("delete")).click();
        ApplicationManager.driver.findElement(By.linkText("group page")).click();
    }

    @BeforeEach
    public void setUp() {
        if (app == null) { // инициализация переменной app
            app = new ApplicationManager();
        }
        app.init(); // метод инициализации (переход по адресу, ввод логина и пароля)
    }

    protected boolean isGroupPresent() {
        return app.isElementPresent(By.name("selected[]"));
    }
}
