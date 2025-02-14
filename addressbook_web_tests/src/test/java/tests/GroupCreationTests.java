package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void CanCreateGroup() {
        int groupCount = app.groups().getCount(); // подсчет количества групп до операции добавления
        app.groups().createGroup(new GroupData("group name", "group header", "group footer"));
        int newGroupCount = app.groups().getCount(); // подсчет количества групп после операции добавления
        Assertions.assertEquals(groupCount + 1, newGroupCount);
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        app.groups().createGroup(new GroupData());
    }

    @Test
    public void CanCreateGroupWithNameOnly() {
        app.groups().createGroup(new GroupData().withName("some name"));
    }

    @Test
    public void CanCreateMultipleGroups() {
        int n = 5; // заданное количество групп
        int groupCount = app.groups().getCount(); // подсчет количества групп до операции добавления

        for (int i = 0; i < n; i ++) { // цикл, где i это счетчик, n заданное количество групп.
            app.groups().createGroup(new GroupData(randomString(i * 10), "group header", "group footer"));
        }

        int newGroupCount = app.groups().getCount(); // подсчет количества групп после операции добавления
        Assertions.assertEquals(groupCount + n, newGroupCount);
    }
}
