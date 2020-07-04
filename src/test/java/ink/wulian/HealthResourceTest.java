package ink.wulian;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class HealthResourceTest {

    @Test
    public void testHealth() {
        RestAssured.given()
                .when().get("/health")
                .then()
                .statusCode(200)
        // .body(is("ok"))
        ;
    }

}
