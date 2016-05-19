package com.servicewhale.tests.selenium.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends Page{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1")
    public WebElement pageHeader;

    @FindBy(how = How.CSS, using = "#button-browse-quotes")
    public WebElement seePricesButton;
}
