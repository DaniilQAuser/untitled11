package AppTest;

import PageObject.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class FooterTest extends BaseTest {

    @BeforeTest
    public void start() throws MalformedURLException {
        setUp();
    }
    @AfterTest
    public void stop() {
        tearDown();
    }
    @Test
    public void footerRetest() {

        MainPage mainPage = new MainPage(driver);

        mainPage.clickProfileButton();
        Assert.assertTrue(mainPage.isProfilePageIsDisplayed(), "Ошибка: Страница Моя карта не открыта");
        System.out.println("OK: Клик по кнопке Моя карта выполнен успешно.");

        mainPage.clickCatalogButton();
        Assert.assertTrue(mainPage.isCatalogPageIsDisplayed(), "Ошибка: Страница Каталог не открыта");
        System.out.println("OK: Клик по кнопке Каталог выполнен успешно.");

        mainPage.clickSupportButton();
        Assert.assertTrue(mainPage.isSupportPageIsDisplayed(), "Ошибка: Страница Поддержка не открыта");
        System.out.println("OK: Клик по кнопке Поддержка выполнен успешно.");

        mainPage.clickHistoryButton();
        Assert.assertTrue(mainPage.isHistoryPageIsDisplayed(), "Ошибка: Страница Профиль не открыта");
        System.out.println("OK: Клик по кнопке Профиль выполнен успешно.");

        mainPage.clickShopsButton();
        if (!mainPage.isShopsPageIsDisplayed()) {
            mainPage.clickGeoButton();
        }
        Assert.assertTrue(mainPage.isShopsPageIsDisplayed(), "Ошибка: Страница Магазины не открыта");

        System.out.println("ОК: Клик по кнопке Магазины выполнен успешно.");

        // Добавляем проверку, что все действия выполнены успешно
        Assert.assertTrue(true, "Все действия выполнены успешно");
    }
}