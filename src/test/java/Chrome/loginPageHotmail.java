package Chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by user on 6/15/14.
 */
public class loginPageHotmail {
    private WebDriver driver;

    public loginPageHotmail(WebDriver driver)
    {this.driver=driver;}

    public void loginUser(userData user)
    {   Action clickEmailField2= new Actions(driver).click(driver.findElement(By.xpath("//*[@type='email']"))).build();
        clickEmailField2.perform();

        Action enterEmail2 = new Actions(driver).sendKeys(userData.email).build();
        enterEmail2.perform();
        ////*[@type='password']

        Action clickPwdField2= new Actions(driver).click(driver.findElement(By.xpath("//*[@type='password']"))).build();
        clickPwdField2.perform();

        Action enterPwd2 = new Actions(driver).sendKeys(userData.password).build();
        enterPwd2.perform();

        ////*[@type='submit']

        Action confirmEmailPwd2= new Actions(driver).click(driver.findElement(By.xpath("//*[@type='submit']"))).build();
        confirmEmailPwd2.perform();
    }

    public homePageHotmail loginUserSuccess(userData user)
    {   loginUser(user);
        return new homePageHotmail(driver);
    }

}
