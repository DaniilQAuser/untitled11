package AppTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class ClickableFooterTestVerOne {

    private AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidSDK");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("app","C:/Games/vkusvill.apk");

        URL appiumServerURL = new URL("http://192.168.0.105:4723/wd/hub");

        driver = new AndroidDriver(appiumServerURL, capabilities);

    }

    @Test
    @Description("Sample Appium Test")
    public void testSample() {
        {
            WebElement screenTitle = driver.findElement(By.id("ru.vkusvill:id/coordinatorLayout"));
            screenTitle.isDisplayed();
        }
        byte[] screenshot = driver.getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
    }

    @Test
    public void checkCatalogButtonTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement catalogButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.vkusvill:id/bottom_item_catalog")));

        catalogButton.isDisplayed();
        catalogButton.click();
        catalogButton.isSelected();
    }
    @Test
    public void checkCartButtonTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.vkusvill:id/bottom_item_profile")));

        cartButton.isDisplayed();
        cartButton.click();
        cartButton.isSelected();
    }

    @Test
    public void checkShopsButtonTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement shopsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.vkusvill:id/bottom_item_shops")));

        shopsButton.isDisplayed();
        shopsButton.click();

        WebElement geoButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")));
        geoButton.isDisplayed();
        geoButton.click();

        WebElement nameShops = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.TextView[@text=\"Магазины\"])[1]")));
        nameShops.isDisplayed();

    }

    @Test
    public void checkHistoryButtonTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement historyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.vkusvill:id/bottom_item_history")));

        historyButton.isDisplayed();
        historyButton.click();
        historyButton.isSelected();
    }

    @Test
    public void checkSupportButtonTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement supportButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.vkusvill:id/bottom_item_support")));

        supportButton.isDisplayed();
        supportButton.click();
        supportButton.isSelected();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}