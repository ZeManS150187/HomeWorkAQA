package Lesson17;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTestFormData {
    @Test
    public void testPostmanEchoResponse() {
        // Настройка базового URI
        RestAssured.baseURI = "https://postman-echo.com";

        // Отправляем POST-запрос с данными формы и явным указанием кодировки UTF-8
        Response response = given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")  // Явное указание кодировки
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post");

        // Выводим статусный код и тело ответа для отладки
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        // Проверки
        response.then()
                .statusCode(200) // Проверяем, что статус 200
                .body("form.foo1", equalTo("bar1")) // Проверяем, что form содержит foo1 = bar1
                .body("form.foo2", equalTo("bar2")) // Проверяем, что form содержит foo2 = bar2
                .body("json.foo1", equalTo("bar1")) // Проверяем, что json содержит foo1 = bar1
                .body("json.foo2", equalTo("bar2")); // Проверяем, что json содержит foo2 = bar2
    }
}
