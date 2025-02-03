import model.GroupData;
import org.junit.jupiter.api.Test;


public class DeleteGroupTest extends TestBase { // тест на удаление группы


    @Test
    public void deleteGroupTest() { // тест на удаление группы
        openGroupsPage();
        if (!isGroupPresent()) { //создание группы в том случае если ни одной группы не найдено
            createGroup(new GroupData("group_name", "group_header", "group_footer"));

        }
        removeGroup();

    }

}
