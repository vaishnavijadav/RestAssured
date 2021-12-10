package CrudOperationWithoutBDDFrames;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllResourse {
	@Test
	public void getallresourse() {
		Response response = RestAssured.get("http://localhost:8084/projects");
		System.out.println(response.getContentType());
		System.out.println(response.getTime());
		System.out.println(response.getStatusCode());
		System.out.println(response.getTimeIn(TimeUnit.SECONDS));
		System.out.println(response.getHeader(null));
		
		ValidatableResponse validateResponse = response.then();
		validateResponse.log().all();
	}

}
