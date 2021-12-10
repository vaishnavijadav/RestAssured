package CrudOperationWithoutBDDFrames;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreateResourse {
	@Test
	public void postResourse() {
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "jackson");
		jobj.put("createdOn", "09/12/1998");
		jobj.put("teamSize", "0");
		jobj.put("projectId", "TY_PROJ_1008");
		jobj.put("projectName", "jacksonmapper");
		jobj.put("status", "created");

		RequestSpecification respec = RestAssured.given();
		respec.body(jobj);
		respec.contentType("application/json");

		Response response = respec.post("http://localhost:8084/addProject");
		ValidatableResponse validateResponse = response.then();
		validateResponse.assertThat().statusCode(201);
		validateResponse.assertThat().contentType(ContentType.JSON);
		validateResponse.log().all();
	}


}
