import junit.framework.*;
import org.junit.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by user on 23.05.14.
 */
public class VCS_test_1 {

    static WebDriver driver;

    //https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=12&ct=1401037794&rver=6.4.6456.0&wp=MBI&wreply=http:%2F%2Fmail.live.com%2Fdefault.aspx&lc=1033&id=64855&mkt=en-us&cbcxt=mai&snsc=1

    final String gmailLoginUrl= "https://accounts.google.com/ServiceLogin?sacu=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=ru&service=mail";
    final String gmailEmail= "n0t1m3t0st0p@gmail.com";
    final String hotmailLoginUrl="https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=12&ct=1401037794&rver=6.4.6456.0&wp=MBI&wreply=http:%2F%2Fmail.live.com%2Fdefault.aspx&lc=1033&id=64855&mkt=en-us&cbcxt=mai&snsc=1";
    final String gmailPwd="NoTimeToStop4U";
    final String hotmailEmail= "n0t1m3t0st0p@hotmail.com";
    final String hotmailPwd="NoTimeToStop4U2";
    final String rcptAddr1="n0t1m3t0st0p@hotmail.com";
    final String rcptAddr2="n0t1m3t0st0p@gmail.com";
    final String topicG ="test email from gmail";
    final String topicH ="test email from hotmail";
    final String body1="Hello! here is my test email from Gmail service";
    final String body2="Hello! here is my test email from Hotmail service";
    final String ID=new java.util.Date().toString();
    final int sleepTime=2000;


   /* @BeforeClass
   public static void DriverInit()
   {    Driver.set(Driver.BrowserName.FIREFOX);
       driver = Driver.get();
   }
   */

    @Before
    public void DriverInit()
    {    Driver.set(Driver.BrowserName.FIREFOX);
        driver = Driver.get();
    }

    @Test
    public void gmailSend()
    {
        driver.navigate().to(gmailLoginUrl);

        //GMAIL LOGIN DIALOGUE


     //   assertThat("login title is correct", driver.getTitle(), containsString("Gmail"));
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Email']")));

        Action clickEmailField= new Actions(driver).click(driver.findElement(By.xpath("//*[@id='Email']"))).build();
        clickEmailField.perform();

        Action enterEmail = new Actions(driver).sendKeys(gmailEmail).build();
        enterEmail.perform();

        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Passwd']")));


        Action clickPwdField= new Actions(driver).click(driver.findElement(By.xpath("//*[@id='Passwd']"))).build();
        clickPwdField.perform();
        Action enterPwd = new Actions(driver).sendKeys(gmailPwd).build();
        enterPwd.perform();

        ////*[@id='signIn']

        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='signIn']")));

        Action confirmEmailPwd= new Actions(driver).click(driver.findElement(By.xpath("//*[@id='signIn']"))).build();
        confirmEmailPwd.perform();

