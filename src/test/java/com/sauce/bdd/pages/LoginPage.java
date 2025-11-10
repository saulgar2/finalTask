package com.sauce.bdd.pages;

import com.sauce.bdd.hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;

    private final By username = By.xpath("//input[@data-test='username']");
    private final By password = By.xpath("//input[@data-test='password']");
    private final By loginBtn = By.xpath("//input[@data-test='login-button']");
    private final By errorBox = By.xpath("//div[@class='error-message-container error']/h3 | //div[@data-test='error']");

    public LoginPage() {
        this.driver = Hooks.getDriver();
    }

    public void open(String url) {
        driver.get(url);
    }

    public void typeUsername(String text) {
        driver.findElement(username).sendKeys(text);
    }

    public void typePassword(String text) {
        driver.findElement(password).sendKeys(text);
    }

    public void clearUsername() {
        WebElement el = driver.findElement(username);
        el.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        el.sendKeys(Keys.DELETE);
    }

    public void clearPassword() {
        WebElement el = driver.findElement(password);
        el.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        el.sendKeys(Keys.DELETE);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public String getErrorText() {
        return driver.findElement(errorBox).getText();
    }

    public boolean isUsernameEmpty() {
        return driver.findElement(username).getAttribute("value").isEmpty();
    }

    public boolean isPasswordEmpty() {
        return driver.findElement(password).getAttribute("value").isEmpty();
    }
}