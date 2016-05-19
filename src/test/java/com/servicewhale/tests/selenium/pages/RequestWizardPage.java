package com.servicewhale.tests.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RequestWizardPage extends Page{
    public RequestWizardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1")
    public WebElement pageHeader;

    @FindBy(css = "#input-service-category")
    WebElement serviceCategory;

    @FindBy(css = "#input-service")
    public WebElement specificService;

    @FindBy(css = "#input-location")
    public WebElement zip;

    @FindBy(name = "projectStartDate")
    public WebElement startDate;

    @FindBy(css = "#request-other-text-area")
    public WebElement otherTextArea;

    @FindBy(css = "#button-continue")
    public WebElement continueButton;

    @FindBy(css = "[form-error-for='otherText'] label")
    public WebElement otherRequiredMessage;

    public Select getServiceCategory(){
        return new Select(serviceCategory);
    }

    public Select getSpecificService(){
        return new Select(specificService);
    }

    public Select getStartDate(){
        return new Select(startDate);
    }
}
