package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup() {
        if (!app.groups().isGroupPresent()) { //создание группы в том случае если ни одной группы не найдено
            app.groups().createGroup(new GroupData("group name", "group header", "group footer"));

        }
        app.groups().modifyGroup(new GroupData().withName("modified name"));
    }
}
