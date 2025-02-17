package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;

public class CreateContactTest extends TestBase {


    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "test name")) {
            for (var middlename : List.of("", "test middlename")) {
                for (var lastname : List.of("", "test last name")) {
                    for (var nickname : List.of("", "test nickname")) {
                        result.add(new ContactData(firstname, middlename, lastname, nickname));
                    }
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            result.add(new ContactData(randomString(i * 2), randomString(i * 2), randomString(i * 2), randomString(i * 2)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void createContact(ContactData contact) {
        int ContactCount = app.contacts().contactCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().contactCount();
        Assertions.assertEquals(ContactCount + 1, newContactCount);
    }
}
