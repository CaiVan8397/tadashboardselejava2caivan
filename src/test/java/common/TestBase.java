package common;

import org.testng.annotations.*;
import sele2.com.driver.DriverManager;
import sele2.com.enums.BrowserType;
import sele2.com.listeners.TestListener;

@Listeners({TestListener.class})
public class TestBase {
    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void initialize(@Optional("chrome") String browser) {
        DriverManager.createDriver(BrowserType.from(browser));

    }

    @AfterClass(alwaysRun = true)
    public void collapse() {
        DriverManager.closeDriver();
    }
}
