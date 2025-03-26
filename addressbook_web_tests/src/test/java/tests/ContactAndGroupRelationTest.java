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
        if (app.hbm().getGroupCount() == 0) { // Проверяем существует ли группа. Если группы нет - создаем ее.
            app.hbm().createGroup(new GroupData("", "New group", "New header", "New footer"));
        }

        var group = app.hbm().getGroupList().get(0); // Получаем первую группу
        if (app.hbm().getContactCount() == 0) { // Проверяем существует ли пользователь. Если нет - создаем его.
            var contact = new ContactData()
                    .withName(CommonFunctions.randomString(7))
                    .withLastName(CommonFunctions.randomString(7));
            app.contacts().createContactWithoutPhoto(contact);
        }

        var contact = app.hbm().getContactList().get(0); // Получаем первого пользователя
        var contactsInGroup = app.hbm().getContactsInGroup(group); // Получаем список пользователей в группе
        app.contacts().addContactToGroup(contact, group); // Добавляем пользователя в группу
        var result = app.hbm().getContactsInGroup(group); // Получаем список пользователей в группе после добавления
        Assertions.assertEquals(contactsInGroup.size() + 1, result.size());

    }

    @Test
    void DeleteContactFromGroup() {
        if (app.hbm().getGroupCount() == 0) { // Проверяем существует ли группа. Если группы нет - создаем ее.
            app.hbm().createGroup(new GroupData("", "New group", "New header", "New footer"));
        }
        var groups = app.hbm().getGroupList(); // Получаем список групп
        var rnd = new Random();
        var group = groups.get(rnd.nextInt(groups.size()));
        var contactsInGroup = app.hbm().getContactsInGroup(group); // Получаем список пользователей, которые есть в группе
        if (contactsInGroup.isEmpty()) { // Если в группе нет пользователей - создаем пользователя и добавляем в группу.
            var contact = new ContactData()
                    .withName(CommonFunctions.randomString(7))
                    .withLastName(CommonFunctions.randomString(7));
            app.contacts().addContactToGroup(contact, group);

        }
        var addedContactsInGroup = app.hbm().getContactsInGroup(group);

        var contactToDelete = addedContactsInGroup.get(0); // Выбираем пользователя первого пользователя
        app.contacts().deleteContactFromGroup(group,contactToDelete); // Удаляем пользователя из группы

        var result = app.hbm().getContactsInGroup(group); // Получаем результирующий список пользователей в группе
        Assertions.assertFalse(result.contains(contactToDelete));

    }



}
