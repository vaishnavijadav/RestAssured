package com.responsevalidation.dynamicandstatic;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicValidateResponse {
	@Test
	public void dynamicResponse() {
		String expectedProjID="TY_PROJ_1014";
		Response respone = when()
		.get("http://localhost:8084/projects");
		
		List<String> ProjectID=respone.jsonPath().get("projectId");
		String actualProjectID=null;
		for(String proName:ProjectID) {
			if(proName.equals(expectedProjID)) {
				 actualProjectID = proName;
			}
	}
		Assert.assertEquals(actualProjectID, expectedProjID);
	}
}
