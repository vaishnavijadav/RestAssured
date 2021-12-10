package CrudOperationUsingBDDFrameWorks;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateResourse {
	@Test
	public void postresourse() {
		Random RanNum = new Random(); 
		int ranNum=RanNum.nextInt(1000);
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "vaishnavipuneth");
		jobj.put("createdOn", "01/12/2021");
		jobj.put("projectId", "hello1"+ranNum);
		jobj.put("projectName", "hello"+ranNum);
		jobj.put("status", "on going");
		jobj.put("teamSize", "20");

		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.and()
		.statusCode(201).log().all();


	}

}
