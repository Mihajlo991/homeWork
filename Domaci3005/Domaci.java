import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Domaci {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tijana\\Desktop\\Kurs\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://www.strela.co.rs/");
        WebElement shop = driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]/a/span/strong"));
        shop.click();
        WebElement bows = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div/span[3]"));
        bows.click();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img")));
        WebElement samickSage = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img"));
        samickSage.click();
        WebElement title = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel\"]"));
        if (title.getText().contains("Samick")){
            System.out.println("This bow contains Samick in it's title in shop.");
        }
        driver.close();
    }
}

