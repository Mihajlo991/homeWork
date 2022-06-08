package Test;

import Test.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage extends BasePage {

    private By userName = By.xpath("//*[@id=\"txt-username\"]");
    private By password = By.xpath("//*[@id=\"txt-password\"]");
    private By logInButton = By.xpath("//*[@id=\"btn-login\"]");

    public LogInPage(WebDriver driver, WebDriverWait waiter) {
        super(driver, waiter);
    }

    public void setUserName (String userName){
        getDriver().findElement(this.userName).sendKeys(userName);

    }
    public void setPassword (String password){
        getDriver().findElement(this.password).sendKeys(password);
    }
    public void logIn (String userName, String password){
        clearField(this.userName);
        setUserName(userName);
        clearField(this.password);
        setPassword(password);
        getDriver().findElement(this.logInButton).click();
    }
}
