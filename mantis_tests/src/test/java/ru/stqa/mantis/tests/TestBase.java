package ru.stqa.mantis.tests;

import org.junit.jupiter.api.BeforeEach;
import ru.stqa.mantis.manager.ApplicationManager;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    protected static ApplicationManager app; // ссылка на manager.ApplicationManager

    @BeforeEach
    public void setUp() throws IOException {
        if (app == null) { // инициализация переменной app
            var properties = new Properties();
            properties.load(new FileReader(System.getProperty("target", "local.properties")));
            app = new ApplicationManager();
            app.init(System.getProperty("browser", "Chrome"), properties); // метод инициализации (переход по адресу, ввод логина и пароля)
        }
    }
}
