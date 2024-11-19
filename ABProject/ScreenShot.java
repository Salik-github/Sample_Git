package ABProject;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import static ABProject.Utils.ScreenshotDestinationFile;

public class ScreenShot {
    
    public static String takeScreenshot(WebDriver driver, String filename)
    {
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File destinationFile = new File(ScreenshotDestinationFile +".png");

        try{
        FileUtils.copyFile(sourceFile, destinationFile);
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }

        System.out.println(destinationFile.getPath());
        return  destinationFile.getAbsolutePath();

    }
}
