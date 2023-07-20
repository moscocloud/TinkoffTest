package data.person;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class GetJson {

    private static final int RANDOM = 1 + (int) (Math.random() * 5);

    public static Person getUser() {
        return given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .basePath(String.format("/users/%d", RANDOM))
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .extract().jsonPath().getObject("", Person.class);
    }

}