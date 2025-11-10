package com.sauce.bdd.hooks;

import com.sauce.bdd.support.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {
    private static final Logger log = LoggerFactory.getLogger(Hooks.class);
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        log.info("Starting driver for browser: {}", browser);
        driver.set(DriverFactory.createDriver(browser));
        driver.get().manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver.get() != null) {
            log.info("Quitting driver");
            driver.get().quit();
            driver.remove();
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}