package test_classes;

import org.testng.Assert;

import Common_API_Method.Patch_API_method;
import RequestRepository.Patch_req_repository;
import io.restassured.path.json.JsonPath;

public class Patch_TC1 {
	
	public static void extractor() {
		int statuscode = Patch_API_method.responsestatuscode(Patch_req_repository.BaseURI(), Patch_req_repository.Patch_Resource(), Patch_req_repository.Patch_req_TC1());
		System.out.println(statuscode);
		String responsebody= Patch_API_method.ResponseBody(Patch_req_repository.BaseURI(), Patch_req_repository.Patch_Resource(), Patch_req_repository.Patch_req_TC1());
		System.out.println(responsebody);
		
		JsonPath Jspresponse = new JsonPath(responsebody);
		String res_name = Jspresponse.getString("name");
		String res_job = Jspresponse.getString("job");
		
		Assert.assertEquals(res_name, "morpheus");
		Assert.assertEquals(res_job, "zion resident");
	}

}
