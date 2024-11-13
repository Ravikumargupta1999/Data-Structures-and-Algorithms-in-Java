import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class psdemo {
    public static void main(String[] args) {
        System.out.println("Hi..");
        System.out.println("Selenium Demo");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://aakashrestaurant.000webhostapp.com/login.php");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("password")).submit();
    }
}