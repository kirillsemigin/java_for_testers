package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class CreateContactTest extends TestBase {


    @Test
    public void createContact () {
        int ContactCount = app.contacts().contactCount();
        app.contacts().createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "title", "company",
                "address", "home", "mobile", "work", "fax", "email", "email2", "email3", "homepage"));
        int newContactCount = app.contacts().contactCount();
        Assertions.assertEquals(ContactCount + 1, newContactCount);
    }


    @Test
    public void createContactWithEmptyFields () {
        app.contacts().createContact(new ContactData());
    }

    @Test void createContactWithNicknameOnly () {
        app.contacts().createContact(new ContactData().withNickNameOnly("semigapower"));
    }

}
