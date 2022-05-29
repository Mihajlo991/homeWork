import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) {try {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tijana\\Desktop\\Kurs\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.kupujemprodajem.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"bodyTag\"]/div[9]/div/div[2]")).click();
        WebElement search = driver.findElement(By.id("searchKeywordsInput"));
        search.sendKeys("IPhone 13");
        search.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"cookieConsentHolder\"]/div/div/div[2]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"adListContainer\"]/div[contains(@id, 'adDescription')][1]/div/section[2]/div/div[1]/a")).click();
        Thread.sleep(3000);
        WebElement title = driver.findElement(By.className("oglas-title"));
        if (title.getText().equals("iPhone 13, iPhone 12, iPhone 11 - NOVO!")) {
            System.out.println("Result was the same");
        } else {
            System.out.println("Result was not the same");
        }
        driver.close();
    }catch (InterruptedException ex){ex.printStackTrace();}

    }


}
