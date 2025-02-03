import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupCreationTests extends TestBase {


    @Test
    public void CanCreateGroup() {
        openGroupsPage();
        createGroup (new GroupData("name", "header", "footer"));

    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        openGroupsPage();
        driver.findElement(By.linkText("groups")).click();
        createGroup(new GroupData());

    }

    @Test
    public void CanCreateGroupWithEmptyNameOnly() {
        openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        driver.findElement(By.linkText("groups")).click();
        createGroup(groupWithName);

    }
}
