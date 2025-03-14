
package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;


public class DeleteContactTest extends TestBase {

    @Test
    public void DeleteContactTest() {

        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().deleteContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);

    }

    @Test
    void DeleteAllContactsAtOnceOneByOne() { // удаляем все контакты за раз
        if (app.hbm().getContactCount() == 0) { // Проверка наличия контакта перед удалением. Если контакта нет - создаем его.
            app.hbm().createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "", "", "address", "", "", "", "", ""));
        }
        app.contacts().deleteAllContacts();
        Assertions.assertEquals(0, app.hbm().getContactCount());

    }

    @Test
    void DeleteAllContactsAtOnceBySelectAllButton() { // удаляем все контакты за раз
        if (app.hbm().getContactCount() == 0) { // Проверка наличия контакта перед удалением. Если контакта нет - создаем его.
            app.hbm().createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "", "", "adddress", "", "", "", "", ""));
        }
        app.contacts().deleteAllContactsAtOnce();
        Assertions.assertEquals(0, app.hbm().getContactCount());

    }
}