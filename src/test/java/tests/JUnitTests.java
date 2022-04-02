package tests;

import appmanager.ApplicationManager;
import appmanager.MainPage;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class JUnitTests extends TestBase {
    private static WebDriver webDriver;

    @BeforeAll
    public static void setUpWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    public void test() {
        app.init("");
    }

    @Test
    public void prediction_bar_appears() {
        // webDriver.get(URL);
        // явное ожидание - работает в контексте опред.теста, нужно проврить время загрузки опред.эл-та
        // timeoutException - если через n сек по требованию элементр на странице не загрузился
        // WebDriverWait wait = new WebDriverWait(webDriver, ofSeconds(60)); // явное ожидание (explicit), 60 - максимальное кол-во сек ожидания
        // wait.until(ExpectedConditions.elementToBeClickable(By.className(...)));
    }

    @AfterAll
    public static void finalizeWebDriver() {
        webDriver.quit();
    }
}
