import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

public class TestBase {

    protected static ApplicationManager app; // ссылка на ApplicationManager

    @BeforeEach
    public void setUp() {
        if (app == null) { // инициализация переменной app
            app = new ApplicationManager();
        }
        app.init(); // метод инициализации (переход по адресу, ввод логина и пароля)
    }

}
