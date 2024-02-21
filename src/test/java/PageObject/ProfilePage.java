package PageObject;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//объекты страницы моя карта

public class ProfilePage {

    private AppiumDriver driver;
    private WebDriverWait wait;

    public ProfilePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //клик по кнопке войти
    public void clickLoginButton() {
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.vkusvill:id/btn_login_by_phone")));
        loginButton.click();
    }
    //ввод номера телефона
    public void enterPhone(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.vkusvill:id/et_phone")));
        usernameField.sendKeys(username);
    }
    //клик по кнопке продолжить
    public void clickNextButton() {
        WebElement nextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.vkusvill:id/btn_enter_phone")));
        nextButton.click();
    }
    public void enterCode(String code) {
        WebElement codeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.vkusvill:id/et_sms_code")));
        codeField.sendKeys(code);
    }
    public void clickConfirmButton() {
        WebElement confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.vkusvill:id/btn_enter_sms_code")));
        confirmButton.click();
    }
}