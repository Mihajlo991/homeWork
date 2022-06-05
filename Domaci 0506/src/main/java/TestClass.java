import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private LogInPageCustomer logInPageCustomer;

    private LogInPageManager logInPageManager;


    @BeforeMethod
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tijana\\Desktop\\Kurs\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        logInPageCustomer = new LogInPageCustomer(this.driver, this.driverWait);
        logInPageManager = new LogInPageManager(this.driver, this.driverWait);
    }

    //znam da mogu direktno u assert ove boolean-e ali za sada mi je ovako bolje da vidim sta radim.
    @Test
    public void customerLogInPage() {
        logInPageCustomer.clickLogInCustomer();
        logInPageCustomer.selectCustomer("2");
        logInPageCustomer.clickLogInCustomer2();
        boolean expectedResult = true;
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[1]")));
        boolean actualResult = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[1]")).isDisplayed();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void ManagerLogInTest() {
        logInPageManager.clickLogInManager();
        boolean expectedResult = true;
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")));
        boolean actualResult = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")).isDisplayed();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void createCustomerTest() {

        logInPageManager.createCustomer("Mihajlo", "Varga", "21000", this.driver.getWindowHandles().size());
        Assert.assertEquals(logInPageManager.windowCount + 1, driver.getWindowHandles().size());
    }

    @Test
    public void createAccountTest() {
        logInPageManager.createCustomersAccount(this.driver.getWindowHandles().size());
        Assert.assertEquals(logInPageManager.windowCount + 1, driver.getWindowHandles().size());

    }

    @Test

    public void depositTest() {

        logInPageCustomer.customerDeposit("1000");
        boolean expectedResult = true;
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span")));
        boolean actualResult = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span")).isDisplayed();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void withdrawalTest() {
        logInPageCustomer.customerWithdrawal("1000");
        boolean expectedResult = true;
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span")));
        boolean actualResult = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span")).isDisplayed();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void logOutCustomerTest() {
        logInPageCustomer.customerLogOut();
        boolean expectedResult = true;
        boolean actualResult = driver.findElement(By.xpath("//*[@id=\"userSelect\"]")).isDisplayed();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void logOutManagerTest() {
        logInPageManager.logOutManager();//ne znam kako da napravim dugme klikabilnim a moram na spavanje
        // :D sutra cu uraditi za svoju dusu, i ove popape sa dva testa moram poskidati jer im ne radi aftermetoda...


    }


    @AfterMethod
    public void closeDriver() {

        driver.close();

    }
}
