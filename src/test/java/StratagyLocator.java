import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StratagyLocator {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void LSId() {
        driver.navigate().to("https://www.way2automation.com/way2auto_jquery/registration.php#load_box" );
        driver.findElement(By.id("register_form"));
        driver.findElement(By.cssSelector("#register_form"));
        driver.findElement(By.tagName("nav"));
        driver.findElement(By.cssSelector("nav"));
        driver.findElement(By.className("fieldset"));
        driver.findElement(By.cssSelector(".fieldset"));
        driver.findElement(By.linkText("trainer@way2automation.com"));
        driver.findElement(By.cssSelector("[alt]"));
        driver.findElement(By.cssSelector("[alt=Way2automation]"));
        driver.findElement(By.cssSelector("[alt*=Way2"));
        driver.findElement(By.cssSelector("[alt^=Way"));
        driver.findElement(By.cssSelector("[alt$=mation"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
