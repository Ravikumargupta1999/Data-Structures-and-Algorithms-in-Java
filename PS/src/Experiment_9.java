import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Experiment_9 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.in/");
        List<WebElement> elements = driver.findElements(By.name("vehicle"));
        System.out.println("Number of elements:" +elements.size());
//        driver.quit();
    }
}
