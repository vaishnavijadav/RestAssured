package com.responsevalidation.dynamicandstatic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genericPojoLibrary.PojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class MutlipleDataForSameRequestUsingDataProvider {
	@Test(dataProvider = "getData")
	public void createDataProvider(String createBy, String createdOn, String projectName, String status, int teamSize) {
		
		PojoLibrary pobj = new PojoLibrary(createBy,createdOn,projectName , status, teamSize);
		given()
		.body(pobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat().contentType(ContentType.JSON)
		.and()
		.statusCode(201)
		.log().all();
		
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] objArray=new Object[2][4];
		objArray[0][0]="alice";
		objArray[0][1]="22/10/2999";
		objArray[0][2]="aliceAvengers";
		objArray[0][3]="completed";
		objArray[0][4]=10;
		
		objArray[1][0]="alice1";
		objArray[1][1]="22/10/2999";
		objArray[1][2]="aliceAvengers2";
		objArray[1][3]="on going";
		objArray[1][4]=30;
		return objArray;
	}

}
