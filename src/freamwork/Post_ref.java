package freamwork;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import java.time.LocalDateTime;
import org.testng.Assert;

public class Post_ref {

	public static void main(String[] args) {
		
		String BaseURI = "https://reqres.in/";
		String requestBody = "{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"leader\"\r\n"
					+ "}";
		RestAssured.baseURI=BaseURI;
		JsonPath JspRequest = new JsonPath(requestBody);
		String Req_name= JspRequest.getString("name");
		String Req_job = JspRequest.getString("job");
		LocalDateTime currentdate = LocalDateTime.now();
		String expecteddate= currentdate.toString().substring(0,11);
	
		
		String responseBody=given().header("Content-Type","application/json").body(requestBody).
				when().post("/api/users").then().extract().response().asString();
		System.out.println(responseBody);
		
		JsonPath JspResponse= new JsonPath(responseBody);
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		String Res_createdAt = JspResponse.getString("createdAt");
		Res_createdAt = Res_createdAt.substring(0,11);
		
		Assert.assertEquals(Res_name, Req_name);
		Assert.assertEquals(Res_job, Req_job);
		Assert.assertEquals(Res_createdAt, expecteddate);
		
		
		

	}

}


