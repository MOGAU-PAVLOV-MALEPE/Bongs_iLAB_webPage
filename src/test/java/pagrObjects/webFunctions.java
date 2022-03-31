package pagrObjects;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import extendReport.reporting;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import webPageObjects.ApplyOnline;
import webPageObjects.Careers;
import webPageObjects.CurrentOpenings;
import webUtilities.generatePhoneNumber;
import webUtilities.webActions;

import java.sql.ResultSet;

public class webFunctions extends webActions {
    reporting repo = new reporting();

    public void CareerOpt(WebDriver driver){
        Careers CareerOptObject = new Careers (driver);
        try{
            clickObject(CareerOptObject.careers,driver);
            clickObject(CareerOptObject.country,driver);
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());

        }

    }//end CareerOpt

    public void currentOpenings(WebDriver driver){

        CurrentOpenings CurrOpeningObj = new CurrentOpenings(driver);
        try{
            clickObject(CurrOpeningObj.openings,driver);

        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());

        }
    }// end currentOpenings

    public void ApplyOnline(WebDriver driver, ResultSet resultSet, ExtentTest node){
        ApplyOnline applyOnlineObj = new ApplyOnline(driver);


        try{
            clickObject(applyOnlineObj.ApplyOnline,driver);
            sendKeysObject(applyOnlineObj.Yourname,driver,resultSet.getString("fullname"));
            sendKeysObject(applyOnlineObj.email,driver,resultSet.getString("email"));
            sendKeysObject(applyOnlineObj.phone,driver,generatePhoneNumber.RandomGenerator());
            clickObject(applyOnlineObj.submit,driver);

            //validation of uploading files
            String filename = repo.CaptureScreenShot(driver);
            if (applyOnlineObj.validate_text.isDisplayed()) {
                node.pass("Error message displayed", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());

            } else {
                node.fail("Error message is not displayed",  MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());

            }

        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            Assert.fail(e.getMessage());
        }

    }




}
