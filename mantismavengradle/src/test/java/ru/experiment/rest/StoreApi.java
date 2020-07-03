package ru.experiment.rest;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.core.Is.is;

public class StoreApi extends TestBase {
    static final String ORDER = "/store/order/{orderid}";
    static final String INVENTORY = "/store/inventory";

    @Test
    public void getStoreOrder() {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory
                .newBuilder()
                .setValidationConfiguration(
                        ValidationConfiguration.newBuilder()
                                .setDefaultVersion(SchemaVersion.DRAFTV4).freeze())
                .freeze();
        given(request)
                .accept(ContentType.JSON)
                .pathParams("orderid", 3)
                .when()
                .get(ORDER)
                .then()
                .spec(responseSpec)
                .assertThat()
                .body(matchesJsonSchema(SchemaJson.STORESCHEMAJSON)
                        .using(jsonSchemaFactory));
        given(request)
                .accept(ContentType.JSON)
                .pathParams("orderid", 3)
                .when()
                .get(ORDER)
                .then()
                .spec(responseSpec)
                .assertThat().body("id", is(3));
    }


}
