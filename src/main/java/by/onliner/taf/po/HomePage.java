package by.onliner.taf.po;

import by.onliner.taf.singleton.Singleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private static final Logger logger = LogManager.getLogger();
    private WebDriver driver;
    private WebDriverWait wait;
    private By catalogButtonLocator = By.xpath("//span[@class='b-main-navigation__text' and text()='Каталог']");
    private By autobaraholkaButtonLocator = By.xpath("//span[@class='b-main-navigation__text' and text()='Автобарахолка']");
    private By apartmentsButtonLocator = By.xpath("//span[@class='b-main-navigation__text' and text()='Дома и квартиры']");

    public HomePage() {
        this.driver = Singleton.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openHomePage() {
        driver.get("https://www.onliner.by/");
        logger.info("HomePage is opened");
    }

    public void goCatalogPage() {
        WebElement cartButtonElement = wait.until(ExpectedConditions.elementToBeClickable(catalogButtonLocator));
        cartButtonElement.click();
        logger.info("Catalog page is opened");
    }

    public void goAutobaraholkaPage() {
        WebElement cartButtonElement = wait.until(ExpectedConditions.elementToBeClickable(autobaraholkaButtonLocator));
        cartButtonElement.click();
    }

    public void goApartmentsPage() {
        WebElement cartButtonElement = wait.until(ExpectedConditions.elementToBeClickable(apartmentsButtonLocator));
        cartButtonElement.click();
    }
}
