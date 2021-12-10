package com.parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class ParameterUsingGitHub {
	@Test
	public void parameters() {
		
		given()
		.pathParams("username", "vaishnavijadav")
		.queryParam("sort", "created")
		.queryParam("sort", "updated")
		.when()
		.get("https://api.github.com/users/{username}/repos")
		.then()
		.statusCode(200)
		.log().all();
	}

}
