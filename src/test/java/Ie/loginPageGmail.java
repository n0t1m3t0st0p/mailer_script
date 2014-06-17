package Ie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by user on 6/15/14.
 */
public class loginPageGmail {

    private WebDriver driver;

        public loginPageGmail(WebDriver driver)
        {this.driver=driver;}


        private void loginUser(userData user)
        {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Email']")));

        Action clickEmailField= new Actions(driver).click(driver.findElement(By.xpath("//*[@id='Email']"))).build();
        clickEmailField.perform();

        Action enterEmail = new Actions(driver).sendKeys(userData.email).build();
        enterEmail.perform();

        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Passwd']")));


        Action clickPwdField= new Actions(driver).click(driver.findElement(By.xpath("//*[@id='Passwd']"))).build();
        clickPwdField.perform();
        Action enterPwd = new Actions(driver).sendKeys(userData.password).build();
        enterPwd.perform();

        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='signIn']")));

        Action confirmEmailPwd= new Actions(driver).click(driver.findElement(By.xpath("//*[@id='signIn']"))).build();
        confirmEmailPwd.perform();
        }

        public homePageGmail loginUserSuccess(userData user)
        {loginUser(user);
         return new homePageGmail(driver);
        }

        public loginPageGmail loginUserError(userData user)
        {loginUser(user);
            return new loginPageGmail(driver);
         }

}
