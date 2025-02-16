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
                        for (var title : List.of("", "test title")) {
                            for (var company : List.of("", "test company")) {
                                for (var address : List.of("", "test address")) {
                                    for (var home : List.of("", "test home")) {
                                        for (var mobile : List.of("", "test mobile")) {
                                            for (var work : List.of("", "test work")) {
                                                for (var fax : List.of("", "test fax")) {
                                                    for (var email : List.of("", "test email")) {
                                                        for (var email2 : List.of("", "test email2")) {
                                                            for (var email3 : List.of("", "test email3")) {
                                                                for (var homepage : List.of("", "test homepage")) {
                                                                    result.add(new ContactData(
                                                                            firstname,
                                                                            middlename,
                                                                            lastname,
                                                                            nickname,
                                                                            title,
                                                                            company,
                                                                            address,
                                                                            home,
                                                                            mobile,
                                                                            work,
                                                                            fax,
                                                                            email,
                                                                            email2,
                                                                            email3,
                                                                            homepage
                                                                            ));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            result.add(new ContactData(
                    randomString(i * 2), randomString(i * 2), randomString(i * 2),
                    randomString(i * 2), randomString(i * 2), randomString(i * 2),
                    randomString(i * 2), randomString(i * 2), randomString(i * 2),
                    randomString(i * 2), randomString(i * 2), randomString(i * 2),
                    randomString(i * 2), randomString(i * 2), randomString(i * 2)));
        }
        return result;
    }
    @ParameterizedTest
    @MethodSource("contactProvider")
    public void createContact (ContactData contact){
        int ContactCount = app.contacts().contactCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().contactCount();
        Assertions.assertEquals(ContactCount + 1, newContactCount);
    }
}
