
package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class DeleteContactTest extends TestBase {

    @Test
    public void DeleteContactTest() {
        if (app.contacts().contactCount() == 0) { // проверка наличия контакта перед удалением. Если контакта нет - создаем его.
            app.contacts().createContact(new ContactData("firstname", "middlename", "lastname", "nickname"));
        }
        int contactCount = app.contacts().contactCount();
        app.contacts().deleteContact();
        int newContactCount = app.contacts().contactCount();
        Assertions.assertEquals(contactCount -1, newContactCount);

    }

    @Test
    void DeleteAllContactsAtOnceOneByOne() { // удаляем все контакты за раз
        if (app.contacts().contactCount() == 0) { // проверка наличия контакта перед удалением. Если контакта нет - создаем его.
            app.contacts().createContact(new ContactData("firstname", "middlename", "lastname", "nickname"));
        }
        app.contacts().deleteAllContacts();
        Assertions.assertEquals(0, app.contacts().contactCount());

    }

    @Test
    void DeleteAllContactsAtOnceBySelectAllButton() { // удаляем все контакты за раз
        if (app.contacts().contactCount() == 0) { // проверка наличия контакта перед удалением. Если контакта нет - создаем его.
            app.contacts().createContact(new ContactData("firstname", "middlename", "lastname", "nickname"));
        }
        app.contacts().deleteAllContactsAtOnce();
        Assertions.assertEquals(0, app.contacts().contactCount());

    }




}