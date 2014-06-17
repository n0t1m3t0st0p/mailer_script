package Opera;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

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
    {    Driver.set(Driver.BrowserName.OPERA);
        driver = Driver.get();
    }

    @Test
    public void gmailSend()
    {
        driver.navigate().to(gmailLoginUrl);

        userData user1=new userData();
        user1.createUser(gmailEmail,gmailPwd);

        //GMAIL LOGIN DIALOGUE

        loginPageGmail LP = new loginPageGmail(driver);

        homePageGmail HP = new homePageGmail(driver);

        HP=LP.loginUserSuccess(user1);


        try
{
//MESSAGE SEND START

        Thread.sleep(sleepTime*4);
        HP.createEmail();

        Thread.sleep(sleepTime);
        HP.setRcpt(rcptAddr1);

        HP.setSubject(topicG +ID);

        HP.setBody(body1);

        HP.sendEmail();

//MESSAGE OUTBOX CHECK

        Thread.sleep(sleepTime);
        HP.gotoOutbox();
        Thread.sleep(sleepTime);

        String topic1=topicG+ID;

        HP.checkIfAmongSend(topicG + ID);

//HOTMAIL DELIVERY CHECK

        driver.navigate().to(hotmailLoginUrl);

        assertThat("login title is correct", driver.getTitle(), containsString("Sign In"));

        userData user2=new userData();
        user2.createUser(hotmailEmail,hotmailPwd);

        loginPageHotmail LP2 = new loginPageHotmail(driver);
        homePageHotmail HP2=LP2.loginUserSuccess(user2);

//CHECK IF EMAIL RECEIVED BY HOTMAIL

        HP2.checkIfAmongReceived(topicG + ID);
        Thread.sleep(sleepTime);

}catch(Exception e)
        { System.out.println("Exception - > " + e.toString());
        }


    }

    @Test

    public void hotmailSend()

   {

    //ENTERING HOTMAIL BOX

       driver.navigate().to(hotmailLoginUrl);

       assertThat("login title is correct", driver.getTitle(), containsString("Sign In"));

       userData user2=new userData();
       user2.createUser(hotmailEmail,hotmailPwd);

       loginPageHotmail LP2 = new loginPageHotmail(driver);
       homePageHotmail HP2=LP2.loginUserSuccess(user2);

       JavascriptExecutor je=(JavascriptExecutor)driver;

       //SENDING MESSAGE TO GMAIL

try{
    Thread.sleep(sleepTime);
    assertThat("Correct email box check", je.executeScript("return document.title;").toString(), is("Outlook.com - n0t1m3t0st0p@hotmail.com"));

    //LOGIN INTO MAILBOX
    Thread.sleep(sleepTime);
    HP2.createEmail();

    Thread.sleep(sleepTime);
    HP2.setRcpt(rcptAddr2);

    Thread.sleep(sleepTime);
    HP2.setSubject(topicH+ID);

    Thread.sleep(sleepTime);
    HP2.setBody(body2);

    Thread.sleep(sleepTime);
    HP2.sendEmail();

    //CHECKING EMAIL IS IN SEND

    Thread.sleep(sleepTime);
    HP2.gotoOutbox();

    Thread.sleep(sleepTime);
    HP2.checkIfAmongSend(topicH + ID);

    Thread.sleep(sleepTime);
  // CHECK IF GMAIL BOX RECEIVED THE MAIL

    driver.navigate().to(gmailLoginUrl);

    userData user1=new userData();
    user1.createUser(gmailEmail, gmailPwd);

    loginPageGmail LP = new loginPageGmail(driver);
    homePageGmail HP = new homePageGmail(driver);

    HP=LP.loginUserSuccess(user1);

    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    assertThat("login into n0t1m3t0st0p@gmail.com was succesfull", driver.findElement(By.xpath("//*[@title='n0t1m3t0st0p@gmail.com']")).getText(), containsString("n0t1m3t0st0p@gmail.com"));


    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    HP.checkIfAmongReceived(topicH + ID);
}
catch(Exception e)
{ System.out.println("Exception - > " + e.toString());
}
   }
  @After
    public void CloseDriver()
    {driver.close();}


}