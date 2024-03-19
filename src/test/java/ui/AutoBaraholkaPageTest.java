package ui;

import by.onliner.taf.po.AutobaraholkaPage;
import by.onliner.taf.po.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AutoBaraholkaPageTest extends BaseTest {
    @Test
    public void testCatalogPageOpened() {
        HomePage homePage = new HomePage();
        homePage.goAutobaraholkaPage();
        AutobaraholkaPage autobaraholkaPage = new AutobaraholkaPage();
        String actualHeader = autobaraholkaPage.getHeaderText();
        String expectedHeader = "Автобарахолка";
        Assertions.assertEquals(expectedHeader, actualHeader);
    }
}

