package com.sauce.bdd.support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions eopts = new EdgeOptions();
                return new EdgeDriver(eopts);
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions copts = new ChromeOptions();
                return new ChromeDriver(copts);
        }
    }
}