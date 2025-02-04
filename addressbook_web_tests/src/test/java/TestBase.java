import model.GroupData;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class TestBase {

    protected static ApplicationManager app; // ссылка на ApplicationManager

    protected void createGroup(GroupData group) {
        ApplicationManager.driver.findElement(By.name("new")).click();
        ApplicationManager.driver.findElement(By.name("group_name")).click();
        ApplicationManager.driver.findElement(By.name("group_name")).sendKeys(group.name());
        ApplicationManager.driver.findElement(By.name("group_header")).click();
        ApplicationManager.driver.findElement(By.name("group_header")).sendKeys(group.header());
        ApplicationManager.driver.findElement(By.name("group_footer")).click();
        ApplicationManager.driver.findElement(By.name("group_footer")).sendKeys(group.footer());
        ApplicationManager.driver.findElement(By.name("submit")).click();
        ApplicationManager.driver.findElement(By.linkText("group page")).click();
    }

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

    protected boolean isElementPresent(By locator) {
        try {
            ApplicationManager.driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    protected void openGroupsPage() {
        if (!isElementPresent(By.name("new"))) {
            ApplicationManager.driver.findElement(By.linkText("groups")).click();
        }
    }

    protected boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }
}
