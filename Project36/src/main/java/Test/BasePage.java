package Test;/*Napisati program koji testira funkcionalnost zakazivanja na
 satju https://katalon-demo-cura.herokuapp.com/. Od klasa je potrebno:

·        LoginPage – dodati neophodne metode
·        Test.AppointmentPage
o   getter za facility select
o   getter za apply for hospital readmission
o   getter za radio dugme (trazeno po value atributu)
§ xpath-u - kao parametar se prima value za trazeno radio dugme
§ //*[@name='programs'][@value='"+ radioInputName +"']
o   getter za visit date input
o   getter za comment input
o   getter za book appointment button
o   metodu isFormPresented() koja vraca informaciju da li je ucitan element id="appointment", (iskoriste logiku preko liste, ako je lista prazna element nije na stanici)
Napomena: Datum se takodje postavlja preko metode sendKeys samo je potrebno datum uneti u formatu
 "dd/mm/yyyy" => npr: "21/09/2020"

·        SummaryPage
o   ima gettere za sve elemenete sa summary stranice koji nose informacije appointment-a
·        AppointmentTest
o   Ucitajte stranicu https://katalon-demo-cura.herokuapp.com/
o   Ulogovate se na stranicu preko demo naloga
John Doe/ThisIsNotAPassword
o   Za proveru da li je korisnik ulogovan iskoristite metodu isFormPresented iz Test.AppointmentPage klase.
o   Popunite appointment formu
o   I proverite da li se unosi sa appointment forme uklapaju sa podacima sa summary stranice */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait waiter;

    public BasePage() {
    }

    public BasePage(WebDriver driver, WebDriverWait waiter) {
        this.driver = driver;
        this.waiter = waiter;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWaiter() {
        return waiter;
    }

    public void setWaiter(WebDriverWait waiter) {
        this.waiter = waiter;
    }
    public void clearField (By locator){
        driver.findElement(locator).clear();
    }
}
