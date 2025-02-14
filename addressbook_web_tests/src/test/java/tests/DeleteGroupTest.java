package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DeleteGroupTest extends TestBase { // тест на удаление группы


    @Test
    public void deleteGroupTest() { // тест на удаление группы
        if (app.groups().getCount() == 0) { //создание группы в том случае если ни одной группы не найдено
            app.groups().createGroup(new GroupData("group name", "group header", "group footer"));
        }
        int groupCount = app.groups().getCount(); // считаем количество групп до выполнения удаления
        app.groups().removeGroup();
        int newGroupCount = app.groups().getCount(); // считаем количество групп после выполнения удаления
        Assertions.assertEquals(groupCount - 1, newGroupCount);

    }

    @Test
    void deleteAllGroupsAtOnce() {
        if (app.groups().getCount() == 0) { //создание группы в том случае если ни одной группы не найдено
            app.groups().createGroup(new GroupData("group name", "group header", "group footer"));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0, app.groups().getCount());

    }

}
