package AppTest;

import PageObject.CartPage;
import PageObject.MainPage;
import Simple.TestData;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.util.UUID;

public class LoginTest extends BaseTest {

    @Test
    public void authCart() throws MalformedURLException {
        setUp(); // вызов метода из BaseTest для настройки драйвера

        CartPage cartPage = new CartPage(driver);
        MainPage mainPage = new MainPage(driver);

        try {
            mainPage.clickCartButton();
            captureScreenshot("clickCartButton"); // Скриншот после клика по кнопке корзины
            System.out.println("OK: Клик по кнопке корзины выполнен успешно.");

            cartPage.clickLoginButton();
            captureScreenshot("clickLoginButton"); // Скриншот после клика по кнопке входа
            System.out.println("OK: Клик по кнопке входа выполнен успешно.");

            cartPage.enterPhone(TestData.getPhoneNumber("truePhoneNumber"));
            captureScreenshot("enterPhoneNumber"); // Скриншот после ввода номера телефона
            System.out.println("OK: Ввод номера телефона выполнен успешно.");

            cartPage.clickNextButton();
            captureScreenshot("clickNextButton"); // Скриншот после клика по кнопке "Далее"
            System.out.println("OK: Клик по кнопке 'Далее' выполнен успешно.");

            cartPage.enterCode(TestData.getSmsCode("falseSmsCode"));
            captureScreenshot("enterSmsCode"); // Скриншот после ввода кода подтверждения
            System.out.println("OK: Ввод кода подтверждения выполнен успешно.");

            // Сей cartPage.clickConfirmButton();
            System.out.println("OK: Вход в аккаунт выполнен успешно.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tearDown(); // вызов метода из BaseTest для завершения работы драйвера
        }
    }

    // Метод для сохранения скриншота
    private void captureScreenshot(String actionName) {
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
}
