package Simple;

import PageObject.CartPage;
import PageObject.MainPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class AppCoffe {
    private AppiumDriver driver;
    private CartPage cartPage;
    private MainPage mainPage;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidSDK");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "C:/Games/vkusvill.apk");

        URL appiumServerURL = new URL("http://192.168.0.105:4723/wd/hub");

        driver = new AndroidDriver(appiumServerURL, capabilities);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
    }
    @Test
    public void authCart() {
        mainPage.clickCartButton();
        cartPage.clickLoginButton();
        cartPage.enterPhone("9128887921");
        cartPage.clickNextButton();
        cartPage.enterCode("111111");
        //Сей cartPage.clickConfirmButton();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
