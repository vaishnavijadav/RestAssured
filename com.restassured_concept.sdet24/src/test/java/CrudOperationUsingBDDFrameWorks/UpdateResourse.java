package CrudOperationUsingBDDFrameWorks;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateResourse {
	@Test
	public void putresourse()
	{
		JSONObject jobj = new JSONObject();
		
		jobj.put("createdOn", "78/12/2021");
		jobj.put("projectName", "hi");
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1002")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.and()
		.statusCode(200).log().all();
		
	}

}
