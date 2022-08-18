import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {
    private WebDriver driver;
    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void howToOpenBrowserPage() {
        //driver.get("https://www.google.com");
        driver.navigate().to("https://google.com");
        driver.findElement(By.cssSelector("[alt=Google]"));
    }
    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}