package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void CanCreateGroup() {
        app.groups().openGroupsPage();
        app.groups().createGroup(new GroupData("group name", "group header", "group footer"));
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        app.groups().openGroupsPage();
        app.groups().createGroup(new GroupData());
    }

    @Test
    public void CanCreateGroupWithNameOnly() {
        app.groups().openGroupsPage();
        app.groups().createGroup(new GroupData().withName("some name"));
    }
}
