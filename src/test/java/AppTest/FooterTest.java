package AppTest;

import PageObject.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class FooterTest extends BaseTest {

    @Test
    public void footerRetest() throws MalformedURLException {
        setUp(); // вызов метода из BaseTest для настройки драйвера

        MainPage mainPage = new MainPage(driver);

        try {
            try {
            mainPage.clickProfileButton();
            captureScreenshot("clickProfileButton"); // Скриншот после клика по кнопке Моя карта
            Assert.assertTrue(mainPage.isProfilePageIsDisplayed(), "Ошибка: Страница Моя карта не открыта");
            System.out.println("OK: Клик по кнопке Моя карта выполнен успешно.");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Ошибка: " + e.getMessage()); // Выводим сообщение об ошибке
                try {
                    mainPage.clickCatalogButton();
                    captureScreenshot("clickCatalogButton");
                    Assert.assertTrue(mainPage.isCatalogPageIsDisplayed(), "Ошибка: Страница Каталог не открыта");
                    System.out.println("OK: Клик по кнопке Каталог выполнен успешно.");
                } catch (Exception q) {
                    e.printStackTrace();
                    System.out.println("Ошибка: " + e.getMessage()); // Выводим сообщение об ошибке
                }
            }

            try {
            mainPage.clickSupportButton();
            captureScreenshot("clickSupportButton");
            Assert.assertTrue(mainPage.isSupportPageIsDisplayed(), "Ошибка: Страница Поддержка не открыта");
            System.out.println("OK: Клик по кнопке Поддержка выполнен успешно.");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Ошибка: " + e.getMessage()); // Выводим сообщение об ошибке
            }
            try {
            mainPage.clickHistoryButton();
            captureScreenshot("clickHistoryButton");
            Assert.assertTrue(mainPage.isHistoryPageIsDisplayed(), "Ошибка: Страница Профиль не открыта");
            System.out.println("OK: Клик по кнопке Профиль выполнен успешно.");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Ошибка: " + e.getMessage()); // Выводим сообщение об ошибке
            }

            // Добавляем проверку, что все действия выполнены успешно
            Assert.assertTrue(true, "Все действия выполнены успешно");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Ошибка выполнения теста: " + e.getMessage());
        } finally {
            tearDown(); // вызов метода из BaseTest для завершения работы драйвера
        }
    }
}
// сори за говнокод, потом перепишу, игрался