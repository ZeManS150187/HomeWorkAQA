package Lesson17;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoDeleteTest {

    @Test
    public void testPostmanEchoDeleteResponse() {
        // Установка базового URL для Postman Echo API
        RestAssured.baseURI = "https://postman-echo.com";

        // Выполнение DELETE-запроса с ожидаемыми данными
        Response response = given()
                .contentType("text/plain")  // Устанавливаем Content-Type для запроса
                .body("This is expected to be sent back as part of response body.")  // Передаем тело запроса
                .when()
                .delete("/delete");  // Выполняем DELETE-запрос

        // Проверка статус-кода
        response.then().statusCode(200);

        // Проверка заголовка Content-Type
        response.then().header("content-type", equalTo("application/json; charset=utf-8"));

        // Проверка содержимого JSON-ответа
        response.then().body("data", equalTo("This is expected to be sent back as part of response body."));

        // Дополнительные проверки (опционально)
        response.then().body("args", anEmptyMap());
        response.then().body("files", anEmptyMap());
        response.then().body("form", anEmptyMap());
        response.then().body("headers.host", equalTo("postman-echo.com"));
        response.then().body("url", equalTo("https://postman-echo.com/delete"));
    }
}

