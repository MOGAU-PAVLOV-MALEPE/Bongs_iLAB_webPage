package webTests;

import Data.data;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import extendReport.reporting;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pagrObjects.webFunctions;
import webUtilities.webUtilities;

import java.sql.ResultSet;

public class TestRunner {

    public webUtilities web = new webUtilities();
    public webFunctions iLab = new webFunctions();
    public reporting repo = new reporting();
    public data dat = new data();

    String sUrl, sBrowser;
    ExtentReports reports;

    @Parameters({"iLabURL", "Browser"})
    @BeforeTest
    public void init(String iLabURL, String Browser) {
        sUrl = iLabURL;
        sBrowser = Browser;


        web.setWebDriver(web.initializeWebDriver(sBrowser));
        reports = repo.initializeExtentReports("reports/test.html");

    }// end method init

    @Test
    public void TestRunner()throws Exception{
        ResultSet rs;
        ExtentTest test = reports.createTest("iLAB webPage").assignAuthor("Pavlov(PABLO)");
        ExtentTest node;

        rs = dat.ConnectAndQuerySql("jdbc:mysql://localhost:3306/automationtraingdb", "root", "Pavlov146", "Select * from Apply_info");

        try{
            web.navigate(sUrl);
            while (rs.next()){
                node = test.createNode("Current Opening post in S.A: "+(rs).getString("fullname"));
                iLab.CareerOpt(web.getWebDriver());
                iLab.currentOpenings(web.getWebDriver());
                iLab.ApplyOnline(web.getWebDriver(),rs,node);
            }
        }catch (Exception e){
            System.out.println("Error during testing the iLab web Page ,ERROR: "+ e.getMessage());
        }

    }


    @AfterTest
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        web.getWebDriver().quit();
        reports.flush();
    }

}
