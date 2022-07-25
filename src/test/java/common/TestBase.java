package common;

import sele2.com.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.*;
import sele2.com.driver.DriverManager;
import sele2.com.driver.TargetFactory;

import java.lang.reflect.Method;

@Listeners({TestListener.class})
public class TestBase {

    @BeforeSuite
    public void beforeSuite() {
    }

    @Parameters("BROWSER")
    @BeforeMethod(alwaysRun = true)
    public void createDriver(@Optional("chrome") String browser, Method method) {
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        DriverManager.quit();
    }
}
