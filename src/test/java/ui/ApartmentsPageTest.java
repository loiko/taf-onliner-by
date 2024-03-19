package ui;

import by.onliner.taf.po.ApartmentsPage;
import by.onliner.taf.po.HomePage;
import by.onliner.taf.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ApartmentsPageTest extends BaseTest {

    @Test
    public void testSearchRentalsByFilter() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.goApartmentsPage();
        ApartmentsPage apartmentsPage = new ApartmentsPage()
                .clickRentButton()
                .clickOneRoomButton()
                .clickOwnerButton()
                .enterMinPrice("200")
                .enterMaxPrice("220");


        Thread.sleep(10000);

        List<String> actualNumberOfRooms = apartmentsPage.getNumberOfRooms();
        List<String> actualApartmentPrices = apartmentsPage.getApartmentPrice();
        boolean actualAgencySymbolInvisible = apartmentsPage.isApartmentsBelongToOwner();

        String expectedNumberOfRooms = "1к";
        int expectedMinApartmentPrice = 200;
        int expectedMaxApartmentPrice = 220;
        boolean expectedAgencySymbolInvisible = true;

        for (String room : actualNumberOfRooms) {
            Assertions.assertEquals(expectedNumberOfRooms, room);
        }

        for (String actualApartmentPrice : actualApartmentPrices) {
            int price = Integer.parseInt(actualApartmentPrice);
            Assertions.assertTrue(Utils.isInRange(price, expectedMinApartmentPrice, expectedMaxApartmentPrice));
        }

        Assertions.assertEquals(expectedAgencySymbolInvisible, actualAgencySymbolInvisible);
    }
}
