package by.onliner.taf.po;

import by.onliner.taf.singleton.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class ApartmentsPage {
    private WebDriver driver;
    WebDriverWait wait;
    private By rentButtonLocator = By.xpath("//span[text()='Аренда']");
    private By oneRoomButtonLocator = By.xpath("//span[@class='filter__item-inner' and text()='1']");
    private By ownerButtonLocator = By.xpath("//span[@class='filter__item-inner' and text()='Только собственник']");
    private By filterButtonLocator = By.xpath("//div[@class = 'dropdown dropdown_right']");
    private By priceMinInputLocator = By.xpath("//input[@id = 'search-filter-price-from']");
    private By priceMaxInputLocator = By.xpath("//input[@id = 'search-filter-price-to']");
    private By searchFieldLocatot = By.xpath("//input[@class = 'fast-search__input']");
    private By numberOfRoomsLocator = By.xpath("//span[@class = 'classified__caption']/span[1]");
    private By apartmentPriceLocator = By.xpath("//span[contains(@data-bind, 'USD')]");
    private By ownerLabelLocator = By.xpath("//span[@class = 'classified__type']");

    public ApartmentsPage() {
        this.driver = Singleton.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public ApartmentsPage clickRentButton() {
        WebElement rentButton = wait.until(ExpectedConditions.elementToBeClickable(rentButtonLocator));
        rentButton.click();
        return this;
    }

    public ApartmentsPage clickOneRoomButton() {
        WebElement rentButton = wait.until(ExpectedConditions.elementToBeClickable(oneRoomButtonLocator));
        rentButton.click();
        return this;
    }

    public ApartmentsPage clickOwnerButton() {
        WebElement rentButton = wait.until(ExpectedConditions.elementToBeClickable(ownerButtonLocator));
        rentButton.click();
        return this;
    }


    public ApartmentsPage enterMinPrice(String priceMin) {
        WebElement rentButton = wait.until(ExpectedConditions.visibilityOfElementLocated(priceMinInputLocator));
        rentButton.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        rentButton.sendKeys(priceMin, Keys.ENTER);
        return this;
    }

    public ApartmentsPage enterVoidForm() {
        WebElement rentButton = wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocatot));
        rentButton.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        return this;
    }

    public ApartmentsPage clickFilterButton() {
        WebElement rentButton = wait.until(ExpectedConditions.elementToBeClickable(filterButtonLocator));
        rentButton.click();
        return this;
    }
    public ApartmentsPage enterMaxPrice(String priceMax) {
        WebElement rentButton = wait.until(ExpectedConditions.visibilityOfElementLocated(priceMaxInputLocator));
        rentButton.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        rentButton.sendKeys(priceMax, Keys.ENTER);
        return this;
    }

    public List<String> getNumberOfRooms() {
        List<String> numberOfRooms = new ArrayList<>();
        List<WebElement> numberOfRoomsElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(numberOfRoomsLocator));

        for (WebElement numberOfRoom : numberOfRoomsElements) {
            numberOfRooms.add(numberOfRoom.getText());
        }
        return numberOfRooms;
    }

    public List<String> getApartmentPrice() {
        List<String> apartmentPrices = new ArrayList<>();
        List<WebElement> apartmentPriceElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(apartmentPriceLocator));

        for (WebElement apartmentPrice : apartmentPriceElements) {
            apartmentPrices.add(apartmentPrice.getText());
        }
        return apartmentPrices;
    }

    public boolean isApartmentsBelongToOwner() {
        List<WebElement> labels = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ownerLabelLocator));
        for (WebElement label : labels) {
            String styleAttribute = label.getAttribute("style");
            if (styleAttribute == null || !styleAttribute.contains("display: none;")) {
                return false;
            }
        }
        return true;
    }
}

