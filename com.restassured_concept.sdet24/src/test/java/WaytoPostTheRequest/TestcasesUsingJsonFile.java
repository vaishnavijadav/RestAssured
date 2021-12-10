package WaytoPostTheRequest;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;



public class TestcasesUsingJsonFile {
	@Test
	public void testCaseFile() {
		File file = new File("./src/test/resources/JsonFile.json");
		given()
		.body(file)
		.contentType(ContentType.JSON)
		
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1011")
		
		.then()
		.assertThat().statusCode(201)
		.and().contentType(ContentType.JSON)
		.log().all();
		
	}
	
}
