package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void CanCreateGroup() {
        app.groups().openGroupsPage();
        app.groups.createGroup(new GroupData("group name", "group header", "group footer"), app);
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        app.groups().openGroupsPage();
        app.groups.createGroup(new GroupData(), app);
    }

    @Test
    public void CanCreateGroupWithNameOnly() {
        app.groups().openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        app.groups.createGroup(groupWithName, app);
    }
}
