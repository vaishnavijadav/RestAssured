package CrudOperationUsingBDDFrameWorks;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllResource {
	@Test
	public void getallresource() {
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().statusCode(200)
		.log().all();
  }
	
	}