package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {
    @Test
    void testPhones() {
        if (app.hbm().getContactCount() == 0) { // Проверка наличия контакта. Если контакта нет - создаем его.
            app.hbm().createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "", "", "adddress", "", "", "891523404784", "121233332", "", "", "", ""));
        }
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
            Stream.of(contact.home(), contact.mobile(), contact.work(), contact.secondary())
                    .filter(s -> s != null && !"".equals(s))
                    .collect(Collectors.joining("\n"))

        ));
        var phones = app.contacts().getPhones();
        Assertions.assertEquals(expected, phones);
    }

    @Test
    void testEmail() {
        if (app.hbm().getContactCount() == 0) { // Проверка наличия контакта. Если контакта нет - создаем его.
            app.hbm().createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "", "", "Test_adddress", "", "", "", "", "", "test@mail", "test2@mail", "test3"));
        }
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.email(), contact.email2(), contact.email3())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var emails = app.contacts().getEmail();
        Assertions.assertEquals(expected, emails);
    }

    @Test
    void testAddress() {
        if (app.hbm().getContactCount() == 0) { // Проверка наличия контакта. Если контакта нет - создаем его.
            app.hbm().createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "", "", "Test_adddress", "", "", "", "", "", "", "", ""));
        }
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.address())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var address = app.contacts().getAddress();
        Assertions.assertEquals(expected, address);
    }
}
