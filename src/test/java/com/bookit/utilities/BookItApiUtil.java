package com.bookit.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookItApiUtil {

    public static String getAccessToken(String email, String password){

        String accessToken = given().accept(ContentType.JSON)
                .and().queryParams("email", email,
                        "password",password)
                .when().get(Environment.BASE_URL + "/sign")
                .then().statusCode(200)
                .and().extract().body().path("accessToken");
        System.out.println("accessToken = " + accessToken);
        return "Bearer " + accessToken;
    }

}
