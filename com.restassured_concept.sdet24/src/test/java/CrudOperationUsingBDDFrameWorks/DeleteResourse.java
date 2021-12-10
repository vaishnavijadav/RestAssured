package CrudOperationUsingBDDFrameWorks;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class DeleteResourse {
	@Test
	public void deleteresource() {

		when()
		.delete("http://localhost:8084/projects/TY_PROJ_804")

		.then()
		.assertThat()
		.statusCode(600)
		.log().all();


	}

}
