package poc.extent3;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class CapturingScreenshot {

    ExtentHtmlReporter extentHtmlReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;
    WebDriver webDriver;

    @BeforeTest
    public void startReport() {
        System.out.println("BeforeTest - startReport - Running");
        System.out.println(" - - - - - - - - - - - - - - - - - - -");

        extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ReportWithScreenshot.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
    }

    @Test
    public void captureScreenshot(){
        extentTest = extentReports.createTest("captureScreenshot");
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("http://google.com/");
        String pageTitle = webDriver.getTitle();
        Assert.assertEquals("xGoogle", pageTitle);
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE){
            String screenShotPath = GetScreenshot.capture(webDriver, "screenShotForExtentReport");
            extentTest.fail(MarkupHelper.createLabel(result.getName() + " Test Case FAILED.", ExtentColor.RED));
            extentTest.fail(result.getThrowable());
            extentTest.fail("Snapshot below: " + extentTest.addScreenCaptureFromPath(screenShotPath));
        }
    }

    @AfterTest
    public void endReport(){
        extentReports.flush();
    }


}
