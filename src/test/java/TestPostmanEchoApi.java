import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class TestPostmanEchoApi {
    private final String RESPONSE_MESSAGE = "Response Message";
    private final String BASE_URI = "https://postman-echo.com/";
    private final String GET_URI = "get?foo1=bar1&foo2=bar2";
    private final String POST_RAW_URI = "post";
    private final String POST_FORM_URI = "post";
    private final String PUT_URI = "put";
    private final String PATCH_URI = "patch";
    private final String DELETE_URI = "delete";

    @DataProvider
    public Object[][] positiveFactorialTest() {
        return new Object[][]{
                {(short) 0, 1L},
                {(short) 1, 1L},
                {(short) 20, 2432902008176640000L}};
    }

    @DataProvider
    public Object[] negativeFactorialTest() {
        return new Object[]{
                (short) -1,
                (short) 21};
    }

    @Test
    void get() {
        given().baseUri(BASE_URI)
                .when()
                .get(GET_URI)
                .then()
                .assertThat()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    void postRawText() {
        given().baseUri(BASE_URI)
                .body("{ \"foo1\": \"bar1\" }")
                .when()
                .post(POST_RAW_URI)
                .then()
                .statusCode(200)
                .assertThat()
                .body("data", equalTo("{ \"foo1\": \"bar1\" }"));
    }

    @Test
    void postFormData() {
        given().contentType(ContentType.URLENC.withCharset(StandardCharsets.UTF_8))
                .baseUri(BASE_URI)
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post(POST_FORM_URI)
                .then()
                .statusCode(200)
                .assertThat()
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));

    }

    @Test
    void put() {
        given().contentType(ContentType.TEXT)
                .baseUri(BASE_URI)
                .body(RESPONSE_MESSAGE)
                .when()
                .put(PUT_URI)
                .then()
                .statusCode(200)
                .body("data", equalTo(RESPONSE_MESSAGE));
    }


    @Test
    void patch() {
        given().contentType(ContentType.TEXT)
            .baseUri(BASE_URI)
            .body(RESPONSE_MESSAGE)
            .when()
            .patch(PATCH_URI)
            .then()
            .statusCode(200)
            .body("data", equalTo(RESPONSE_MESSAGE));
    }

    @Test
    void delete() {
        given().contentType(ContentType.TEXT)
                .baseUri(BASE_URI)
                .body(RESPONSE_MESSAGE)
                .when()
                .delete(DELETE_URI)
                .then()
                .statusCode(200)
                .body("data", equalTo(RESPONSE_MESSAGE));
    }
}
