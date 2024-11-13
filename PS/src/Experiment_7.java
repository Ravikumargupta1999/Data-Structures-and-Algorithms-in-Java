import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Experiment_7 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://omayo.blogspot.com/");
        driver.findElement(By.id("ta1")).click();
        driver.findElement(By.id("ta1")).clear();
        driver.findElement(By.id("ta1")).sendKeys("hello");
        WebElement ele =  driver.findElement(By.id("ta1"));
        System.out.println("Found element:" +ele.getAttribute("id"));
//        driver.quit();
    }
}
