package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class GroupCreationTests extends TestBase {


    public static List<GroupData> groupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData("group name'", "", "")));
        for (var name : List.of("", "group name")) {
            for (var header : List.of("", "group header")) {
                for (var footer : List.of("", "group footer")) {
                    result.add(new GroupData(name, header, footer));
                }
            }

        }
        for (int i = 0; i < 5; i ++) { // цикл, где i это счетчик, n заданное количество групп.
            result.add(new GroupData(randomString(i * 10), randomString(i * 10), randomString(i * 10)));
        }
        return result;
    }


    @ParameterizedTest
    @MethodSource("groupProvider")
    public void CanCreateMultipleGroups(GroupData group) {
        int groupCount = app.groups().getCount(); // подсчет количества групп до операции добавления
        app.groups().createGroup(group);
        int newGroupCount = app.groups().getCount(); // подсчет количества групп после операции добавления
        Assertions.assertEquals(groupCount + 1, newGroupCount);
    }
}
