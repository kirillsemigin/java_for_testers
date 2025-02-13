
package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


public class DeleteContactTest extends TestBase {
    private WebDriver driver;


    @Test
    public void DeleteContactTest() {
        app.contacts().deleteContact();

    }
}
