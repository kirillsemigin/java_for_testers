import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupCreationTests extends TestBase {


    @Test
    public void CanCreateGroup() {
        openGroupsPage();
        createGroup("group name", "group header", "group footer");

    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        openGroupsPage();
        driver.findElement(By.linkText("groups")).click();
        createGroup("", "", "");

    }
}
