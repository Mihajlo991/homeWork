import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPageCustomer extends BasePage {

    private By logInButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");
    private By logInButton2 = By.xpath("/html/body/div/div/div[2]/div/form/button");

    public LogInPageCustomer(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickLogInCustomer() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")));
        getDriver().findElement(logInButton).click();
    }

    public void clickLogInCustomer2() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/form/button")));
        getDriver().findElement(logInButton2).click();
    }

    public void selectCustomer(String id) {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(By.id("userSelect")));
        Select customerSelect = new Select(getDriver().findElement(By.id("userSelect")));
        customerSelect.selectByValue(id);
    }

    public void customerDeposit(String money) {
        clickLogInCustomer();
        selectCustomer("1");
        clickLogInCustomer2();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")));
        getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")).click();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")));
        getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(money);
        getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(Keys.ENTER);
    }

    public void customerWithdrawal(String money) {
        clickLogInCustomer();
        selectCustomer("1");
        clickLogInCustomer2();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]")));
        getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]")).click();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")));
        getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(money);
        getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(Keys.ENTER);
    }

    public void customerLogOut() {
        clickLogInCustomer();
        selectCustomer("2");
        clickLogInCustomer2();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/button[2]")));
        getDriver().findElement(By.xpath("/html/body/div/div/div[1]/button[2]")).click();
    }
}
