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

public class aTest {

    private AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidSDK");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage", "com.example.login");
        capabilities.setCapability("appActivity", ".ui.login.LoginActivity");
        capabilities.setCapability("app","C:/Games/login.apk");

        URL appiumServerURL = new URL("http://192.168.0.105:4723/wd/hub");

        driver = new AndroidDriver(appiumServerURL, capabilities);
    }

    @Test
    @Description("Sample Appium Test")
    public void testSample() {
        {
            WebElement screenTitle = driver.findElement(By.id("com.example.login:id/toolbar"));
            screenTitle.isDisplayed();
        }
        byte[] screenshot = driver.getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
    }
    @Test
    public void validRegistrationTest()
    {
        WebElement emailInput = driver.findElement(By.id("com.example.login:id/username"));

        emailInput.isDisplayed();
        emailInput.click();
        emailInput.sendKeys("admin@admin.ru");

        WebElement passInput = driver.findElement(By.id("com.example.login:id/password"));

        passInput.isDisplayed();
        passInput.click();
        passInput.sendKeys("1234");

        WebElement signInButton = driver.findElement(By.id("com.example.login:id/login"));

        signInButton.isDisplayed();
        signInButton.click();

        WebElement successAuthText = driver.findElement(By.xpath("//*[contains(@text, 'Welcome ! user')]"));
        successAuthText.isDisplayed();
    }
    @Test
    public void invalidRegistrationTest()
    {
        WebElement emailInput = driver.findElement(By.id("com.example.login:id/username"));

        emailInput.isDisplayed();
        emailInput.click();
        emailInput.sendKeys("user@user.ru");

        WebElement passInput = driver.findElement(By.id("com.example.login:id/password"));

        passInput.isDisplayed();
        passInput.click();
        passInput.sendKeys("1111");

        WebElement signInButton = driver.findElement(By.id("com.example.login:id/login"));

        signInButton.isDisplayed();
        signInButton.click();

        WebElement successAuthText = driver.findElement(By.xpath("//*[contains(@text, 'Login failed')]"));
        successAuthText.isDisplayed();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}