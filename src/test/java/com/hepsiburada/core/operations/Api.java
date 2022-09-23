package com.hepsiburada.core.operations;

import com.hepsiburada.core.utils.log;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import org.junit.Assert;


public class Api {


    public Api() {
    }

    public static String useGetService(String url, String serviceName, int statusCode) {

        Response response = null;

        try {
            RequestSpecification requestSpec = serviceHeaders();

            response = given().spec(requestSpec)
                    .when()
                    .get(url + serviceName)
                    .then()
                    .extract()
                    .response();

            log.info(serviceName + " Servis Response Body ---------> : " + response.body().asString());
            Assert.assertEquals(response.getStatusCode(), statusCode);
            log.info("Response code kontrolu basarili - 200");


        } catch (Exception e) {
            log.warn("" + e.toString());
            Assert.assertTrue("", false);
        }
        return response.asString();
    }

    public static String usePostService(String url, String serviceName, String requestbody, int statusCode) {

        Response response = null;

        try {
            RequestSpecification requestSpec = serviceHeaders();

            response = given().spec(requestSpec)
                    .body(requestbody)
                    .when()
                    .post(url + serviceName)
                    .then()
                    .extract()
                    .response();

            log.info(serviceName + " Servis Response Body ---------> : " + response.body().asString());
            Assert.assertEquals(response.getStatusCode(), statusCode);
            log.info("Response code kontrolu basarili - 200");

        } catch (Exception e) {
            log.warn("" + e.toString());
            Assert.assertTrue("", false);
        }
        return response.asString();
    }

    protected static RequestSpecification serviceHeaders() {

        return new RequestSpecBuilder().setContentType("application/json")
                .addHeader("accept", "application/json, application/xml, text/json, text/x-json, text/javascript, text/xml")
                .setRelaxedHTTPSValidation()
                .build();
    }

}
