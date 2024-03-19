package api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class LoginTest {
    private static final Logger logger = LogManager.getLogger();
    private static final String BASE_URL = "https://ab.onliner.by/sdapi/user.api/login";

    @Test
    public void testEmptyLoginAndPassword() {
        String body = "{\"login\": \"\", \n" +
                "\"password\": \"\"\n" +
                "}";

        logger.info("request body: " + body);

        given().header("Content-Type", "application/json")
                .body(body)
                .when().post(BASE_URL)
                .then().assertThat()
                .statusCode(422)
                .body("message", equalTo("Validation failed"))
                .body("errors.login[0]", equalTo("Укажите ник или e-mail"))
                .body("errors.password[0]", equalTo("Укажите пароль"));
    }

    @Test
    public void testInvalidLogin() {
        String body = "{\n" +
                "    \"login\": \"!№*235\", \n" +
                "    \"password\": \"12345678\"\n" +
                "}";

        logger.info("request body: " + body);

        given().header("Content-Type", "application/json")
                .body(body)
                .when().post(BASE_URL)
                .then().assertThat()
                .statusCode(400)
                .body("errors.key[0]", equalTo("invalid_login_or_password"))
                .body("errors.message[0]", equalTo("Неверный логин или пароль"));
    }

    @Test
    public void testValidLoginAndPassword() {
        String body = "{\n" +
                "    \"login\": \"nickl\", \n" +
                "    \"password\": \"123456\"\n" +
                "}";

        logger.info("request body: " + body);

        given().header("Content-Type", "application/json")
                .body(body)
                .when().post(BASE_URL)
                .then().assertThat()
                .statusCode(428)
                .body("title", equalTo("Доступ запрещен"))
                .body("detail", equalTo("Пройдите проверку captcha"))
                .body("meta.type", equalTo("recaptcha"));
    }
}
