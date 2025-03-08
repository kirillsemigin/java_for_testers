package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CreateContactTest extends TestBase {


    @Test
    void canCreateOneContact() {
        var contact = new ContactData()
                .withName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));
        app.contacts().createContact(contact);
    }


    public static List<ContactData> contactProvider() throws JsonProcessingException {
        var result = new ArrayList<ContactData>();
 //              for (var firstname : List.of("", "test name")) {
 //           for (var middlename : List.of("", "test middlename")) {
 //               for (var lastname : List.of("", "test last name")) {
 //                   for (var nickname : List.of("", "test nickname")) {
//                        result.add(new ContactData().withName(firstname).withMiddleName(middlename).withLastName(lastname).withNickName(nickname));
 //                   }
//                }
//            }
//       }
        var json = "";
        try (var reader = new FileReader("contacts.json");
             var breader = new BufferedReader(reader)
        ) {
            var line = breader.readLine();
            while (line != null) {
                json = json + line;
                line = breader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(json, new TypeReference<List<ContactData>>() {});
        result.addAll(value);
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void createContact(ContactData contact) {
        var oldContacts = app.hbm().getContactList();
        app.contacts().createContactWithoutPhoto(contact);
        var newContacts = app.hbm().getContactList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size() -1 ).id()));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);

    }
}
