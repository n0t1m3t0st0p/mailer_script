package Opera;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 6/15/14.
 */
public class loginPageHotmail {
    private WebDriver driver;

    public loginPageHotmail(WebDriver driver)
    {this.driver=driver;}

    public void loginUser(userData user)
    {

        try{
        JavascriptExecutor je=(JavascriptExecutor)driver;

           // Thread.sleep(2000);
        je.executeScript("document.getElementsByName('login')[0].value='"+userData.email+"';");
          //  je.executeScript("document.getElementsByName('login')[0].click();");

/*        Action clickEmailField2= new Actions(driver).click(driver.findElement(By.xpath("//*[@type='email']"))).build();
        clickEmailField2.perform();
*/

//        driver.findElement(By.xpath("//*[@type='email']")).click();

/*        Action enterEmail2 = new Actions(driver).sendKeys(userData.email).build();
        enterEmail2.perform();
 */
        ////*[@type='password']
            //Thread.sleep(2000);
            je.executeScript("document.getElementsByName('passwd')[0].value='"+userData.password+"';");
 //           je.executeScript("document.getElementsByName('passwd')[0].click();");



/*        Action clickPwdField2= new Actions(driver).click(driver.findElement(By.xpath("//*[@type='password']"))).build();
        clickPwdField2.perform();
*/

//        driver.findElement(By.xpath("//*[@type='password']")).click();

/*        Action enterPwd2 = new Actions(driver).sendKeys(userData.password).build();
        enterPwd2.perform();
*/
        ////*[@type='submit']
          //  Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@type='submit']")).click();

        }catch(Exception e)
        { System.out.println("Exception - > " + e.toString());
        }

//        Action confirmEmailPwd2= new Actions(driver).click(driver.findElement(By.xpath("//*[@type='submit']"))).build();
 //       confirmEmailPwd2.perform();



}

    public homePageHotmail loginUserSuccess(userData user)
    {   loginUser(user);
        return new homePageHotmail(driver);
    }

}
