package Test;

import Test.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

/*·        Test.AppointmentPage
o   getter za facility select
o   getter za apply for hospital readmission
o   getter za radio dugme (trazeno po value atributu)
§ xpath-u - kao parametar se prima value za trazeno radio dugme
§ //*[@name='programs'][@value='"+ radioInputName +"']
o   getter za visit date input
o   getter za comment input
o   getter za book appointment button
o   metodu isFormPresented() koja vraca informaciju da li je ucitan element id="appointment",
 (iskoriste logiku preko liste, ako je lista prazna element nije na stanici)
Napomena: Datum se takodje postavlja preko metode sendKeys samo je potrebno datum uneti u formatu
 "dd/mm/yyyy" => npr: "21/09/2020"*/
public class AppointmentPage extends BasePage {
    private By facility = By.xpath("//*[@id=\"combo_facility\"]");
    private By applyForHospitalReadmission = By.xpath("//*[@id=\"chk_hospotal_readmission\"]");
    private By radioButton = By.xpath("//*[@id=\"appointment\"]/div/div/form/div[3]/div/label[2]");
    private By visitDate = By.xpath("//*[@id=\"txt_visit_date\"]"); /**date format dd/mm/yyyy like String object*/
    private By commentInput = By.xpath("//*[@id=\"txt_comment\"]");
    private By baButton = By.xpath("//*[@id=\"btn-book-appointment\"]");

    public AppointmentPage() {
        super();
    }

    public AppointmentPage(WebDriver driver, WebDriverWait waiter) {
        super(driver, waiter);
    }

    public By getFacility() {
        return facility;
    }

    public By getApplyForHospitalReadmission() {
        return applyForHospitalReadmission;
    }

    public By getRadioButton() {
        return radioButton;
    }

    public By getVisitDate() {
        return visitDate;
    }

    public By getCommentInput() {
        return commentInput;
    }

    public By getBaButton() {
        return baButton;
    }

    public int isFormPresented (By locator){
      return getDriver().findElements(locator).size();
   }

   public void setAppointment (String date, String comment){
       Random r = new Random();
       int randomInt = r.nextInt(2) + 1;
       Select facility = new Select(getDriver().findElement(By.xpath("//*[@id=\"combo_facility\"]")));
       facility.selectByIndex(randomInt);
       getDriver().findElement(this.applyForHospitalReadmission).click();
       getDriver().findElement(this.radioButton).click();
       getDriver().findElement(this.visitDate).sendKeys(date);
       getDriver().findElement(this.commentInput).sendKeys(comment);
       getDriver().findElement(this.baButton).click();
   }
}
