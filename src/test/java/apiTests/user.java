package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.stringContainsInOrder;

public class user {
    String uri = "https://petstore.swagger.io/v2/user";
    int userId = 2012;

     // Padrão
    // Given = Dado
    // .When = Quando
    // .Then = Então

    // Funções de Apoio
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test(priority = 0)
    public void incluirUser() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/user.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(Integer.toString(userId)))
        ;
    }

    @Test(priority = 1, dependsOnMethods = {"incluirUser"})
    public void consultarUser(){

       given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "/" + userId)
        .then()
                .log().all()
        ;
    }

    @Test(priority = 2, dependsOnMethods = {"consultarUser"})
    public void alterarUser() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/newuser.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .put(uri)
        .then()
                .log().all()
        ;
    }

    @Test(priority = 3, dependsOnMethods = {"alterarUser"})
    public void excluirUser(){

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .delete(uri + "/" + userId)
        .then()
                .log().all()
        ;
    }
}
