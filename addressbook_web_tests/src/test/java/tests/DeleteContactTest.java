
package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DeleteContactTest extends TestBase {

    @Test
    public void DeleteContactTest() {
        if (app.contacts().contactCount() == 0) { // проверка наличия контакта перед удалением. Если контакта нет - создаем его.
            app.contacts().createContact(new ContactData("", "firstname", "middlename", "lastname", "nickname", ""));
        }
        List<ContactData> oldContacts = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().deleteContact(oldContacts.get(index));
        List<ContactData> newContacts = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);

    }

    @Test
    void DeleteAllContactsAtOnceOneByOne() { // удаляем все контакты за раз
        if (app.contacts().contactCount() == 0) { // Проверка наличия контакта перед удалением. Если контакта нет - создаем его.
            app.contacts().createContact(new ContactData("", "firstname", "middlename", "lastname", "nickname", ""));
        }
        app.contacts().deleteAllContacts();
        Assertions.assertEquals(0, app.contacts().contactCount());

    }

    @Test
    void DeleteAllContactsAtOnceBySelectAllButton() { // удаляем все контакты за раз
        if (app.contacts().contactCount() == 0) { // Проверка наличия контакта перед удалением. Если контакта нет - создаем его.
            app.contacts().createContact(new ContactData("", "firstname", "middlename", "lastname", "nickname", ""));
        }
        app.contacts().deleteAllContactsAtOnce();
        Assertions.assertEquals(0, app.contacts().contactCount());

    }




}