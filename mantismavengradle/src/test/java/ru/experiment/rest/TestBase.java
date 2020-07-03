package ru.experiment.rest;

import com.github.viclovsky.swagger.coverage.SwaggerCoverageRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;

public class TestBase {
    RequestSpecification request;
    ResponseSpecification responseSpec;

    @BeforeClass
    public void setUp() {
        request = RestAssured.given().filter(new SwaggerCoverageRestAssured());
        request.baseUri("https://petstore.swagger.io/v2").request();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }


}
