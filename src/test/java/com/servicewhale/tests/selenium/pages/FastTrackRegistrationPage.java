package com.servicewhale.tests.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FastTrackRegistrationPage extends Page{

    public FastTrackRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".btn-send")
    public WebElement sendButton;

    @FindBy(how = How.CSS, using = "#input-email")
    public WebElement email;

    @FindBy(how = How.NAME, using = "phoneNumber")
    public WebElement phone;

    @FindBy(how = How.CSS, using = ".btn-fast-reg-see-prices")
    public WebElement seePricesButton;
}
