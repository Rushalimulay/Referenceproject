package RequestRepository;

public class Patch_req_repository {
	public static String BaseURI() {
		 String baseURI = "https://reqres.in/";
		 return baseURI;	 
	}
	
	public static String Patch_Resource() {
		String post_Resource = "api/users";
		return post_Resource;
	}
	
	public static String Patch_req_TC1() {

		String requestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		return requestBody;

	}
}
