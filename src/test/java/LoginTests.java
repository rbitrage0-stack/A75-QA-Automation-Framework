import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() throws InterruptedException{

        provideEmail("james.trefethen@testpro.io");
        providePassword("TCtN7Exm$GLfyv3");
        clickSubmitBtn();
        Thread.sleep(2000);


//      Added ChromeOptions argument below to fix websocket error


        // TODO (for students): Review the configuration as part of HW15


        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/#!/home");

    }

}
