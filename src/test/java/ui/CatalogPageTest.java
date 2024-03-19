package ui;

import by.onliner.taf.po.CatalogPage;
import by.onliner.taf.po.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ui.BaseTest;

public class CatalogPageTest extends BaseTest {
    @Test
    public void testCatalogPageOpened() {
        HomePage homePage = new HomePage();
        homePage.goCatalogPage();
        CatalogPage catalogPage = new CatalogPage();
        String actualHeader = catalogPage.getHeaderText();
        String expectedHeader = "КаталогВсе суперцены!";
        Assertions.assertEquals(expectedHeader, actualHeader);
    }
}
