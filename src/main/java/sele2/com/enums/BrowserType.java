package sele2.com.enums;

public enum BrowserType {
    CHROME, FIREFOX;

    public static BrowserType from(String browser) {
        switch (browser.toUpperCase()) {
            case "CHROME":
                return CHROME;
            case "FIREFOX":
                return FIREFOX;
            default:
                throw new RuntimeException("This driver is not supported");
        }
    }
}
