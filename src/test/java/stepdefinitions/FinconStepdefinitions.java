package stepdefinitions;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages.FinconPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;


public class FinconStepdefinitions {

    FinconPage finconPage = new FinconPage();
    Actions actions = new Actions(Driver.getDriver());

    @Given("Der User öffnet die {string}")
    public void derUserÖffnetDie(String start_seite) {
        Driver.getDriver().get(ConfigReader.getProperty(start_seite));
        finconPage.speichern.click();

       /*Thread.sleep(2);
        finconPage.itBeratung.click();
        String grüẞSatz = finconPage.seiteGrüẞSatz.getText();
        System.out.println(grüẞSatz);

        */
    }

    @Then("Der User klick auf Menu")
    public void derUserKlickAufMenu() throws InterruptedException {
        finconPage.menu.click();
        Thread.sleep(2000);
    }

    @And("Der User scroll down")
    public void derUserScrollDown() throws InterruptedException {
        finconPage.zweiteMenu.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @And("Der User klick auf Standorte")
    public void derUserKlickAufStandorte() throws InterruptedException {
        for (WebElement w: finconPage.menuList
             ) {
            System.out.println(w.getText());
            if (w.getText().contains("Standorte")){
                System.out.println(w.getText());
                Thread.sleep(2000);
                w.click();
            }
        }


        for (WebElement w: finconPage.standoerten
             ) {
            //w.getText();
            System.out.println(w.getText());
        }
    }
}
