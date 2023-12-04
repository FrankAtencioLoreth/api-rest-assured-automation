package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestAssuredExt {

    /**
     * Attributes
     ***/
    public  static RequestSpecification request;
    public  static ResponseOptions<Response> response;
    public static String token;
    private final String BASE_URL = "http://localhost:3000";

    public RestAssuredExt() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(BASE_URL);
        builder.setContentType(ContentType.JSON);
        var requestSpec = builder.build();
        request = RestAssured.given().spec(requestSpec);
    }

    /**
     * Method that allows authentication of a user
     * @param url
     * @param body
     * @return response
     * **/
    public static ResponseOptions<Response> authenticate(String url, Map<String, String> body) {
        return request
        .body(body)
        .post(url);
    }

    /**
     * Method to obtain an specific record
     * @param url
     * @param token
     * @return response
     * **/
    public static ResponseOptions<Response> get(String url, String token) {
        return request
        .header("Authorization", "Bearer " + token)
        .get(url);
    }

    /**
     * Method to obtain a record
     * @param url
     * @param token
     * @param pathParam
     * @return response
     * **/
    public static ResponseOptions<Response> get(String url, String token, Map<String, String> pathParam) {
        return request
        .header("Authorization", "Bearer " + token)
        .pathParams(pathParam)
        .get(url);
    }

    /**
     * Method that allows to register a book
     * @param url
     * @param token
     * @return response
     * **/
    public static ResponseOptions<Response> post(String url, String token, Map<String, String> body) {
        return request
        .header("Authorization", "Bearer " + token)
        .body(body)
        .post(url);
    }

    /**
     * Method that allows to update a book
     * @param url
     * @param token
     * @param pathParam
     * @param body
     * @return response
     * **/
    public static ResponseOptions<Response> put(String url, String token, Map<String, String> pathParam,Map<String, String> body) {
        return request
        .header("Authorization", "Bearer " + token)
        .pathParams(pathParam)
        .body(body)
        .put(url);
    }

    /**
     * Method that allows to delete a book
     * @param url
     * @param token
     * @param pathParam
     * @return response
     * **/
    public static ResponseOptions<Response> delete(String url, String token, Map<String, String> pathParam) {
        return request
        .header("Authorization", "Bearer " + token)
        .pathParams(pathParam)
        .delete(url);
    }

}
