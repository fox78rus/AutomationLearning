
import com.beust.ah.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class AllertTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test

    public void AT(){
        driver.get("http://omayo.blogspot.com/");
        WebElement alertButton = driver.findElement(By.cssSelector("#alert1"));
        alertButton.click();
        Alert alertWait = wait.until(ExpectedConditions.alertIsPresent());
        Alert alert =  driver.switchTo().alert();


        assert alertWait.getText().equals("Hello");

        alert.accept();
    }
    @Test

    public void GetPrompt(){
        driver.get("http://omayo.blogspot.com/");
        WebElement promptButton = driver.findElement(By.id("prompt"));
        promptButton.click();
        Alert alertWait = wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        assert alertWait.getText().equals("What is your name?");

        alert.dismiss();
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
