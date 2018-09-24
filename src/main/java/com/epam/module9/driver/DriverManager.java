package com.epam.module9.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static DriverManager driverInstance;
    private static WebDriver driver;

    private DriverManager(){}

    /**
     * Returns an DriverManager instance, if and only if the DriverManager instance is not {@code null}.
     * @return      DriverManager instance
     */
    public static DriverManager getDriverInstance(){
        if (driverInstance == null){
            driverInstance = new DriverManager();
        } return driverInstance;
    }

    /**
     * Returns an WebDriver object, if and only if the WebDriver object is not {@code null}.
     * If WebDriver object is not {@code null}, setDriver method is called and
     * an DriverType object is passed to it. DriverType determines the type of the driver to be returned.
     *
     * @param  driverType  type of driver that is required for use
     * @return             WebDriver object
     */
    public static WebDriver getDriver(DriverType driverType){
        if (driver == null){
            setDriver(driverType);
        } return driver;
    }

    /**
     * Initializes a specific type of driver, depending on the argument passed.
     *
     * @param driverType type of driver to be initialized
     */
    private static void setDriver(DriverType driverType){
        switch (driverType){
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\SeleniumDrivers\\chromedriver.exe");
                driver = new ChromeDriver();

            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\SeleniumDrivers\\geckodriver.exe");
                driver = new FirefoxDriver();
        }

    }

}
