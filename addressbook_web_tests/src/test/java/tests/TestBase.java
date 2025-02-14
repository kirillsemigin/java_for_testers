package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

public class TestBase {

    protected static ApplicationManager app; // ссылка на manager.ApplicationManager

    @BeforeEach
    public void setUp() {
        if (app == null) { // инициализация переменной app
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser", "Chrome")); // метод инициализации (переход по адресу, ввод логина и пароля)
    }

    public String randomString(int n) { // генерация случайных символов
        var rnd = new Random();
        var result = "";
        for (int i = 0; i < n; i ++) {
            result = result + (char)('a' + rnd.nextInt(26));

        }
        if (n < 20)
            result = result + '\'';
        return result;
    }
}
