import org.junit.jupiter.api.Test;


public class DeleteGroupTest extends TestBase { // тест на удаление группы


    @Test
    public void deleteGroupTest() { // тест на удаление группы
        openGroupsPage();
        if (!isGroupPresent()) { //создание группы в том случае если ни одной группы не найдено
            createGroup("group name", "group header", "group footer");

        }
        removeGroup();

    }

}
