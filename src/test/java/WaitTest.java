
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WaitTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url1 = "https://www.github.com";
    private String url2 = "https://www.github.com/operasoftware/operachromiumdriver/releases";
    @Before
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test

    public void BC(){
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
        WebElement uploadField = driver.findElement(By.cssSelector("[type = file]"));
        assert !Helpers.isElementPresented(driver, By.cssSelector("[type = file]"));
        wait.until(ExpectedConditions.stalenessOf(uploadField));

        assert uploadField.isDisplayed();
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
