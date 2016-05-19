package com.servicewhale.tests.selenium.managers;


import com.servicewhale.tests.selenium.JUnitTestBase;
import com.servicewhale.tests.selenium.pages.RequestWizardPage;
import org.assertj.core.api.JUnitSoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class RequestWizardManager extends JUnitTestBase{
    RequestWizardPage requestWizardPage = PageFactory.initElements(driver, RequestWizardPage.class);
    private JUnitSoftAssertions softly;

    public RequestWizardManager(JUnitSoftAssertions softly){
        this.softly=softly;
    }

    @Step("Create 'Any Other' request with service category: {0} , location: {2} , project start date: {3}")
    public void createAnyOtherRequest(String serviceCategory, String specificService, String location, String projectStartDate) {
        softly.assertThat(requestWizardPage.pageHeader.isDisplayed())
                .as("Page header is not displayed").isTrue();
        makeScreenshot("Page header should be displayed");
        requestWizardPage.getServiceCategory().selectByValue(serviceCategory);
        requestWizardPage.getSpecificService().selectByVisibleText(specificService);
        requestWizardPage.zip.sendKeys(location);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".dropdown-menu"))));
        softly.assertThat(driver.findElement(By.cssSelector(".dropdown-menu")).isDisplayed()).isTrue();
        makeScreenshot("Location suggestion should be displayed");
        requestWizardPage.pageHeader.click();
        requestWizardPage.getStartDate().selectByVisibleText(projectStartDate);
        requestWizardPage.continueButton.click();
        softly.assertThat(requestWizardPage.otherRequiredMessage.isDisplayed())
                .as("Message 'Please describe work you need to be done' is not displayed").isTrue();
        makeScreenshot("'Please describe work you need to be done' should be displayed");
        requestWizardPage.otherTextArea.click();
        requestWizardPage.otherTextArea.sendKeys("QA in QA sample");
        requestWizardPage.continueButton.click();
    }

}
