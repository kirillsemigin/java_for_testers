package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.nio.file.Paths;
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

    public static String randomString(int n) { // генерация случайных символов
        var rnd = new Random();
        var result = "";
        for (int i = 0; i < n; i ++) {
            result = result + (char)('a' + rnd.nextInt(26));

        }
        return result;
    }

    public static String randomFile(String dir) {
        var fileNames = new File(dir).list();
        var rnd = new Random();
        var index = rnd.nextInt(fileNames.length);
        return Paths.get(dir, fileNames[index]).toString();
    }
}
