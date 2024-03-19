package ui;

import by.onliner.taf.po.HomePage;
import by.onliner.taf.singleton.Singleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    public void driversSetUp() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
    }

    @AfterEach
    public void driverShutDown() {
        Singleton.quiteDriver();
    }
}

