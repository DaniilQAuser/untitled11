package PageObject;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//клики по страницам
public class MainPage {

    private AppiumDriver driver;
    private WebDriverWait wait;

    public MainPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //клик по странице каталога
    public void clickCatalogButton() {
        WebElement catalogButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.vkusvill:id/bottom_item_catalog")));
        catalogButton.click();
    }
    //клик по странице Моя карта
    public void clickCartButton() {
        WebElement cartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.vkusvill:id/bottom_item_profile")));
        cartButton.click();
    }
    //клик по странице Магазины
    public void clickShopsButton() {
        WebElement shopsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.vkusvill:id/bottom_item_shops")));
        shopsButton.click();

        WebElement geoButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")));
        geoButton.click();

        WebElement nameShops = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.TextView[@text=\"Магазины\"])[1]")));
        nameShops.isDisplayed();
    }
    //клик по странице Профиль
    public void clickHistoryButton() {
        WebElement historyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.vkusvill:id/bottom_item_history")));
        historyButton.click();
    }
    //клик по странице Поддержка
    public void clickSupportButton() {
        WebElement supportButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.vkusvill:id/bottom_item_support")));
        supportButton.click();
    }
}