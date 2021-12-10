package WaytoPostTheRequest;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestcaseUsingJsonObject {
	@Test
	public void testcasejson() {
		Random RanNum = new Random(); 
		int ranNum=RanNum.nextInt(1000);
		JSONObject jobj = new JSONObject();
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.delete("http://localhost:8084/projects/TY_PROJ_1012")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.and()
		.statusCode(204).log().all();


	}

}

