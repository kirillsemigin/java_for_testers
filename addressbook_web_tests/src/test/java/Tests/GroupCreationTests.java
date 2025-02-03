package Tests;

import Manager.ApplicationManager;
import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupCreationTests extends TestBase {


    @Test
    public void CanCreateGroup() {
        app.openGroupsPage();
        app.createGroup(new GroupData("name", "header", "footer"));

    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        app.openGroupsPage();
        ApplicationManager.driver.findElement(By.linkText("groups")).click();
        app.createGroup(new GroupData());

    }

    @Test
    public void CanCreateGroupWithEmptyNameOnly() {
        app.openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        ApplicationManager.driver.findElement(By.linkText("groups")).click();
        app.createGroup(groupWithName);

    }
}
