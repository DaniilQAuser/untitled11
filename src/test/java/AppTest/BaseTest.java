package AppTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class BaseTest {
    protected AppiumDriver driver;
    protected WebDriverWait wait;


    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidSDK");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "C:/BuildAndroid/ru.vkusvill-3.9.1-lollipop-release (1).apk");

        URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(appiumServerURL, capabilities);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    // Метод для ожидания видимости элемента
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    // Метод проверки видимости элемента
    public boolean isElementVisible(By locator) {
        try {
            waitForVisibility(locator);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    // Метод для сохранения скриншота
    public void captureScreenshot(String actionName) {
        try {
            // Генерация случайного имени файла скриншота
            String randomFileName = UUID.randomUUID().toString();
            String screenshotFileName = randomFileName + "_" + actionName + ".png";

            // Получение скриншота
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Копирование скриншота в файл
            FileUtils.copyFile(screenshot, new File("E/screenReport/" + screenshotFileName));
            System.out.println("Скриншот сохранен: " + screenshotFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickElement(By locator) {
        try {
            WebElement element = waitForVisibility(locator);
            element.click();
        } catch (TimeoutException e) {
            System.out.println("Ошибка: Элемент не найден или не доступен для клика.");
            captureScreenshot("clickElement_failed");
        }
    }
}