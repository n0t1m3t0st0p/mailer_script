package Chrome;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

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
         Action enterRcpt = new Actions(driver).sendKeys(rcpt).build();
         enterRcpt.perform();
    }

    public void setSubject(String subject)
    {
        JavascriptExecutor je=(JavascriptExecutor)driver;

        je.executeScript("document.getElementById('fSubject').focus();");
        Action enterSubj = new Actions(driver).sendKeys(subject).build();
        enterSubj.perform();
    }

    public void setBody(String body)
    {JavascriptExecutor je=(JavascriptExecutor)driver;
        je.executeScript("window[\"ComposeRteEditor_surface\"].contentDocument.children[0].children[1].innerHTML=\""+body+"\"");
    }

    public void sendEmail()
    {  JavascriptExecutor je=(JavascriptExecutor)driver;
        je.executeScript("document.getElementById(\"SendMessage\").click();");
    }

    public void gotoOutbox()

    {  JavascriptExecutor je=(JavascriptExecutor)driver;
        je.executeScript("document.getElementsByClassName('ellipsis')[4].click();");
    }

public void checkIfAmongSend(String topic)
    {
        JavascriptExecutor je=(JavascriptExecutor)driver;
        String topic2 = (String)je.executeScript("return document.getElementsByClassName(\"c-MessageRow ia_hc animatable Draggable mlRd mlUnFlg mlUnsel t_s_hov\")[0].children[3].children[0].innerHTML\n");
        assertTrue("check if email was send by hotmail",topic2.contains(topic));
    }


public void logoutHotmail()//THIS METHOD IS ABSENT IN CODE FOR IE
        {

        //document.getElementById("c_meun").click()
        JavascriptExecutor je=(JavascriptExecutor)driver;
       // je.executeScript("document.getElementById(\"c_meun\").click()");
        //document.getElementById("c_signout").click();
        je.executeScript("document.getElementById(\"c_signout\").click();");

        }

        }
