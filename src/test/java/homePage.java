import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by user on 6/15/14.
 */
public class homePage {
    private WebDriver driver;

    public homePage(WebDriver driver)
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
    {    Action clickTopicField= new Actions(driver).click(driver.findElement(By.xpath("//input[@name='subjectbox']"))).build();
        clickTopicField.perform();


        Action enterTopic = new Actions(driver).sendKeys(subject).build();
        enterTopic.perform();
    }

    public void setBody(String body)

    { WebElement emailFrame=driver.findElement(By.xpath("//iframe[@tabindex='1']"));
        driver.switchTo().frame(emailFrame);
        Action clickOnEmailBody= new Actions(driver).click(driver.findElement(By.xpath("//*[@role='textbox']"))).build();
        clickOnEmailBody.perform();

        Action enterBody = new Actions(driver).sendKeys(body).build();
        enterBody.perform();

        ////*[@role='button'][@tabindex='1']
    }

    public void sendEmail()
    {   driver.switchTo().defaultContent();
        Action sendEmail= new Actions(driver).click(driver.findElement(By.xpath("//*[@role='button'][@tabindex='1']"))).build();
        sendEmail.perform();}
}
