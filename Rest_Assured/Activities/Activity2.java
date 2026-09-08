package Activity;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Activity2 {
	@Test(priority=1)
	public void addNewUserFromFile() throws IOException {
		FileInputStream inputJSON = new FileInputStream("src/test/resources/userinfo.json");
 		Response response = given()
			.baseUri("https://petstore.swagger.io/v2/user") 
			.header("Content-Type", "application/json") 
			.body(inputJSON) 
			.when().post(); 
 
		System.out.println("===== ADD USER RESPONSE =====");
		System.out.println("Status Code: " + response.getStatusCode());
		response.prettyPrint();
		
		inputJSON.close();
 
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("5555"));
	}
	
	@Test(priority=2)
	public void getUserInfo() {
		File outputJSON = new File("src/test/java/activities/userGETResponse.json");
 
		Response response = given()
			.baseUri("https://petstore.swagger.io/v2/user") 
			.header("Content-Type", "application/json") 
			.pathParam("username", "NidhiD") 
			.when().get("/{username}"); 
		
		System.out.println("===== GET USER RESPONSE =====");
		System.out.println("Status Code: " + response.getStatusCode());
		response.prettyPrint();
		
		String resBody = response.getBody().asPrettyString();
 
		try {
			// Create JSON file
			outputJSON.createNewFile();
			FileWriter writer = new FileWriter(outputJSON.getPath());
			writer.write(resBody);
			writer.close();
		} catch (IOException excp) {
			excp.printStackTrace();
		}
		
		// Assertion
		response.then().body("id", equalTo(5555));
		response.then().body("username", equalTo("NidhiD"));
		response.then().body("firstName", equalTo("Nidhi"));
		response.then().body("lastName", equalTo("D"));
		response.then().body("email", equalTo("NidhiD@mail.com"));
		response.then().body("password", equalTo("password1234"));
		response.then().body("phone", equalTo("9922773344"));
	}
	
	@Test(priority=3)
	public void deleteUser() throws IOException {
		Response response = given()
			.baseUri("https://petstore.swagger.io/v2/user") 
			.header("Content-Type", "application/json") 
			.pathParam("username", "NidhiD") 
			.when().delete("/{username}"); 
 
		System.out.println("===== DELETE USER RESPONSE =====");
		System.out.println("Status Code: " + response.getStatusCode());
		response.prettyPrint();
		
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("NidhiD"));
	}
}