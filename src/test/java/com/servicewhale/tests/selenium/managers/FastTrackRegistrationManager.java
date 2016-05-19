package com.servicewhale.tests.selenium.managers;


import com.servicewhale.tests.selenium.JUnitTestBase;
import com.servicewhale.tests.selenium.pages.FastTrackRegistrationPage;
import org.assertj.core.api.JUnitSoftAssertions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class FastTrackRegistrationManager extends JUnitTestBase {
    FastTrackRegistrationPage fastTrackRegistrationPage = PageFactory.initElements(driver, FastTrackRegistrationPage.class);
    private JUnitSoftAssertions softly;

    public FastTrackRegistrationManager(JUnitSoftAssertions softly){
        this.softly=softly;
    }

    @Step("Register user with email: {0}, phone: {1}")
    public void registerUser(String email, String phone) {
        fastTrackRegistrationPage.email.click();
        makeScreenshot("Fast registration form is open");
        fastTrackRegistrationPage.email.sendKeys(email);
        fastTrackRegistrationPage.sendButton.click();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(fastTrackRegistrationPage.phone));
        fastTrackRegistrationPage.phone.click();
        makeScreenshot("Enter your phone number phone is open");
        fastTrackRegistrationPage.phone.sendKeys(phone);
        fastTrackRegistrationPage.seePricesButton.click();
    }

}
