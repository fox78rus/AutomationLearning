import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Helpers {
    static boolean isElementPresented(WebDriver driver, By locator){
        return driver.findElements(locator).size() > 0;
    }
    static boolean isElementNotPresent(WebDriver driver, By locator){
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            return driver.findElements(locator).size() == 0;
        }
        finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }
}
