import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tijana\\Desktop\\Kurs\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.stealmylogin.com/demo.html");
        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("vosa");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("vosa");
        password.sendKeys(Keys.ENTER);
        if (driver.getCurrentUrl().equals("https://example.com/")){
            System.out.println("Nice.");
        }else {
            System.out.println("Not nice.");
        }
        driver.close();
    }
}
