package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class HelperBase {
    protected WebDriver wd;
    protected ApplicationManager app;

    public HelperBase(ApplicationManager app) {
        this.app = app;
        // ленивая инициализация
        this.wd = app.getDriver();
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void clickWithDelay(By locator) {
        WebDriverWait wait = new WebDriverWait(wd, 15);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        // делает клик по полю
        click(locator);
        String existingText = wd.findElement(locator).getAttribute("value");
        // проверка совпадения текста с существующим
        if (!text.equals(existingText)) {
            // отчистка поля ввода
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    // прикрепление файла без клика
    protected void attach(By locator, File file) {
        if (file != null) {
            wd.findElement(locator).sendKeys(file.getAbsolutePath());
        }
    }

}
