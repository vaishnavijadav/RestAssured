package com.responsevalidation.dynamicandstatic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class StaticValidateResponse {
	@Test
	public void StaticResponse() {
		String actualProjectName="jacksonmapper";
		Response response = when()
		.get("http://localhost:8084/projects");
		String excpetedProName = response.jsonPath().get("[2].projectName");
		System.out.println("project name is"+excpetedProName);
		response.then()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
		Assert.assertEquals(actualProjectName, excpetedProName);
		
	}

}
