
package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class DeleteContactTest extends TestBase {



    @Test
    public void DeleteContactTest() {
        if (app.contacts().contactCount() == 0) { // проверка наличия контакта перед удалением. Если контакта нет - создаем его.
<<<<<<< HEAD
            app.contacts().createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "title", "company",
                    "address", "home", "mobile", "work", "fax", "email", "email2", "email3", "homepage"));
=======
            app.contacts().createContact(new ContactData("firstname", "middlename", "lastname", "nickname"));
>>>>>>> parent of ab77348 (доработка кода)
        }
        int contactCount = app.contacts().contactCount();
        app.contacts().deleteContact();
        int newContactCount = app.contacts().contactCount();
        Assertions.assertEquals(contactCount - 1, newContactCount);

    }

    @Test
    void DeleteAllContactsAtOnce() { // удаляем все контакты за раз
        if (app.contacts().contactCount() == 0) { // проверка наличия контакта перед удалением. Если контакта нет - создаем его.
<<<<<<< HEAD
            app.contacts().createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "title", "company",
                    "address", "home", "mobile", "work", "fax", "email", "email2", "email3", "homepage"));
=======
            app.contacts().createContact(new ContactData("firstname", "middlename", "lastname", "nickname"));
>>>>>>> parent of ab77348 (доработка кода)
        }
        app.contacts().deleteAllContacts();
        Assertions.assertEquals(0, app.contacts().contactCount());

    }


}