package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;


public class DeleteGroupTest extends TestBase { // тест на удаление группы


    @Test
    public void deleteGroupTest() { // тест на удаление группы
        if (!app.groups().isGroupPresent()) { //создание группы в том случае если ни одной группы не найдено
            app.groups().createGroup(new GroupData("group name", "group header", "group footer"));

        }
        app.groups().removeGroup();

    }

}
