
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Edge {
    private WebDriver driver;
    //private WebDriverWait wait;
    private String url1 = "https://www.github.com";
    private String url2 = "https://www.github.com/operasoftware/operachromiumdriver/releases";
    @Before
    public void setup() {
        driver = new EdgeDriver();
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void howToOpenBrowserPage() {
        driver.get(url1);
    }
    @Test
    public void howToNavigateToPage(){
        driver.navigate().to(url2);
    }
    @Test
    public void howToNavigateBackAndForward(){
        driver.navigate().to(url1);
        Assert.assertEquals(driver.getTitle(),"GitHub: Where the world builds software · GitHub");
        driver.navigate().to(url2);
        Assert.assertEquals(driver.getTitle(),"Releases · operasoftware/operachromiumdriver · GitHub");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
