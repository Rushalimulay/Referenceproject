
package test_classes;

import java.io.IOException;

import org.testng.Assert;
import Common_API_Method.Post_API_method;
import Common_API_Method.Put_API_method;
import RequestRepository.Post_req_repository;
import RequestRepository.Put_req_repository;
import io.restassured.path.json.JsonPath;

public class Post_TC1 {
	
	public static void extractor () throws IOException {
		int statusCode =Post_API_method.responseStatusCode(Post_req_repository.BaseURI(), Post_req_repository.Post_Resource(), Put_req_repository.Put_req_TC1());
		System.out.println(statusCode);
	String ResponseBody = Post_API_method.ResponseBody(Post_req_repository.BaseURI(),Post_req_repository.Post_Resource(),Post_req_repository.Post_Req_TC1());
	JsonPath JspResponse = new JsonPath(ResponseBody);
	String Res_name = JspResponse.getString("name");
	String Res_job = JspResponse.getString("job");
	
	
	//System.out.println(Res_name,);
	Assert.assertEquals(Res_name,"morpheus");
	Assert.assertEquals(Res_job,"leader");
	}

}





	


