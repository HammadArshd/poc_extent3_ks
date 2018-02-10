package poc.extent3.extentReportWithMultiClassTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public static ExtentHtmlReporter extentHtmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    @BeforeSuite
    public void startReport(){
        System.out.println("BeforeSuite - startReport - Running");
        System.out.println(" - - - - - - - - - - - - - - - - - - -");

        extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/MyOwnReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("Selenium Version", "2.46");
        extentReports.setSystemInfo("Environment", "Development");
        extentReports.setSystemInfo("HostName", "Hammad");

        extentHtmlReporter.config().setDocumentTitle("LMS Web APP QA Report");
        extentHtmlReporter.config().setReportName("Hammad Report");
        extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        extentHtmlReporter.config().setTheme(Theme.STANDARD);
    }

    @AfterMethod
    public void getResult(ITestResult result){
        System.out.println("AfterMethod - getResult - Running");
        System.out.println(" = = = = = = = = = = = = = = = = = = = ");

        if (result.getStatus() == ITestResult.FAILURE){
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues.", ExtentColor.RED));
            extentTest.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS){
            extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test case PASSED.", ExtentColor.GREEN));
        }
        else {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test case SKIPPED.", ExtentColor.YELLOW));
            extentTest.skip(result.getThrowable());
        }
    }

    @AfterSuite
    public void endReport(){
        System.out.println("AfterSuite - endReport - Running");
        System.out.println(" ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        
        extentReports.flush();
    }

}
