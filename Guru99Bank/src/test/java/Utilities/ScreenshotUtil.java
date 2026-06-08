package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static void captureScreenshot(
            WebDriver driver,
            String fileName) {

        try {

            if (driver == null) {

                System.out.println(
                        "Driver is null. Screenshot skipped.");

                return;
            }

            File src =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(
                                    OutputType.FILE);

            FileUtils.copyFile(
                    src,
                    new File(
                            "./screenshots/"
                                    + fileName
                                    + ".png"));

        } catch (IOException e) {

            e.printStackTrace();

        } catch (Exception e) {

            System.out.println(
                    "Screenshot capture failed : "
                            + e.getMessage());
        }
    }
}