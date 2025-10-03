import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePLayList() throws InterruptedException{
        String expectedPlayListDeleteMsg = "Deleted playlist \"Test Pro Playlist.\"";

        provideEmail("james.trefethen@testpro.io");
        providePassword("TCtN7Exm$GLfyv3");
        clickSubmitBtn();
        Thread.sleep(2000);
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertEquals(getDeletedPlaylistMsg(),expectedPlayListDeleteMsg);


    }

    public String getDeletedPlaylistMsg() {
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsg.getText();
    }

    public void clickDeletePlaylistBtn() throws InterruptedException {
        WebElement deletePlaylist = driver.findElement(By.cssSelector(".del.btn-delete-playlist"));
        deletePlaylist.click();
        Thread.sleep(2000);

    }

    public void openPlaylist() {
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();
    }


}
