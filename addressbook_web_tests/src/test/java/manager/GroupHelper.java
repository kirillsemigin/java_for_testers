package manager;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper {

    private final ApplicationManager manager;

    public GroupHelper(ApplicationManager manager) {
        this.manager = manager;

    }

    public void openGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            manager.driver.findElement(By.linkText("groups")).click();
        }
    }

    public boolean isGroupPresent() {
        openGroupsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void createGroup(GroupData group) {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
    }

    public void removeGroup() {
        openGroupsPage();
        selectGroup();
        selectGroup();
        removeSelectedGroup();
        returnToGroupsPage();
    }

    public void modifyGroup(GroupData modifiedGroup) {
        openGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        returnToGroupsPage();
    }

    private void submitGroupCreation() {
        manager.driver.findElement(By.name("submit")).click();
    }

    private void initGroupCreation() {
        manager.driver.findElement(By.name("new")).click();
    }

    private void removeSelectedGroup() {
        manager.driver.findElement(By.name("delete")).click();
    }

    private void returnToGroupsPage() {
        manager.driver.findElement(By.linkText("group page")).click();
    }

    private void submitGroupModification() {
        manager.driver.findElement(By.name("update")).click();
    }

    private void fillGroupForm(GroupData group) {
        manager.driver.findElement(By.name("group_name")).click();
        manager.driver.findElement(By.name("group_name")).sendKeys(group.name());
        manager.driver.findElement(By.name("group_header")).click();
        manager.driver.findElement(By.name("group_header")).sendKeys(group.header());
        manager.driver.findElement(By.name("group_footer")).click();
        manager.driver.findElement(By.name("group_footer")).sendKeys(group.footer());

    }

    private void initGroupModification() {
        manager.driver.findElement(By.name("edit")).click();
    }

    private void selectGroup() {
        manager.driver.findElement(By.name("selected[]")).click();

    }
}
