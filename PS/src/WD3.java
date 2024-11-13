import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class WD3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://omayo.blogspot.com/");
        List<WebElement> elements = driver.findElements(By.name("vehicle"));
        System.out.println("Number of elements:" +elements.size());
//        driver.quit();
    }
}

