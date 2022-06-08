package Test;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass {
    private WebDriver driver;
    private WebDriverWait waiter;
    private LogInPage logInPage;

    private AppointmentPage appointmentPage;

    private SummaryPage summaryPage;

    @BeforeClass

    public void BeforeClass (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tijana\\Desktop\\Kurs\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
        logInPage = new LogInPage(driver, waiter);
        appointmentPage = new AppointmentPage(driver, waiter);
        summaryPage = new SummaryPage(driver, waiter);


    }
    @Test(priority = 1)

    public void openPage (){
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]")).isDisplayed(), true);
    }

    @Test(priority = 2)

    public void logInTest (){
        logInPage.logIn("John Doe", "ThisIsNotAPassword");

    Assert.assertEquals(appointmentPage.isFormPresented(By.id("appointment")), 1);
    }


    @Test(priority = 3)

    public void appointmentSetTest (){

        appointmentPage.setAppointment("05/05/2005", "Random comment");
        Assert.assertEquals(appointmentPage.isFormPresented(By.id("summary")), 1);


    }

    @Test(priority = 4)
    public void summaryTest (){
        summaryPage.summary();
        Assert.assertEquals(driver.findElement(summaryPage.getGetComment()).getText(), "Random comment");
        Assert.assertEquals(driver.findElement(summaryPage.getGetVisitDate()).getText(), "05/05/2005");
        Assert.assertEquals(driver.findElement(summaryPage.getGetApplyForHospitalReadmission()).getText(), "Yes");

    }

}

