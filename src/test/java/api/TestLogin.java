//package api;
//
//import api.pojo.Login;
//import api.pojo.LoginErrors;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import api.spec.Specifications;
//import org.junit.jupiter.api.Test;
//
//import static io.restassured.RestAssured.given;
//
//public class TestLogin {
//
//    private final static String URL = "https://www.onliner.by/";
//
//    @Test
//    public void testInvalidLogin() {
//        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecification400());
//        String key = "invalid_login_or_password";
//        String message = "Неверный логин или пароль";
//        Login login = new Login("аавава", "12345678");
//        LoginErrors loginErrors = given()
//                .body(login)
//                .when()
//                .post("sdapi/user.api/login")
//                .then().log().all()
//                .extract().as(LoginErrors.class);
//        assertEquals(key, loginErrors.getKey());
//        assertEquals(message, loginErrors.getMessage());
//    }
//}
