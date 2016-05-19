package com.servicewhale.tests.selenium.managers;

import com.servicewhale.tests.selenium.JUnitTestBase;
import com.servicewhale.tests.selenium.pages.HomePage;
import org.assertj.core.api.JUnitSoftAssertions;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePageManager extends JUnitTestBase {
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    private JUnitSoftAssertions softly;

    public HomePageManager(JUnitSoftAssertions softly){
        this.softly=softly;
    }

    @Step("Click 'See Prices Now' button")
    public void clickSeePrices() {
        softly.assertThat(homePage.pageHeader.getText()).as("Wrong page header text").isEqualTo("Home improvement shopping made easy.");
        makeScreenshot("Page header text should be \"Home improvement shopping made easy.\"");
        homePage.seePricesButton.click();
    }

}
