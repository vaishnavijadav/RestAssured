package WaytoPostTheRequest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.genericPojoLibrary.PojoLibrary;

import io.restassured.http.ContentType;

public class TestcasesPojoRes {
	@Test
	public void create() {
	PojoLibrary pj =new PojoLibrary("charlie", "20/01/1995", "charlie chapplin", "created", 1);
	given()
	.body(pj)
	.contentType(ContentType.JSON)
	
	.when()
	.post("http://localhost:8084/addProject")
	.then()
	.assertThat().contentType(ContentType.JSON)
	.and()
	.statusCode(201)
	.log().all();
}
}

