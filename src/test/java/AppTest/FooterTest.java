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

        mainPage.clickProfileButton();
        captureScreenshot("clickProfileButton"); // Скриншот после клика по кнопке Моя карта
        Assert.assertTrue(mainPage.isProfilePageIsDisplayed(), "Ошибка: Страница Моя карта не открыта");
        System.out.println("OK: Клик по кнопке Моя карта выполнен успешно.");

        mainPage.clickCatalogButton();
        captureScreenshot("clickCatalogButton");
        Assert.assertTrue(mainPage.isCatalogPageIsDisplayed(), "Ошибка: Страница Каталог не открыта");
        System.out.println("OK: Клик по кнопке Каталог выполнен успешно.");

        mainPage.clickSupportButton();
        captureScreenshot("clickSupportButton");
        Assert.assertTrue(mainPage.isSupportPageIsDisplayed(), "Ошибка: Страница Поддержка не открыта");
        System.out.println("OK: Клик по кнопке Поддержка выполнен успешно.");

        mainPage.clickHistoryButton();
        captureScreenshot("clickHistoryButton");
        Assert.assertTrue(mainPage.isHistoryPageIsDisplayed(), "Ошибка: Страница Профиль не открыта");
        System.out.println("OK: Клик по кнопке Профиль выполнен успешно.");

        mainPage.clickShopsButton();
        captureScreenshot("clickShopsButton");
        if (!mainPage.isShopsPageIsDisplayed()) {
            mainPage.clickGeoButton();
        }
        Assert.assertTrue(mainPage.isShopsPageIsDisplayed(), "Ошибка: Страница Магазины не открыта");

        System.out.println("ОК: Клик по кнопке Профиль выполнен успешно.");

        // Добавляем проверку, что все действия выполнены успешно
        Assert.assertTrue(true, "Все действия выполнены успешно");

        tearDown(); // вызов метода из BaseTest для завершения работы драйвера
    }
}
// сори за говнокод, потом перепишу, игрался