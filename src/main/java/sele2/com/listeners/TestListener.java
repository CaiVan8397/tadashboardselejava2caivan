package sele2.com.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import sele2.com.driver.DriverManager;


public class TestListener implements ITestListener {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("{} is failed", getTestMethodName(result));

        log.error("Screenshot captured for test case: {}", getTestMethodName(result));
        saveScreenShotPNG(DriverManager.getDriver());
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
