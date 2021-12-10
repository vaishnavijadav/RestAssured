package WaytoPostTheRequest;

import org.testng.annotations.Test;

import com.genericPojoLibrary.PojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PojoResourse {
	@Test
		public void create() {
		PojoLibrary pj =new PojoLibrary("RCB", "15/12/1995", "RCB fans", "created", 15);
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


