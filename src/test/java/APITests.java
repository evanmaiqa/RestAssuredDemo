import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITests {
    // https://www.youtube.com/watch?v=Orn8cP1yRJc
    @Test
    public void statusTest() {
        given()
                .when()
                .get("http://demo.guru99.com")
                .then()
                .statusCode(200);
    }

    @Test
    public void statusLineTest() {
        Assert.assertEquals(RestAssured.get("http://demo.guru99.com").getStatusLine(), "HTTP/1.1 200 OK");
    }
    @Test
    public void getStatusTextTest() {
        given()
                .given()
                .get("http://demo.guru99.com")
                .then()
                .log()
                .status();
    }
    @Test
    public void statusTextTest() {
        given()
                .given()
                .get("http://demo.guru99.com")
                .then()
                .statusLine("HTTP/1.1 200 OK");
    }
}
