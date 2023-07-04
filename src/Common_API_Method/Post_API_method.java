package Common_API_Method;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Post_API_method {
	public static int responseStatusCode(String baseURI,String resourse,String RequestBody) {
		RestAssured.baseURI=baseURI;
		
		int statuscode=given().header("Content-Type","application/json").body(RequestBody).
				when().post("/api/users").then().extract().statusCode();
		return statuscode;
	}
	public static String ResponseBody(String baseURI,String resourse,String RequestBody) {
		RestAssured.baseURI=baseURI;
		
		String responseBody = given().header("Content-Type","application/json").body(RequestBody).
				when().post("/api/users").then().extract().response().asString();
		return responseBody;
	}
	
}