package test_classes;

import org.testng.Assert;

import Common_API_Method.Put_API_method;
import RequestRepository.Put_req_repository;
import io.restassured.path.json.JsonPath;

public class Put_TC1 {
	public static void extractor() {
		int statuscode= Put_API_method.responsestatuscode(Put_req_repository.BaseURI(), Put_req_repository.Put_Resourse(), Put_req_repository.Put_req_TC1());
		System.out.println(statuscode);
		
		String ResponseBody = Put_API_method.ResponseBody(Put_req_repository.BaseURI(), Put_req_repository.Put_Resourse(), Put_req_repository.Put_req_TC1());
		System.out.println(ResponseBody);
		JsonPath Jspresponse = new JsonPath(ResponseBody);
		String res_name = Jspresponse.getString("name");
		String res_job = Jspresponse.getString("job");
		
		Assert.assertEquals(res_name, res_job);
		Assert.assertEquals(res_job, res_name);

	}

}

