package ru.netology.test;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class postmanEchoTest {

    @Test
    void shouldTestData() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Netology")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Netology"))
        ;
    }

    @Test
    void shouldPostTest() {
        given()
                .baseUri("https://postman-echo.com")
                .body("Homework autotest")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Homework autotest"))

        ;
    }

    @Test
    void shouldTestGetArgsFoo2() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("some data")
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar2"))
        ;
    }

    @Test
    void shouldHeadersTest() {
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .get("/headers")
                .then()
                .statusCode(200)
                .headers("Connection", "keep-alive",
                        "Content-Type", "application/json; charset=utf-8");

    }

    @Test
    void shouldTestAuth() {
        given()
                .baseUri("https://postman-echo.com")
                .headers("Authorization", "Basic cG9zdG1hbjpwYXNzd29yZA==")
                .when()
                .get("/basic-auth")

                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
        ;
    }
}
