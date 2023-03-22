package de.turing85;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    @Test
    void testHelloEndpoint() {
        String expected = "this is very important";
        given()
            .body("""
                <body>
                    <relevant-text>%s</relevant-text>
                </body>
                """.formatted(expected))
          .when().post("/hello")
          .then()
             .statusCode(200)
             .body(is(expected));
    }

}