import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class DeleteGroupTest extends TestBase { // тест на удаление группы


    @Test
    public void deleteGroupTest() { // тест на удаление группы
        if (!isElementPresent(By.name("new"))) { // проверка наличия хотя бы одной группы для удаления
            driver.findElement(By.linkText("groups")).click();
        }
        if (!isElementPresent(By.name("selected[]"))) { //создание группы в том случае если ни одной группы не найдено
            createGroup("group name", "group header", "group footer");

        }
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.name("delete")).click();
        driver.findElement(By.linkText("group page")).click();

    }

}
