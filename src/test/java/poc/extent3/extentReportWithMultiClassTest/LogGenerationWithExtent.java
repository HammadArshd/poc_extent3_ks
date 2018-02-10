package poc.extent3.extentReportWithMultiClassTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.annotations.Test;

public class LogGenerationWithExtent extends BaseTest {

    @Test
    public void logGeneration(){
        extentTest = extentReports.createTest("logGeneration");
        extentTest.log(Status.INFO, "createTest() method will return the ExtentTest object.");
        extentTest.log(Status.INFO, "I am in actual Test Case.");
        extentTest.log(Status.INFO, "We can write the actual extentTest logic in this extentTest.");

        // Using Labels
        extentTest.info(MarkupHelper.createLabel("****** Using Labels ******", ExtentColor.RED));
        extentTest.info(MarkupHelper.createLabel("This is Test Logger Blue", ExtentColor.BLUE));
        extentTest.info(MarkupHelper.createLabel("This is Test Logger Brown", ExtentColor.BROWN));
        extentTest.info(MarkupHelper.createLabel("This is Test Logger Green", ExtentColor.GREEN));
        extentTest.info(MarkupHelper.createLabel("This is Test Logger Grey", ExtentColor.GREY));
    }
}
