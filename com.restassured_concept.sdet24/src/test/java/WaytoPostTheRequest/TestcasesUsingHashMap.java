package WaytoPostTheRequest;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class TestcasesUsingHashMap {
	@Test
	public void Testcasehashmap() {
		HashMap hobj = new HashMap();
		hobj.put("createdBy", "vaishnavipuneth");
		hobj.put("createdOn", "20/01/1995");
		hobj.put("projectName", "hello");
		hobj.put("status", "on going");
		hobj.put("teamSize", "20");
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.body(hobj);
		reqSpec.contentType(ContentType.JSON);
		
		Response response = reqSpec.post("http://localhost:8084/addProject");
		ValidatableResponse validateRes = response.then();
		validateRes.assertThat().contentType(ContentType.JSON);
		validateRes.statusCode(201);
		validateRes.log().all();
		
	}

}
