package RestAssured;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssured {
	
	RequestSpecification requestSpec;
    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIBhmoUhvqRISd//ptZ9SVJMFRVgqvWHWn8gd++hNcYBo azuread\\\\nidhidhande@IBM-PF5HCJKX";
    int keyId;

    @BeforeClass
    public void setup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "token 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")
                .build();
    			}

    @Test(priority = 1)
    public void postSSHKey() {
    	System.out.println("\n====**** POST SSH KEY ****====");
    	
        String requestBody = "{\n" +
                "\"title\":\"TestAPIKey\",\n" +
                "\"key\":\"" + sshKey + "\"\n" +
                "}";
        
        System.out.println("Request Body:");
        System.out.println(requestBody);
        
        Response response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/user/keys");

        System.out.println("\nResponse:");
        response.prettyPrint();

        System.out.println("Status Code : " + response.getStatusCode());

        keyId = response.jsonPath().getInt("id");
        
        System.out.println("Generated Key ID : " + keyId);

        Reporter.log("Generated Key ID : " + keyId, true);
        
        Assert.assertEquals(response.getStatusCode(), 201);

        response.then()
                .body("title", equalTo("TestAPIKey"));
        
        System.out.println("POST Test Passed");
    }

    @Test(priority = 2, dependsOnMethods = "postSSHKey")
    public void getSSHKey() {
    	System.out.println("\n====**** GET SSH KEY ****====");
    	System.out.println("Key ID : " + keyId);
    	
        Response response = given()
                .spec(requestSpec)
                .pathParam("keyId", keyId)
                .when()
                .get("/user/keys/{keyId}");

        System.out.println("\nResponse:");
        response.prettyPrint();

        System.out.println("Status Code : " + response.getStatusCode());
        Reporter.log(response.asPrettyString(), true);

        Assert.assertEquals(response.getStatusCode(), 200);

        response.then()
                .body("id", equalTo(keyId))
                .body("title", equalTo("TestAPIKey"));
        
        System.out.println("GET Test Passed");
    }

    @Test(priority = 3, dependsOnMethods = "getSSHKey")
    public void deleteSSHKey() {

    	System.out.println("\n====**** DELETE SSH KEY ****====");
    	System.out.println("Deleting Key ID : " + keyId);
    	
        Response response = given()
                .spec(requestSpec)
                .pathParam("keyId", keyId)
                .when()
                .delete("/user/keys/{keyId}");

        System.out.println("Status Code : " + response.getStatusCode());
        Reporter.log("SSH Key Deleted", true);

        Assert.assertEquals(response.getStatusCode(), 204);
        
        System.out.println("DELETE Test Passed");
    }
}
