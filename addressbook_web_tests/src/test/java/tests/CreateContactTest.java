package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CreateContactTest extends TestBase {


    @Test
    public void createOneUser() {
        var user = new ContactData()
                .withName(randomString(10))
                .withLastName(randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));
        app.contacts().createContact(user);


    }

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "test name")) {
            for (var middlename : List.of("", "test middlename")) {
                for (var lastname : List.of("", "test last name")) {
                    for (var nickname : List.of("", "test nickname")) {
                        result.add(new ContactData().withName(firstname).withMiddleName(middlename).withLastName(lastname).withNickName(nickname));
                    }
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            result.add(new ContactData()
                    .withName(randomString(i * 2))
                    .withMiddleName(randomString(i * 2))
                    .withLastName(randomString(i * 2))
                    .withNickName(randomString(i * 2)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void createMultipleContacts(ContactData contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size() -1 ).id()).withMiddleName("").withNickName(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);

    }
}
