package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    WebDriver wd;
    private String browser;
    private MainPage mainPage;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public MainPage mainPage() {
        if (mainPage == null) {
            mainPage = new MainPage(this);
        }
        return mainPage;
    }

    public void init(String urlPage) {
        getDriver();
        wd.get("https://skillfactory.ru/" + urlPage);
    }

    public void stop() {
        if (wd != null) {
            wd.quit();
        }
    }

    public String getProperty(String key) { // параметр - имя извлекаемого св-ва
        return properties.getProperty(key);
    }

    public WebDriver getDriver() {
        // драйвер не инициализирован
        if (wd == null) {
            if (browser.equals(BrowserType.FIREFOX)) {
                wd = new FirefoxDriver();
            } else if (browser.equals(BrowserType.CHROME)) {
                wd = new ChromeDriver();
            } else if (browser.equals(BrowserType.IE)) {
                wd = new InternetExplorerDriver();
            }
            wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            wd.get("https://skillfactory.ru/");
        }
        return wd;
    }



    public void click(By locator) {
        wd.findElement(locator).click();
    }
}
