package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Random;

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

    public static String randomFile(String dir) {
        var fileNames = new File(dir).list(); // Создаем объект типа File и указываем в значении параметра путь к директории. Для получения списка файлов вызываем метод list
        var rnd = new Random(); // Для выбора случайного файла из списка.
        var index = rnd.nextInt(fileNames.length); // Получаем случайное число которое !> количества файлов
        return Paths.get(dir, fileNames[index]).toString();
        // Получаем путь к файлу (соединяем вместе путь к директории и имя файла) Берем путь до директории и путь к файлу с полученным индексом и превращаем в строку
    }

}
