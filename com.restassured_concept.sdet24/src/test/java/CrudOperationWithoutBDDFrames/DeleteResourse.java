package CrudOperationWithoutBDDFrames;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteResourse {
	@Test
	public void deleteresourse() {
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_612");
		ValidatableResponse validateRes = response.then();
		validateRes.assertThat().statusCode(204);
		validateRes.log().all();
	}

}
