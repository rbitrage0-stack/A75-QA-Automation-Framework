import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Homework17 extends BaseTest{
    public void addSongToPlaylist() throws InterruptedException {
        String ExpectedString = "Added 1 song into \"Test Pro PlayList.\"";
        //login below
        provideEmail("james.trefethen@testpro.io");
        providePassword("TCtN7Exm$GLfyv3");
        clickSubmitBtn();
        //pause below
        Thread.sleep(2000);
        //search for artist below
        searchSong("Milazzo");
        //click on View All button below
        clickViewAllBtn();
        //select the first choice from those listed and click on it
        selectFirstSong();
        clickAddToBtn();
        //choose which playlist to add the song to
        choosePlayList();
        //Feedback bubble should match the ExpectedString
        getAddToPlayListSuccessMsg();
        Assert.assertEquals(getAddToPlayListSuccessMsg(),ExpectedString);


    }

    public String getAddToPlayListSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    public void choosePlayList() {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'Test Pro Playlist')]"));
        playlist.click();
    }

    private void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.xpath("//button[@class='btn-add-to']"));
        addToBtn.click();
    }

    public void selectFirstSong() {
        WebElement searchBox = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        
    }

    public void clickViewAllBtn() {
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
    }

    public void searchSong(String song) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type= 'search"));
        searchField.clear();
        searchField.sendKeys(song);
    }
}
