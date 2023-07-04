package freamwork;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Patch_ref {

	public static void main(String[] args) {
RestAssured.baseURI = "https://reqres.in/";
		
		String requestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		System.out.println(requestBody);
		
		JsonPath Jsprequest = new JsonPath(requestBody);
		String req_name = Jsprequest.getString("name");
		String req_job = Jsprequest.getString("job");
		LocalDateTime current = LocalDateTime.now();
		String expecteddate = current.toString().substring(0,11);
		System.out.println(req_name);
		System.out.println(req_job);
		
		String responsebody= given().header("Content-Type","application/json").body(requestBody).when().patch("api/users/2")
				.then().extract().response().asString();
		System.out.println(responsebody);
		
		JsonPath Jspresponse = new JsonPath(responsebody);
		String res_name = Jspresponse.getString("name");
		String res_job = Jspresponse.getString("job");
		String res_updatedAt = Jspresponse.getString("updatedAt");
		res_updatedAt = Jspresponse.getString("updatedAt");
		
		Assert.assertEquals(res_name, "morpheus");
		Assert.assertEquals(res_job, "zion resident");
		Assert.assertEquals(res_updatedAt, expecteddate);
		
		

	}




	

}
