package Lesson17;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTestPutRequest {
    @Test
    public void testPostmanEchoResponse() {
        // Установка базового URL для Postman Echo API
        RestAssured.baseURI = "https://postman-echo.com";

        // Выполнение PUT-запроса с ожидаемыми данными
        Response response = given()
                .contentType("text/plain")  // Устанавливаем Content-Type для запроса
                .body("This is expected to be sent back as part of response body.")  // Передаем тело запроса
                .when()
                .put("/put");  // Выполняем PUT-запрос

        // Проверка статус-кода
        response.then().statusCode(200);

        // Проверка заголовка Content-Type
        response.then().header("content-type", equalTo("application/json; charset=utf-8"));

        // Проверка содержимого JSON-ответа
        response.then().body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}
