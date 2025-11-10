package com.sauce.bdd.pages;

import com.sauce.bdd.hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private final WebDriver driver;
    private final By title = By.xpath("//div[@id='header_container']//div[contains(@class,'app_logo')] | //div[@class='app_header']/div[@class='header_label']/div");

    public InventoryPage() {
        this.driver = Hooks.getDriver();
    }

    public String getAppTitle() {
        return driver.findElement(title).getText();
    }
}