        ////*[@title='n0t1m3t0st0p@gmail.com']

try
{
//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Thread.sleep(sleepTime*4);
       //assertTrue("login into n0t1m3t0st0p@gmail.com was succesfull", driver.findElement(By.xpath("//title[contains(text(),'n0t1m3t0st0p@gmail.com')]")).isDisplayed());

        ////*[@class='T-I J-J5-Ji T-I-KE L3']

        Action createEmail= new Actions(driver).click(driver.findElement(By.xpath("//*[@class='T-I J-J5-Ji T-I-KE L3']"))).build();
        createEmail.perform();

        ////textarea[@name='to']
        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        Thread.sleep(sleepTime);
        Action clickRecipientField= new Actions(driver).click(driver.findElement(By.xpath("//textarea[@name='to']"))).build();
        clickRecipientField.perform();

        Action enterRcpt = new Actions(driver).sendKeys(rcptAddr1).build();
        enterRcpt.perform();

        ////input[@name='subjectbox']

        Action clickTopicField= new Actions(driver).click(driver.findElement(By.xpath("//input[@name='subjectbox']"))).build();
        clickTopicField.perform();


        Action enterTopic = new Actions(driver).sendKeys(topicG +ID).build();
        enterTopic.perform();

        ////iframe[@tabindex='1']

        WebElement emailFrame=driver.findElement(By.xpath("//iframe[@tabindex='1']"));
        driver.switchTo().frame(emailFrame);
        Action clickOnEmailBody= new Actions(driver).click(driver.findElement(By.xpath("//*[@role='textbox']"))).build();
        clickOnEmailBody.perform();

        Action enterBody = new Actions(driver).sendKeys(body1).build();
        enterBody.perform();

        ////*[@role='button'][@tabindex='1']

        driver.switchTo().defaultContent();
        Action sendEmail= new Actions(driver).click(driver.findElement(By.xpath("//*[@role='button'][@tabindex='1']"))).build();
        sendEmail.perform();

//MESSAGE SEND END

//MESSAGE OUTBOX CHECK
        Thread.sleep(sleepTime);
     ////span[@id=':7u'][contains(text(),'test email from gmail')]

     //   assertTrue("Assert that email was send", driver.findElement(By.xpath("//div[@class='vh'][contains(text(),'Письмо отправлено.')]//div[@class='vh'][contains(text(),'Письмо отправлено.')]")).isDisplayed());

     ////*[@href='https://mail.google.com/mail/#sent']

        Action gotoOutbox= new Actions(driver).click(driver.findElement(By.xpath("//*[@href='https://mail.google.com/mail/#sent']"))).build();
        gotoOutbox.perform();
     ////span[contains(text(),'test email from gmail')]
        String topic1=topicG +ID;

         Thread.sleep(sleepTime);
        assertTrue("check if email was send", driver.findElement(By.xpath("//span[contains(text(),'" + topic1 + "')]")).isDisplayed());


        ///!!

        driver.navigate().to(hotmailLoginUrl);
        assertThat("login title is correct", driver.getTitle(), containsString("Sign In"));


        ////*[@type='email']

        Action clickEmailField2= new Actions(driver).click(driver.findElement(By.xpath("//*[@type='email']"))).build();
        clickEmailField2.perform();

        Action enterEmail2 = new Actions(driver).sendKeys(hotmailEmail).build();
        enterEmail2.perform();
        ////*[@type='password']

        Action clickPwdField2= new Actions(driver).click(driver.findElement(By.xpath("//*[@type='password']"))).build();
        clickPwdField2.perform();

        Action enterPwd2 = new Actions(driver).sendKeys(hotmailPwd).build();
        enterPwd2.perform();

        ////*[@type='submit']

        Action confirmEmailPwd2= new Actions(driver).click(driver.findElement(By.xpath("//*[@type='submit']"))).build();
        confirmEmailPwd2.perform();

        ////span[contains(text(),'        7:53 PM      ')]
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //CHECK IF EMAIL RECEIVED BY HOTMAIL

        ////*[@aria-label='Unread. QA Engineer. test email from gmailTue May 27 13:39:46 EEST 2014. 1:39 PM. ']
        ////*[contains(@aria-label,'test email from gmailTue May 27 14:13:16 EEST 2014')]
//         assertTrue("check if email was send", driver.findElement(By.xpath("//*[contains(@aria-label,'"+topicG+ID+"')]")).isDisplayed());
        //assertTrue("check if email was send", driver.findElement(By.xpath("//*[contains(@aria-label,'test email from gmailTue May 27 14:13:16 EEST 2014')]")).isDisplayed());

        JavascriptExecutor je=(JavascriptExecutor) driver;

        Thread.sleep(sleepTime);


        String topic2= je.executeScript("return document.getElementsByClassName('c-MessageRow ia_hc animatable Draggable mlUnrd mlUnFlg mlUnsel t_s_hov')[0].children[3].children[0].innerHTML").toString();

        assertTrue("email was received by hotmail",topic2.contains(topic1));

        //   System.out.println(je.executeScript("return document.getElementsByClassName('Fm')[0]").toString());
}catch(Exception e)
        { System.out.println("Exception - > " + e.toString());
        }


    }

    @Test

    public void hotmailSend()

   {

    //ENTERING HOTMAIL BOX

       driver.navigate().to(hotmailLoginUrl);

       final JavascriptExecutor je=(JavascriptExecutor) driver;

       assertThat("login title is correct", driver.getTitle(), containsString("Sign In"));

       ////*[@type='email']

       Action clickEmailField2= new Actions(driver).click(driver.findElement(By.xpath("//*[@type='email']"))).build();
       clickEmailField2.perform();

       Action enterEmail2 = new Actions(driver).sendKeys(hotmailEmail).build();
       enterEmail2.perform();
       ////*[@type='password']

       Action clickPwdField2= new Actions(driver).click(driver.findElement(By.xpath("//*[@type='password']"))).build();
       clickPwdField2.perform();

       Action enterPwd2 = new Actions(driver).sendKeys(hotmailPwd).build();
       enterPwd2.perform();

       ////*[@type='submit']

       Action confirmEmailPwd2= new Actions(driver).click(driver.findElement(By.xpath("//*[@type='submit']"))).build();
       confirmEmailPwd2.perform()   ;
       //SENDING MESSAGE TO GMAIL

//driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
try{
    Thread.sleep(sleepTime);
    assertThat("Correct email box check", je.executeScript("return document.title;").toString(), is("Outlook.com - n0t1m3t0st0p@hotmail.com"));

    Thread.sleep(sleepTime);

       je.executeScript("document.getElementById('NewMessage').click()");

    Thread.sleep(sleepTime);
 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        je.executeScript("document.getElementById('toBtn').click();;");
    Thread.sleep(sleepTime);
    //   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


       Action enterRcpt = new Actions(driver).sendKeys(rcptAddr2).build();
       enterRcpt.perform();
    Thread.sleep(sleepTime);
       //document.getElementById('fSubject').click();
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       je.executeScript("document.getElementById('fSubject').focus();");

    Thread.sleep(sleepTime);
       //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    String topic1= topicH +ID;

       Action enterSubj = new Actions(driver).sendKeys(topic1).build();
       enterSubj.perform();

//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    Thread.sleep(sleepTime);
       je.executeScript("window[\"ComposeRteEditor_surface\"].contentDocument.children[0].children[1].innerHTML=\""+body2+"\"");

//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    Thread.sleep(sleepTime);
    je.executeScript("document.getElementById(\"SendMessage\").click();");




//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


       //CHECKING EMAIL IS IN SEND

       //driver.findElement(By.xpath("//li[contains(@title,'Sent')]")).click();
    Thread.sleep(sleepTime);

    je.executeScript("document.getElementsByClassName('ellipsis')[4].click();");
       //document.getElementsByClassName("c-MessageRow ia_hc animatable Draggable mlRd mlUnFlg mlUnsel t_s_hov")[0].click()
       //document.getElementsByClassName("c-MessageRow ia_hc animatable Draggable mlRd mlUnFlg mlUnsel t_s_hov")[1].children[0].children[0].getAttribute("aria-label")


 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    Thread.sleep(sleepTime);

    //document.getElementsByClassName("c-MessageRow ia_hc animatable Draggable mlRd mlUnFlg mlUnsel t_s_hov")[0].children[3].children[0].innerHTML

    //String topic2 = (String)je.executeScript("return document.getElementsByClassName(\"c-MessageRow ia_hc animatable Draggable mlRd mlUnFlg mlUnsel t_s_hov\")[1].children[0].children[0].getAttribute(\"aria-label\");");
    String topic2 = (String)je.executeScript("return document.getElementsByClassName(\"c-MessageRow ia_hc animatable Draggable mlRd mlUnFlg mlUnsel t_s_hov\")[0].children[3].children[0].innerHTML\n");

      //System.out.println(je.executeScript("return $(\".rmSubject\").text();").toString());
      // System.out.println(topicG + ID);

 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       assertTrue("email was received by hotmail",topic2.contains(topic1));



  // CHECK IF GMAIL BOX RECEIVED THE MAIL

    driver.navigate().to(gmailLoginUrl);

   // assertThat("login title is correct", driver.getTitle(), containsString("Gmail"));

       Action clickEmailField= new Actions(driver).click(driver.findElement(By.xpath("//*[@id='Email']"))).build();
       clickEmailField.perform();
       Action enterEmail = new Actions(driver).sendKeys(gmailEmail).build();
       enterEmail.perform();

       Action clickPwdField= new Actions(driver).click(driver.findElement(By.xpath("//*[@id='Passwd']"))).build();
       clickPwdField.perform();
       Action enterPwd = new Actions(driver).sendKeys(gmailPwd).build();
       enterPwd.perform();

       ////*[@id='signIn']

       Action confirmEmailPwd= new Actions(driver).click(driver.findElement(By.xpath("//*[@id='signIn']"))).build();
       confirmEmailPwd.perform();

       ////*[@title='n0t1m3t0st0p@gmail.com']

       driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
       assertThat("login into n0t1m3t0st0p@gmail.com was succesfull", driver.findElement(By.xpath("//*[@title='n0t1m3t0st0p@gmail.com']")).getText(), containsString("n0t1m3t0st0p@gmail.com"));


       driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

       //b[contains(text(),'test email from hotmailThu Jun 05 22:55:01 EEST 2014')]
       assertTrue("Hotmail Email is received by Gmail",(driver.findElement(By.xpath("//b[contains(text(),'" + topic1 + "')]")).isDisplayed()));

}
catch(Exception e)
{ System.out.println("Exception - > " + e.toString());
}
   }
  @After
    public void CloseDriver()
    {driver.close();}

   /*@AfterClass
    public static void CloseDriver2()
    {driver.close();}
*/
}