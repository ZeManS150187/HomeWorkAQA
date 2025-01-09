package Lesson17;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PostmanEchoQueryTest {

    @Test
    public void testResponseWithQueryParams() {
        Response response = RestAssured
                .given()
                .baseUri("https://postman-echo.com")
                .queryParam("foo1", "bar1") // Параметр запроса foo1
                .queryParam("foo2", "bar2") // Параметр запроса foo2
                .get("/get");

        // Проверка, что статус ответа 200
        response.then()
                .statusCode(200);

        // Проверка, что параметры запроса отразились в ответе
        response.then()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));

        // Дополнительно: проверяем наличие других полей
        response.then()
                .body("headers", notNullValue())
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }
}

