import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class DeleteGroupTest extends TestBase { // тест на удаление группы


    @Test
    public void deleteGroupTest() { // тест на удаление группы
        if (!isElementPresent(By.name("new"))) { // проверка наличия хотя бы одной группы для удаления
            driver.findElement(By.linkText("groups")).click();
        }
        if (!isElementPresent(By.name("selected[]"))) { //создание группы в том случае если ни одной группы не найдено
            driver.findElement(By.name("new")).click();
            driver.findElement(By.name("group_name")).click();
            driver.findElement(By.name("group_name")).sendKeys("group name");
            driver.findElement(By.name("group_header")).click();
            driver.findElement(By.name("group_header")).sendKeys("group header");
            driver.findElement(By.name("group_footer")).click();
            driver.findElement(By.name("group_footer")).sendKeys("group footer");
            driver.findElement(By.name("submit")).click();
            driver.findElement(By.linkText("group page")).click();

        }
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.name("delete")).click();
        driver.findElement(By.linkText("group page")).click();

    }

}
