package webUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.Random;

public class webActions {

    //ClickMethod
    public void clickObject(WebElement element, WebDriver driver)
    {
        try
        {
            if (element.isDisplayed())
            {
                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(1000))
                        .ignoring(WebDriverException.class);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
            }
        } catch (Exception e){
            System.out.println(element + "Not found");
        }
    }

    //sendKeysMethod
    public void sendKeysObject(WebElement txtbox, WebDriver driver,String data)
    {
        try
        {
            if (txtbox.isDisplayed())
            {
                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(1000))
                        .ignoring(WebDriverException.class);
                wait.until(ExpectedConditions.elementToBeClickable(txtbox));

                txtbox.clear();
                txtbox.sendKeys(data);
            }
        } catch (Exception e){
            System.out.println(txtbox + "Not found");
        }
    }


}
