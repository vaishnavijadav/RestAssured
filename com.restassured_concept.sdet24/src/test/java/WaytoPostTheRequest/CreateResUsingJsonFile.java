package WaytoPostTheRequest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class CreateResUsingJsonFile {
	@Test
	public void jsonFile() {
		
		File file = new File("./src/test/resources/JsonFile.json");

		given()
		.body(file)
		.contentType(ContentType.JSON)
		
		.when()
		.put("http://localhost:8084/addProject")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		//.and().statusCode(200)
		.log().all();
	}

}
