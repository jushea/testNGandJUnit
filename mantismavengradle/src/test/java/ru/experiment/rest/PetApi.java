package ru.experiment.rest;

import com.google.gson.Gson;
import org.apache.http.HttpStatus;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.response.ValidatableResponse;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import ru.experiment.rest.model.Pet;
import ru.experiment.rest.model.Tag;
import ru.experiment.rest.model.Category;

import java.util.ArrayList;

public class PetApi extends TestBase{
    static final String FIND_BY_STATUS = "/pet/findByStatus";
    //https://github.com/rest-assured/rest-assured/issues/1186 Ошибка. после версии restassured 4.0.0
    // matchesJsonSchema(param). param не может быть путем до файла со схемой ответа. param это строка-схема json.

    @Test(dataProvider = "parameters")
    public void getFindByStatusTest(String parameter) {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory
                .newBuilder()
                .setValidationConfiguration(
                        ValidationConfiguration.newBuilder()
                                .setDefaultVersion(SchemaVersion.DRAFTV4).freeze())
                .freeze();
        given(request)
                .accept(ContentType.JSON)
                .param("status", parameter)
                .when()
                .get(FIND_BY_STATUS)
                .then()
                .spec(responseSpec)
                .assertThat()
                .body(matchesJsonSchema(SchemaJson.PETSCHEMAJSON)
                        .using(jsonSchemaFactory))
                .extract()
                .response().body().path("[0].status").equals(parameter);
    }

    @DataProvider(name="parameters")
    public static Object[][] parameters() {
        return new Object[][]{{"sold"},{"pending"},{"available"}};
    }

    @Test(description = "without parameters")
    public void getFindByStatusWithoutTest() {
        ValidatableResponse response = given(request)
                .accept(ContentType.JSON)
                .when()
                .get(FIND_BY_STATUS)
                .then()
                .spec(responseSpec);
        System.out.println(response.extract().jsonPath().getString("$"));
    }

    @Test(description = "status 404")
    public void getFindByStatusFullTest() {
        given(request)
                .accept(ContentType.JSON)
                .param("status","[]")
                .when()
                .get(FIND_BY_STATUS)
                .then()
                .spec(responseSpec);
    }

    @Test(enabled = true)
    public void postPetTest() {
        String newpet = postPet(486395824, "Murzik", "sold", 11,
                "livestock", "cat.jpg", 1, "home");

        //API
        Response response = given(request)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(newpet)
                .when()
                .post("/pet").andReturn();
        response
                .then()
                .assertThat()
                .spec(responseSpec);

        System.out.println(response.then().assertThat().statusCode(200).extract().jsonPath().getString("$"));
    }

    @Test
    public void updatePetTest() {
        Pet updatepet = new Pet();
        updatepet.id = 486395824;
        updatepet.name = "Murzik";
        updatepet.status = "sold";
        updatepet.category = new Category( 1,"livestock");

        ArrayList<String> photoUrls = new ArrayList<String>();
        photoUrls.add("cat.jpg");
        updatepet.photoUrls = photoUrls;

        Tag tag = new Tag(1,"home");
        ArrayList<Tag> tagarray = new ArrayList<Tag>();
        tagarray.add(tag);
        updatepet.tags = tagarray;

        Gson gson = new Gson();
        String murzik = gson.toJson(updatepet);
        System.out.println(murzik);

        Response response = given(request)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(gson.toJson(updatepet))
                .when()
                .put("/pet").andReturn();
        response.then().spec(responseSpec);
    }

    @Test
    public void deletePetTest() {
        String newpet = postPet(486395824, "Murzik", "sold", 11,
                "livestock", "cat.jpg", 1, "home");
        given(request)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(newpet)
                .when()
                .post("/pet");

        given(request)
                .accept(ContentType.JSON)
                .when()
                .delete("/pet/486395824")
                .then()
                .spec(responseSpec);
    }

    public String postPet(int id,
                        String name,
                        String status,
                        int categoryId,
                        String categoryName,
                        String url,
                        int tagId,
                        String tagName) {
        Pet newpet = new Pet();
        newpet.id = id;
        newpet.name = name;
        newpet.status = status;
        newpet.category = new Category(categoryId,categoryName);

        ArrayList<String> photoUrls = new ArrayList<String>();
        photoUrls.add(url);
        newpet.photoUrls = photoUrls;

        Tag tag = new Tag(tagId,tagName);
        ArrayList<Tag> tagarray = new ArrayList<Tag>();
        tagarray.add(tag);
        newpet.tags = tagarray;

        Gson gson = new Gson();
        String murzik = gson.toJson(newpet);
        System.out.println(murzik);
        return murzik;
    }

}
