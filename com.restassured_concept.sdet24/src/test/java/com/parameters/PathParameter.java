package com.parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
	@Test
	public void path() {
		String proid="TY_PROJ_1010";//test data from excel sheet
		given()
		.pathParam("projectID", proid)
		.when()
		.delete("http://localhost:8084/projects/{projectID}")
		.then()
		.assertThat().statusCode(204)
		.log().all();
		
	}

}
