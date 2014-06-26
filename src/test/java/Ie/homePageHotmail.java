package Ie;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by user on 6/15/14.
 */
public class homePageHotmail {
    private WebDriver driver;

    public homePageHotmail(WebDriver driver)
    {this.driver=driver;}

    public void checkIfAmongReceived(String subject)
    {        JavascriptExecutor je=(JavascriptExecutor) driver;

        String topic2= je.executeScript("return document.getElementsByClassName('c-MessageRow ia_hc animatable Draggable mlUnrd mlUnFlg mlUnsel t_s_hov')[0].children[3].children[0].innerHTML").toString();

        assertTrue("email was received by hotmail",topic2.contains(subject));
    }

    public void createEmail()
    {
        JavascriptExecutor je=(JavascriptExecutor)driver;
        je.executeScript("document.getElementById('NewMessage').click()");
    }

    public void setRcpt(String rcpt)
    {    JavascriptExecutor je=(JavascriptExecutor)driver;

         je.executeScript("document.getElementById('toBtn').click();;");
        je.executeScript("document.getElementsByClassName('cp_primaryInput cp_anyInput t_urtc')[0].value='"+rcpt+"';");
         /*Action enterRcpt = new Actions(driver).sendKeys(rcpt).build();
         enterRcpt.perform();*/
    }

    public void setSubject(String subject)
    {
        JavascriptExecutor je=(JavascriptExecutor)driver;

        je.executeScript("document.getElementById('fSubject').focus();");
        je.executeScript("document.getElementById('fSubject').value='"+subject+"'");

       /* Action enterSubj = new Actions(driver).sendKeys(subject).build();
        enterSubj.perform();*/
    }

    public void setBody(String body)
    {JavascriptExecutor je=(JavascriptExecutor)driver;
  //      je.executeScript("window[\"ComposeRteEditor_surface\"].contentDocument.children[0].children[1].innerHTML=\""+body+"\"");
        je.executeScript("document.getElementById(\"ComposeRteEditor_surface\").contentDocument.getElementsByClassName(\"t_mbgc t_atc RichText\")[0].innerHTML=\""+body+"\"");
    }

    public void sendEmail()
    {  JavascriptExecutor je=(JavascriptExecutor)driver;
        je.executeScript("document.getElementById(\"SendMessage\").click();");

      //driver.findElement(By.xpath("//*[@id='SendMessage']")).click();

    }

    public void gotoOutbox()

    {  JavascriptExecutor je=(JavascriptExecutor)driver;
        je.executeScript("document.getElementsByClassName('ellipsis')[4].click();");
    }

public void checkIfAmongSend(String topic)
    {
        JavascriptExecutor je=(JavascriptExecutor)driver;
        String topic2 = (String)je.executeScript("return document.getElementsByClassName(\"c-MessageRow ia_hc animatable Draggable mlRd mlUnFlg mlUnsel t_s_hov\")[0].children[3].children[0].innerHTML\n");
        System.out.println(topic2);
        System.out.println(topic);
        assertTrue("check if email was send by hotmail",topic2.contains(topic));

    }


}
