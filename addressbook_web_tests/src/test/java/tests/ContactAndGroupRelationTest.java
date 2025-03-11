package tests;

import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class ContactAndGroupRelationTest extends TestBase {

    @Test
    void CreateContactInGroup() { // Создаем контакт и добавляем его в группу
        var contact = new ContactData()
                .withName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));
        if (app.hbm().getGroupCount() == 0) { // Проверяем существует ли группа. Если группы нет - создаем ее.
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var group = app.hbm().getGroupList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().createContactInGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
    }


    @Test
    void AddContactToGroup() {
        if (app.hbm().getContactCount() == 0) { // Проверяем есть ли контакт для добавления в группу. Если контакта нет - создаем его.
            app.hbm().createContact(new ContactData("", "New Name", "New Middlename", "New Lastname", "New Nickname","", "","New Address"));
        }
        if (app.hbm().getGroupCount() == 0) { // Проверяем существует ли группа. Если группы нет - создаем ее.
            app.hbm().createGroup(new GroupData("", "New group", "New header", "New footer"));
        }
        var group = app.hbm().getGroupList();
        var gr = new Random();
        var group_index = gr.nextInt(group.size());
        var contacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(contacts.size());
        app.contacts().addContactToGroup(contacts.get(index), group.get(group_index));
        Assertions.
    }

    @Test
    void DeleteContactFromGroup() {
        if (app.hbm().getContactCount() == 0) { // Проверяем есть ли контакт для добавления в группу. Если контакта нет - создаем его.
            app.hbm().createContact(new ContactData("", "New Name", "New Middlename", "New Lastname", "New Nickname","", "","New Address"));
        }
        if (app.hbm().getGroupCount() == 0) { // Проверяем существует ли группа. Если группы нет - создаем ее.
            app.hbm().createGroup(new GroupData("", "New group", "New header", "New footer"));
        }
        var group = app.hbm().getGroupList();
        var gr = new Random();
        var group_index = gr.nextInt(group.size());
        var contacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(contacts.size());
        app.contacts().deleteContactFromGroup(contacts.get(index), group.get(group_index));
    }



}
