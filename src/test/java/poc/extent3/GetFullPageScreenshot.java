package poc.extent3;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GetFullPageScreenshot {

    public static String captureFullPage(WebDriver driver, String screenshotNameFullPage) throws IOException {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        String targetFilePathAndName = System.getProperty("user.dir")+"/test-output/"+screenshotNameFullPage+".png";
        ImageIO.write(screenshot.getImage(), "PNG", new File(targetFilePathAndName));
        return targetFilePathAndName;
    }

}
