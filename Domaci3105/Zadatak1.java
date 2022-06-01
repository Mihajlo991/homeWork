import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Zadatak1 {
    /*Napisati dva smoke testa za https://www.telerik.com/support/demos:
Proveriti da klikom na Desktop odlazimo na tu sekciju
Proveriti da klikom na Mobile odlazimo na tu sekciju*/
    private WebDriver driver;

    @BeforeClass

    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tijana\\Desktop\\Kurs\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test

    public void testDesktop() throws InterruptedException {
        driver.navigate().to("https://www.telerik.com/support/demos");
        WebElement desktopButton = driver.findElement(By.cssSelector("a[href='#desktop']"));
        desktopButton.click();
        Thread.sleep(5000);

        boolean actualResult = desktopButton.getAttribute("class").contains("is-active");
        boolean expectedResult = true;
        Assert.assertEquals(actualResult, expectedResult);

    }


    @Test
    public void mobileTest() throws InterruptedException {
        driver.navigate().to("https://www.telerik.com/support/demos");
        WebElement mobileButton = driver.findElement(By.cssSelector("a[href='#mobile']"));
        mobileButton.click();
        Thread.sleep(5000);

        boolean actualResult = mobileButton.getAttribute("class").contains("is-active");
        boolean expectedResult = true;
        Assert.assertEquals(actualResult, expectedResult);

    }

    @AfterMethod
    public void close() {
        driver.close();
    }


}
