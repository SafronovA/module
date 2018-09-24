package com.epam.module9.tests;

import com.epam.module9.driver.DriverManager;
import com.epam.module9.driver.DriverType;
import com.epam.module9.pages.HomePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;

    private final String TESTED_RESOURCE = "https://github.com";

    @BeforeClass(alwaysRun = true)
    protected void setUp() {
        startBrowser();
        driver.get(TESTED_RESOURCE);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @AfterClass(enabled = false)
    protected void backOnMainPage() {
        driver.navigate().to(TESTED_RESOURCE);
    }

    @AfterTest(enabled = false)
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void startBrowser() {
        DriverManager.getDriverInstance();
        driver = DriverManager.getDriver(DriverType.CHROME);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1650, 700));
    }

}