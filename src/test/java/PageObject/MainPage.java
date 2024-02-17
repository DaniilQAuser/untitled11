package PageObject;

import org.openqa.selenium.TimeoutException;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AppTest.BaseTest;
import java.time.Duration;

public class MainPage extends BaseTest {

    public enum MainPageSelectors {
        CATALOG_BUTTON("ru.vkusvill:id/bottom_item_catalog"),
        PROFILE_BUTTON("ru.vkusvill:id/bottom_item_profile"),
        SHOPS_BUTTON("ru.vkusvill:id/bottom_item_shops"),
        GEO_BUTTON("com.android.permissioncontroller:id/permission_allow_foreground_only_button"),
        HISTORY_BUTTON("ru.vkusvill:id/bottom_item_history"),
        SUPPORT_BUTTON("ru.vkusvill:id/bottom_item_support");

        private final String selector;

        MainPageSelectors(String selector) {
            this.selector = selector;
        }

        public String getSelector() {
            return this.selector;
        }
    }

    public MainPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //проверки наличия кнопок

    //Моя карта
    public boolean isProfilePageIsDisplayed() {
            try {
                WebElement profileButton = waitForVisibility(By.id(MainPageSelectors.PROFILE_BUTTON.getSelector()));
                return profileButton.isDisplayed();
            } catch (TimeoutException e) {
                return false;
            }
        }
    //каталог
    public boolean isCatalogPageIsDisplayed() {
        try {
            WebElement catalogButton = waitForVisibility(By.id(MainPageSelectors.CATALOG_BUTTON.getSelector()));
            return catalogButton.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    //Магазины
    public boolean isShopsPageIsDisplayed() {
        try {
            WebElement shopsButton = waitForVisibility(By.id(MainPageSelectors.SHOPS_BUTTON.getSelector()));
            return shopsButton.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    //Профиль(история)
    public boolean isHistoryPageIsDisplayed() {
        try {
            WebElement historyButton = waitForVisibility(By.id(MainPageSelectors.HISTORY_BUTTON.getSelector()));
            return historyButton.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    //Поддержка
    public boolean isSupportPageIsDisplayed() {
        try {
            WebElement supportButton = waitForVisibility(By.id(MainPageSelectors.SUPPORT_BUTTON.getSelector()));
            return supportButton.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    //клик по странице Моя карта
    public void clickProfileButton() {
        clickElement(By.id(MainPageSelectors.PROFILE_BUTTON.getSelector()));
    }
    //клик по странице каталога
    public void clickCatalogButton() {
        clickElement(By.id(MainPageSelectors.CATALOG_BUTTON.getSelector()));
    }
    //клик по странице Магазины
    public void clickShopsButton() {
        clickElement(By.id(MainPageSelectors.SHOPS_BUTTON.getSelector()));
    }
    //клик по странице Поддержка
    public void clickSupportButton() {
        clickElement(By.id(MainPageSelectors.SUPPORT_BUTTON.getSelector()));
    }
    //клик по странице История(Профиль)
    public void clickHistoryButton() {
        clickElement(By.id(MainPageSelectors.HISTORY_BUTTON.getSelector()));
    }
    public void clickGeoButton() {
        clickElement(By.id(MainPageSelectors.GEO_BUTTON.getSelector()));
    }
}