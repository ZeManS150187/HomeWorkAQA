package Lesson17;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PostmanEchoPostTest {

    @Test
    public void testResponseWithRequestBody() {
        Response response = RestAssured
                .given()
                .baseUri("https://postman-echo.com")
                .header("Content-Type", "text/plain") // Указываем тип содержимого
                .body("This is expected to be sent back as part of response body.") // Передаем тело запроса
                .post("/post");

        // Проверка, что статус ответа 200
        response.then()
                .statusCode(200);

        // Проверка, что тело ответа содержит отправленные данные
        response.then()
                .body("data", equalTo("This is expected to be sent back as part of response body."));

        // Дополнительно: проверяем наличие других полей
        response.then()
                .body("args", notNullValue()) // Поле args должно быть не null
                .body("headers", notNullValue()) // Поле headers должно быть не null
                .body("url", equalTo("https://postman-echo.com/post"));
    }
}

