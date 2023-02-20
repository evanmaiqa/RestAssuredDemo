import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MyTests {
    @Test
    public void getResponseAll() {
        given() // No headers required, no query or path param.
                .when() // No specific condition setup
                .get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1") // only the url needs to be supplied
                .then() // No specific assertions required
                .log()
                .all(); // Once all the response is fetched, log response, headers, essentially everything that the request returns to you.
    }

    @Test
    public void getResponseStatus() {
        given()
                .queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when()
                .get("http://demo.guru99.com/V4/sinkministatement.php")
                .then()
                .statusCode(200);
    }

    @Test
    public void getResponseBodyTest() {
        given()
                .queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when()
                .get("http://demo.guru99.com/V4/sinkministatement.php")
                .then()
                .log()
                .body();
    }

    @Test
    public void contentTypeTest() {
        System.out.println(given()
                .queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when()
                .get("http://demo.guru99.com/V4/sinkministatement.php")
                .then()
                .extract()
                .contentType());
    }

    @Ignore
    @Test
    public void test1() {
        Response response = RestAssured.get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1");
        System.out.println(" - ");
        System.out.println(response.getBody().asString());
        System.out.println(" - ");
        System.out.println(response.getHeaders());
    }
}
