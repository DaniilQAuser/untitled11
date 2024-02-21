/*package PageObject;

import org.openqa.selenium.TimeoutException;
import AppTest.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BaseTest {
    public static final By LOGIN_BY_PHONE_BUTTON = By.id("ru.vkusvill:id/btn_login_by_phone");
    public static final By PROFILE_BUTTON = By.id("ru.vkusvill:id/bottom_item_profile");
    public static final By SHOPS_BUTTON = By.id("ru.vkusvill:id/bottom_item_shops");
    public static final By GEO_BUTTON = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    public static final By HISTORY_BUTTON = By.id("ru.vkusvill:id/bottom_item_history");
    public static final By SUPPORT_BUTTON = By.id("ru.vkusvill:id/bottom_item_support");

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //проверки наличия кнопок

    //Моя карта
    public boolean isLoginBtnIsDisplayed() {
        return isElementVisible(LOGIN_BY_PHONE_BUTTON);
    }
    //каталог
    //public boolean isCatalogPageIsDisplayed() {
        return isElementVisible(CATALOG_BUTTON);
    }
    //Магазины
    public boolean isShopsPageIsDisplayed() {
        return isElementVisible(SHOPS_BUTTON);
    }
    //Профиль(история)
    public boolean isHistoryPageIsDisplayed() {
        return isElementVisible(HISTORY_BUTTON);
    }
    //Поддержка
    public boolean isSupportPageIsDisplayed() {
        return isElementVisible(SUPPORT_BUTTON);
    }
    //клик по странице Моя карта
    public void clickProfileButton() {
        clickElement(PROFILE_BUTTON);
    }
    //клик по странице каталога
    public void clickCatalogButton() {
        clickElement(CATALOG_BUTTON);
    }
    //клик по странице Магазины
    public void clickShopsButton() {
        clickElement(SHOPS_BUTTON);
    }
    //клик по странице Поддержка
    public void clickSupportButton() {
        clickElement(SUPPORT_BUTTON);
    }
    //клик по странице История(Профиль)
    public void clickHistoryButton() {
        clickElement(HISTORY_BUTTON);
    }
    public void clickGeoButton() {
        clickElement(GEO_BUTTON);
    }
}*/