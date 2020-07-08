
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



class PostmanEchoTest {
    @Test
    public void postQuery() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("balance")  // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
        .when()
                .post("/post")
// Проверки
        .then()
                .statusCode(200)
                .body("data", equalTo("name"));


    }
    @Test
    public void postQuery2 () {
        given()
                .baseUri("https://postman-echo.com")
                .body("currency:USD")
        .when()
                .post("/post")
        .then()
                .statusCode(200)
                .body("data", equalTo("currency:RUB"));
    }

}