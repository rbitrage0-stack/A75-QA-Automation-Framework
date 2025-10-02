import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException{
        provideEmail("james.trefethen@testpro.io");
        providePassword("TCtN7Exm$GLfyv3");
        clickSubmitBtn();
        Thread.sleep(2000);
        clickPlay();
        Assert.assertTrue(isSongPlaying());


    }

    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }

    public void clickPlay() {
        WebElement playNextBtn  = driver.findElement(By.xpath("//footer[@id = 'mainFooter']//i[@class = 'next fa fa-step-forward control']"));
        WebElement playBtn = driver.findElement(By.xpath("//span[@data-testid = 'play-btn']"));
        playNextBtn.click();
        playBtn.click();
    }

}
