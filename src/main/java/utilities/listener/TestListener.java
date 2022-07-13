package utilities.listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public void onTestFailure(ITestResult result) {
        System.out.printf("%s is failed", getTestMethodName(result));

        System.out.printf("Screenshot captured for test case: %s", getTestMethodName(result));
        saveScreenShotPNG(Actions.driver());
        saveTextLog(getTestMethodName(result) + " failed and screenshot is taken");
    }

    private static String getTestMethodName(ITestResult testResult) {
        return testResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenShotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }
}

