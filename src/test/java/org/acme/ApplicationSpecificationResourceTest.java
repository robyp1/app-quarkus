package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ApplicationSpecificationResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello-resteasy")
          .then()
             .statusCode(200)
//             .body(is("{\"content\":\"<HEAD></HEAD><BODY></BODY>\",\"id\":2,\"ownerId\":\"1\",\"template-name\":\"Roby\",\"templateType\":\"IT\"}"));
                    .body("content",is("<HEAD></HEAD><BODY></BODY>"))
                .and()
                    .body( "id", is(2))
                .and()
                    .body("ownerId", is("1"))
                .and()
                     .body("template-name", is("Roby"))
                .and()
                     .body("templateType", is("IT"));
    }


}