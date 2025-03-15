package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public boolean isContactPresent() { // проверяем наличие контакта
        return manager.isElementPresent(By.name("selected[]"));

    }

    public void openHomePage() {
        click(By.xpath("//*[@id=\"nav\"]/ul/li[1]/a"));
    }

    public void createContact(ContactData contacts) { // Create a user
        initContactCreation();
        fillContactForm(contacts);
        submitContactCreation();
        returnToMainPage();
    }

    public void createContactInGroup(ContactData contacts, GroupData group) { // Create a user
        initContactCreation();
        fillContactForm(contacts);
        selectGroup(group);
        submitContactCreation();
        returnToMainPage();
    }

    public void addContactToGroup(ContactData contacts, GroupData group) {
        openHomePage();
        selectContact(contacts);
        selectGroupToAdd(group);
        PushAddButton();
        openHomePage();
    }

    public void deleteContactFromGroup(ContactData contact, GroupData group) {
        openHomePage();
        selectGroupOnMainPage(group);
        selectContact(contact);
        pushRemoveButton();
        openHomePage();
    }

    private void pushRemoveButton() {
        click(By.name("remove"));
    }

    private void selectGroupToAdd(GroupData group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());

    }

    private void selectGroupOnMainPage(GroupData group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());

    }

    private void PushAddButton() {
        click(By.name("add"));
    }


    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());

    }

    public void createContactWithoutPhoto(ContactData contacts) { // Create user without photo
        initContactCreation();
        fillContactFormWithOutPhoto(contacts);
        submitContactCreation();
        returnToMainPage();
    }

    public void deleteContact(ContactData contact) {  // Delete user
        openHomePage();
        selectContact(contact);
        submitContactRemoval();
        openHomePage();
    }


    private void selectContact(ContactData contact) { 
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));

    }

    private void selectContactToModify(ContactData contact) {// Выбираем контакт для изменения. Кликаем по иконке "карандаш"
        click(By.xpath(String.format("//td[@class='center']/a[@href='edit.php?id=%s']", contact.id())));
    }

    private void submitContactRemoval() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        attach(By.name("photo"),contact.photo());

      /*  type(By.name("title"), contact.title());
        type(By.name("company"), contact.company());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.home());
        type(By.name("mobile"), contact.mobile());
        type(By.name("work"), contact.work());
        type(By.name("fax"), contact.fax());
        type(By.name("email"), contact.email());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email3());
        type(By.name("homepage"), contact.homepage());

       */

    }

    private void fillContactFormWithOutPhoto(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        type(By.name("company"), contact.company());
        type(By.name("address"), contact.address());
    }

    private void switchToAlert() {
        manager.driver.switchTo().alert().accept();
    }

    private void initContactCreation() {
        click(By.linkText("add new"));
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void returnToMainPage() {
        click(By.linkText("home page"));
    }

    private void selectAllContacts() { // метод выбора всех контактов
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }


    public void deleteAllContacts() {// метод удаления всех контактов
        openHomePage();
        selectAllContacts();
        submitContactRemoval();
    }

    public void deleteAllContactsAtOnce() {
        openHomePage();
        selectContactsBySelectAllButton();
        submitContactRemoval();
    }

    public void selectContactsBySelectAllButton() {
        manager.driver.findElement(By.id("MassCB")).click();
    }


    public int contactCount() { // подсчет количества контактов
        return manager.driver.findElements(By.name("selected[]")).size();
    }


    public List<ContactData> getList() {
        var contacts = new ArrayList<ContactData>();
        var tds = manager.driver.findElements(By.name("entry"));
        for (var td : tds) {
            var name = td.findElement(By.cssSelector("td:nth-child(3)")).getText();
            var lastname = td.findElement(By.cssSelector("td:nth-child(2)")).getText();
            var checkbox = td.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id).withName(name).withLastName(lastname));

        }
        return contacts;
    }

    public void pushUpdateButton() {
        click(By.name("update"));
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openHomePage();
        selectContactToModify(contact);
        fillContactFormWithOutPhoto(modifiedContact);
        pushUpdateButton();
        openHomePage();
    }

    public String getPhones(ContactData contact) {
       return manager.driver.findElement(By.xpath(String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText();
    }

    public Map<String, String> getPhones() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var phones = row.findElements(By.tagName("td")).get(5).getText();
            result.put(id, phones);
        }
        return result;
    }

    public Map<String, String> getEmail() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var email = row.findElements(By.tagName("td")).get(4).getText();
            result.put(id, email);
        }
        return result;
    }

    public Map<String, String> getAddress() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var address = row.findElements(By.tagName("td")).get(3).getText();
            result.put(id, address);
        }
        return result;
    }
}
