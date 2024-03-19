package api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class BaseURLTest {
    @DisplayName("check base URL")
    @Test
    public void testBaseURL(){
        when().get("https://www.onliner.by/").then().statusCode(200);
    }
}
