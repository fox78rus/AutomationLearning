
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class GoogleTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test

    public void BC(){
        driver.get("https://google.com");

        WebElement searchField = driver.findElement(By.cssSelector("input.gLFyf"));
        searchField.sendKeys("test");
        searchField.sendKeys(Keys.ENTER);

        List<WebElement> itemsPage1 = driver.findElements(By.cssSelector(".g.tF2Cxc h3"));
        List<WebElement> pagination = driver.findElements(By.cssSelector(".AaVjTc td > a"));

        pagination.get(0).click();
        wait.until(ExpectedConditions.stalenessOf(itemsPage1.get(0)));

        List<WebElement> itemPage2 = driver.findElements(By.cssSelector(".g.tF2Cxc h3"));
        assert itemPage2.get(0).getText().equals("Test - Wir testen für Sie - SZ.de");
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;

    }
}
