package by.onliner.taf.po;

import by.onliner.taf.singleton.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutobaraholkaPage {
    private WebDriver driver;
    private By mainTitleLocator = By.xpath("//div[@class = 'vehicle-form']/h1");
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public AutobaraholkaPage() {
        this.driver = Singleton.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) this.driver;
    }

    public String getHeaderText() {
        return (String) js.executeScript("return document.querySelector(\"#container > div > div > div > div > div > div.vehicle-wrapper > div > div > h1\").innerText");
        //js executer
    }


}
