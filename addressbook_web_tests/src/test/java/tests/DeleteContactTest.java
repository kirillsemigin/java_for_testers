
package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;



public class DeleteContactTest extends TestBase {



    @Test
    public void DeleteContactTest() {
        if (!app.contacts().isContactPresent()) { // проверка наличия контакта перед удалением. Если контакта нет - создаем его.
            app.contacts().createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "title", "company",
                    "address", "home", "mobile", "work", "fax", "email", "email2", "email3", "homepage"));
        }
        app.contacts().deleteContact();

    }

    @Test
    void DeleteAllContactsAtOnce() { // удаляем все контакты за раз
        if (!app.contacts().isContactPresent()) { // проверка наличия контакта перед удалением. Если контакта нет - создаем его.
            app.contacts().createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "title", "company",
                    "address", "home", "mobile", "work", "fax", "email", "email2", "email3", "homepage"));
        }
        app.contacts().deleteAllContacts();

    }


}