package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasePage {
    private By getFacility = By.id("facility");
    private By getApplyForHospitalReadmission = By.id("hospital_readmission");
    private By getHealthCareProgram = By.id("program");
    private By getVisitDate = By.id("visit_date");
    private By getComment = By.id("comment");

    public SummaryPage() {
    }

    public SummaryPage(WebDriver driver, WebDriverWait waiter) {
        super(driver, waiter);
    }

    public By getGetFacility() {
        return getFacility;
    }

    public By getGetApplyForHospitalReadmission() {
        return getApplyForHospitalReadmission;
    }

    public By getGetHealthCareProgram() {
        return getHealthCareProgram;
    }

    public By getGetVisitDate() {
        return getVisitDate;
    }

    public By getGetComment() {
        return getComment;
    }

    public void summary (){
        getDriver().findElement(this.getComment).getText();
        getDriver().findElement(this.getApplyForHospitalReadmission).getText();
        getDriver().findElement(this.getFacility).getText();
        getDriver().findElement(this.getHealthCareProgram).getText();
        getDriver().findElement(this.getVisitDate).getText();
    }
}
