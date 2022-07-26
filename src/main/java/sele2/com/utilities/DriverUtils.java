package sele2.com.utilities;

import static org.openqa.selenium.remote.BrowserType.CHROME;

public class DriverUtils {
    private static final ThreadLocal<String> driverType = new ThreadLocal<>();


    private static String getDriverType() {
        if (driverType != null && driverType.get() == null) {
            driverType.set(CHROME);
        }
        return driverType.get();
    }

}
