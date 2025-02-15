package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {

    public ContactHelper (ApplicationManager manager) {
        super(manager);
    }

    public boolean isContactPresent() { // проверяем наличие контакта
        return manager.isElementPresent(By.name("selected[]"));

    }
    
    public void createContact(ContactData contacts) {
        initContactCreation();
        fillContactForm(contacts);
        submitContactCreation();
        returnToMainPage();
    }

    public void deleteContact() {
        selectContact();
        submitContactRemoval();
    }


    private void selectContact() {
        click(By.name("selected[]"));
    }

    private void submitContactRemoval() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        type(By.name("title"), contact.title());
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
        selectAllContacts();
        submitContactRemoval();

    }

    public int contactCount() { // подсчет количества контактов
        return manager.driver.findElements(By.name("selected[]")).size();
    }


}
