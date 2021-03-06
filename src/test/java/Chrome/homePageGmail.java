package Chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by user on 6/15/14.
 */
public class homePageGmail {
    private WebDriver driver;

    public homePageGmail(WebDriver driver)
    {this.driver=driver;}

    public void createEmail()
    {   Action createEmail= new Actions(driver).click(driver.findElement(By.xpath("//*[@class='T-I J-J5-Ji T-I-KE L3']"))).build();
        createEmail.perform();
    }

    public void setRcpt(String rcptAddr1)
    {Action clickRecipientField= new Actions(driver).click(driver.findElement(By.xpath("//textarea[@name='to']"))).build();
        clickRecipientField.perform();

        Action enterRcpt = new Actions(driver).sendKeys(rcptAddr1).build();
        enterRcpt.perform();
    }

    public void setSubject(String subject)
    {


        JavascriptExecutor je=(JavascriptExecutor)driver;
        je.executeScript("document.getElementsByName('subjectbox')[0].value='"+subject+"';");


    }

    public void setBody(String body)

    {   /*WebElement emailFrame=driver.findElement(By.xpath("//iframe[@tabindex='1']"));
        driver.switchTo().frame(emailFrame);
        Action clickOnEmailBody= new Actions(driver).click(driver.findElement(By.xpath("//*[@role='textbox']"))).build();
        clickOnEmailBody.perform();

        Action enterBody = new Actions(driver).sendKeys(body).build();
        enterBody.perform();
        */
        //document.getElementsByClassName('Am Al editable LW-avf')[0].innerHTML


        JavascriptExecutor je=(JavascriptExecutor)driver;
        je.executeScript("document.getElementsByClassName('Am Al editable LW-avf')[0].innerHTML='"+body+"';");

    }

    public void sendEmail()
    {   driver.switchTo().defaultContent();
        Action sendEmail= new Actions(driver).click(driver.findElement(By.xpath("//*[@role='button'][@tabindex='1']"))).build();
        sendEmail.perform();}

    public void gotoOutbox()
    {Action gotoOutbox= new Actions(driver).click(driver.findElement(By.xpath("//*[@href='https://mail.google.com/mail/#sent']"))).build();
    gotoOutbox.perform();}

    public void checkIfAmongSend(String subject)
    {
      assertTrue("check if email was send by hotmail", driver.findElement(By.xpath("//span[contains(text(),'" + subject + "')]")).isDisplayed());
    }

    public void checkIfAmongReceived(String subject)
    {           assertTrue("Hotmail Email is received by Gmail",(driver.findElement(By.xpath("//b[contains(text(),'" + subject+ "')]")).isDisplayed()));
    }


    public void logoutGmail()//THIS METHOD IS ABSENT IN CODE FOR IE
    {//document.getElementsByClassName("gb_y gb_4 gb_e gb_X")[0].click}
        JavascriptExecutor je=(JavascriptExecutor)driver;
       // je.executeScript("document.getElementsByClassName(\"gb_y gb_4 gb_e gb_X\")[0].click()");
        //document.getElementsByClassName("gb_Nb gb_Vb gb_T")[0].click()
        je.executeScript("document.getElementsByClassName(\"gb_Nb gb_Vb gb_T\")[0].click()");

    }
}
