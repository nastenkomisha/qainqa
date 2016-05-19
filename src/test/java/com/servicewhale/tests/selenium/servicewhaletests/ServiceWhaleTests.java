package com.servicewhale.tests.selenium.servicewhaletests;

import com.servicewhale.tests.selenium.JUnitTestBase;
import com.servicewhale.tests.selenium.managers.FastTrackRegistrationManager;
import com.servicewhale.tests.selenium.managers.HomePageManager;
import com.servicewhale.tests.selenium.managers.RequestWizardManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.stqa.selenium.factory.WebDriverFactory;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * ServiceWhale test suite.
 */
@Title("ServiceWhale test suite")
public class ServiceWhaleTests extends JUnitTestBase {
    public HomePageManager homePageManager = new HomePageManager(softly);
    public RequestWizardManager requestWizardManager = new RequestWizardManager(softly);
    public FastTrackRegistrationManager fastTrackRegistrationManager = new FastTrackRegistrationManager(softly);

    @BeforeClass
    public static void beforeClass() {
        driver.get(baseUrl);
    }

    @AfterClass
    public static void afterClass() {
        WebDriverFactory.dismissAll();
    }

    @Test
    @Title("ServiceWhale test")
    public void serviceWhaleTest() {
        homePageManager.clickSeePrices();
        requestWizardManager.createAnyOtherRequest("PAINTING", "Any Other Painting Job", "19606", "Within a week");
        fastTrackRegistrationManager.registerUser(getEmail(), "9999999999");
    }

}
