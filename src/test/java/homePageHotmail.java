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

    public void checkIfAmongSend(String subject)
    {        JavascriptExecutor je=(JavascriptExecutor) driver;

        String topic2= je.executeScript("return document.getElementsByClassName('c-MessageRow ia_hc animatable Draggable mlUnrd mlUnFlg mlUnsel t_s_hov')[0].children[3].children[0].innerHTML").toString();

        assertTrue("email was received by hotmail",topic2.contains(subject));
    }
}
