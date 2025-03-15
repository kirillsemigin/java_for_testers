package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTest extends TestBase{

    @Test
    void canModifyContact() {
        if (app.hbm().getContactCount() == 0) { // Проверка наличия контакта перед удалением. Если контакта нет - создаем его.
            app.hbm().createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "", "company", "address", "", "", "", "", "", "", "", ""));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withName("modified name").withCompany("modified company").withAddress("modified address");
        app.contacts().modifyContact(oldContacts.get(index), testData);
        var newContacts = app.hbm().getContactList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }
}
