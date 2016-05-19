package com.servicewhale.tests.selenium;

import com.servicewhale.tests.selenium.util.PropertyLoader;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.stqa.selenium.factory.WebDriverFactory;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Base class for all the JUnit-based test classes
 */
public class JUnitTestBase {
    protected static String baseUrl;
    protected static String email;
    protected static String password;
    protected static Capabilities capabilities;
    protected static Long defaultTimeout;
    public static String browser;
    public static WebDriver driver;

    @ClassRule
    public static ExternalResource webDriverProperties = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            baseUrl = PropertyLoader.loadProperty("site.url");
            baseUrl = PropertyLoader.loadProperty("site.url");
            email = PropertyLoader.loadProperty("email");
            password = PropertyLoader.loadProperty("password");
            defaultTimeout = Long.valueOf(PropertyLoader.loadProperty("defaultTimeout")).longValue();
            capabilities = PropertyLoader.loadCapabilities();
            browser = capabilities.getBrowserName();
        }
    };

    @ClassRule
    public static ExternalResource webDriver = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            if (System.getProperty("os.name").equals("Linux")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            }

            if (System.getProperty("os.name").contains("Windows")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
            }
            if (capabilities.getCapability("os_version")!=null){
                driver = WebDriverFactory.getDriver("https://qatest247:JfqoMyzeJwvzzzeTa9dz@hub.browserstack.com/wd/hub",
                        capabilities);
            } else {
                driver = WebDriverFactory.getDriver(capabilities);
            }

            driver.manage().timeouts().implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    };

    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] makeScreenshot(String screenshotName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/html")
    public static byte[] saveHtml(String fileName) {
        return driver.getPageSource().getBytes();
    }

    protected String getEmail(){
        return UUID.randomUUID().toString().substring(0,10).replaceAll("-","")+"@mail.ru";
    }
}
