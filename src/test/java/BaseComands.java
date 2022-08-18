import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BaseComands {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void BC() {
        //driver.get("https://www.google.com");
        //driver.get("https://www.telekom.com");
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
        assert driver.findElement(By.cssSelector("#register_form .fieldset p>label")).getText().equals("First Name:");
        String text = "some text for testing";
        String newText = " NEW TEXT";
        WebElement firstNameField = driver.findElement(By.cssSelector("#register_form input[name = name]"));
        firstNameField.sendKeys(text);
        firstNameField.sendKeys(newText);
        assert firstNameField.getAttribute("value").equals(text + newText);
        WebElement uploadFile = driver.findElement(By.cssSelector("[type = file]"));
        uploadFile.isDisplayed();
        uploadFile.sendKeys("/Users/A117091122/IdeaProjects/AutomationLearning/src/test/files/2.jpg");
        assert uploadFile.isDisplayed();
        //WebElement searchField = driver.findElement(By.cssSelector("input.gLFyf"));
        //searchField.sendKeys("test");
        //searchField.sendKeys(Keys.ENTER);
        //driver.findElement(By.cssSelector("input.gLFyf")).getAttribute("value");
        //driver.findElement(By.cssSelector("input.gLFuf")).getText();
        //String value = searchField.getAttribute("title");
        ///System.out.println(value);
        //WebElement getURL = driver.findElement(By.cssSelector("a.level-1.has-subnav.open"));
        //String value = getURL.getAttribute("href");
        //System.out.println(value);

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
