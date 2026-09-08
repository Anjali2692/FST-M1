package Activity;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity3 {
	
		RequestSpecification requestSpec;
		ResponseSpecification responseSpec;
	 
		@BeforeClass
		public void setUp() {
			requestSpec = new RequestSpecBuilder()
				.addHeader("Content-Type", "application/json")
				.setBaseUri("https://petstore.swagger.io/v2/pet")
				.build();
	 
			responseSpec = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType("application/json")
				.expectBody("status", equalTo("alive"))
				.build();
		}
	 
		@DataProvider(name = "petInfo")
		public Object[][] petInfoProvider() {
			Object[][] testData = new Object[][] { 
				{ 44444, "Apple", "alive" }, 
				{ 66666, "Mango", "alive" } 
			};
			return testData;
		}
	 
		@Test(priority=1, dataProvider = "petInfo")
		public void addPets(int petId, String petName, String petStatus) {
			Map<String, Object> reqBody = new HashMap<>();
			reqBody.put("id", petId);
			reqBody.put("name", petName);
			reqBody.put("status", petStatus);
			
			given().spec(requestSpec) 
				.body(reqBody) 
				.log().all()
			.when()
				.post() 
			.then()
			.log().all()
			.spec(responseSpec) 
			.body("name", equalTo(petName)); 
		}
	 
		@Test( priority=2, dataProvider = "petInfo")
		public void getPets(int petId, String petName, String petStatus) {
			given().spec(requestSpec) 
				.pathParam("petId", petId) 
				.log().all() 
			.when()
				.get("/{petId}") 
			.then()
				.log().all()
				.spec(responseSpec) 
			    .body("name", equalTo(petName)) 
			    .log().all(); 
		}
	 
		@Test(priority=3, dataProvider = "petInfo")
		public void deletePets(int petId, String petName, String petStatus) {
			given().spec(requestSpec) 
				.pathParam("petId", petId) 
				.log().all()
			.when()
				.delete("/{petId}") 
			.then()
				.log().all()
				.body("code", equalTo(200))
				.body("message", equalTo(""+petId)); 
		}
	}
