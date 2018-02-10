package poc.extent3.extentReportWithMultiClassTest;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class GenerateExtentReport extends BaseTest {


    @Test
    public void demoTestPass(){
        extentTest = extentReports.createTest("demoTestPass", "This extentTest will demonstrate the PASS extentTest case.");
        Assert.assertTrue(true);
    }


    @Test
    public void demoTestFail(){
        extentTest = extentReports.createTest("demoTestFail", "This extentTest will demonstrate the FAIL extentTest case.");
        Assert.assertTrue(false);
    }

    @Test
    public void demoTestSkip(){
        extentTest = extentReports.createTest("demoTestSkip", "This extentTest will demonstrate the SKIP extentTest case.");
        throw new SkipException("This extentTest case not ready for Execution");
    }

}
