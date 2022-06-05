import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LogInPageManager extends BasePage {

    private By managerLogInButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button");
    public int windowCount;

    public void setWindowCount(int windowCount) {
        this.windowCount = windowCount;
    }

    public LogInPageManager(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickLogInManager() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button")));
        getDriver().findElement(managerLogInButton).click();
    }

    public void createCustomer(String firstName, String lastName, String postalCode, int windowCount) {
        clickLogInManager();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")));
        getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")).click();
        windowCount = getDriver().getWindowHandles().size();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")));
        WebElement firstNameField = getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input"));
        firstNameField.sendKeys(firstName);
        firstNameField.sendKeys(Keys.ENTER);
        WebElement lastNameField = getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input"));
        lastNameField.sendKeys(lastName);
        lastNameField.sendKeys(Keys.ENTER);
        WebElement postalCodeField = getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input"));
        postalCodeField.sendKeys(postalCode);
        postalCodeField.sendKeys(Keys.ENTER);
    }

    public void createCustomersAccount(int windowCount) {
        clickLogInManager();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]")));
        getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]")).click();
        windowCount = getDriver().getWindowHandles().size();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"userSelect\"]")));
        Select userSelect = new Select(getDriver().findElement(By.xpath("//*[@id=\"userSelect\"]")));
        List<WebElement> users = getDriver().findElements(By.xpath("//*[@id=\"userSelect\"]/option"));
        int lcc = users.size() - 1;
        String lastCustomerCreated = String.valueOf(lcc);
        userSelect.selectByValue(lastCustomerCreated);
        Select currency = new Select(getDriver().findElement(By.xpath("//*[@id=\"currency\"]")));
        currency.selectByValue("1");
        getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();

    }

    public void logOutManager() {
        clickLogInManager();
        getDriver().findElement(By.xpath("/html/body/div/div/div[1]/button[2]")).click();
    }

}
