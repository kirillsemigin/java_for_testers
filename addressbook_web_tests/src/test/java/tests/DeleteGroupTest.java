package tests;

import io.qameta.allure.Allure;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DeleteGroupTest extends TestBase { // тест на удаление группы


    @Test
    public void deleteGroupTest() { // тест на удаление группы
        Allure.step("Checking precondition", step -> {
            if (app.hbm().getGroupCount() == 0) { //создание группы в том случае если ни одной группы не найдено
                app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
            }
        });
        var oldGroups = app.hbm().getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        app.groups().removeGroup(oldGroups.get(index));
        var newGroups = app.hbm().getGroupList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        Allure.step("Validating results", s -> {
            Assertions.assertEquals(newGroups, expectedList);
        });


    }

    @Test
    void deleteAllGroupsAtOnce() {
        if (app.hbm().getGroupCount() == 0) { //создание группы в том случае если ни одной группы не найдено
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0, app.hbm().getGroupCount());

    }

}
