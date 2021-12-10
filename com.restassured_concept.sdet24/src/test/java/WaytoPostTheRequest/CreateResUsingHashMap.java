package WaytoPostTheRequest;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateResUsingHashMap {
	@Test
	public void createHashmap() {
		HashedMap hobj = new HashedMap();
		hobj.put("projectId", "TY_PROJ_1010");
		hobj.put("projectName", "dependency");
		hobj.put("status", "completed");
		
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
