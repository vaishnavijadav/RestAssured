package CrudOperationWithoutBDDFrames;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateResourse {
	@Test
	public void putResource() {
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "jackson mapper");
		jobj.put("createdOn", "09/12/200");
		jobj.put("teamSize", "09");
		jobj.put("projectId", "TY_PROJ_1010");
		jobj.put("projectName", "jacksonmapper snippet");
		jobj.put("status", "on going");
		
		 RequestSpecification reqSpec = RestAssured.given();
		reqSpec.body(jobj);
		reqSpec.contentType(ContentType.JSON);
		
		Response response = reqSpec.put("http://localhost:8084/projects/TY_PROJ_206");
		ValidatableResponse validateResponse = response.then();
		validateResponse.assertThat().contentType(ContentType.JSON);
		validateResponse.log().all();
		
	}

}
