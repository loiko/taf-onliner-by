package by.onliner.taf.po;

import by.onliner.taf.singleton.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatalogPage {
    private WebDriver driver;
    private By mainTitleLocator = By.xpath("//div[@class = 'catalog-navigation__title']");
    private WebDriverWait wait;

    public CatalogPage() {
        this.driver = Singleton.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getHeaderText() {
        WebElement headerTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mainTitleLocator));
        return headerTextElement.getText();
    }
}
