
package sele2.com.driver;

import org.openqa.selenium.WebDriver;

public class TargetFactory {

    public WebDriver createInstance() {
        WebDriver webdriver;
        webdriver = BrowserFactory.valueOf("chrome".toUpperCase()).createDriver();
        return webdriver;
    }

    public WebDriver createInstance(String browser) {

        WebDriver webdriver;
        webdriver = BrowserFactory.valueOf(browser.toUpperCase()).createDriver();

        return webdriver;
    }
}