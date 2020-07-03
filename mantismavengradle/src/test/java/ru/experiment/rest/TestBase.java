package ru.experiment.rest;

import com.github.viclovsky.swagger.coverage.SwaggerCoverageRestAssured;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class TestBase {
    RequestSpecification request;

    @BeforeClass
    public void setUp() {
        request = RestAssured.given().filter(new SwaggerCoverageRestAssured());
        request.baseUri("https://petstore.swagger.io/v2").request();
    }
}
