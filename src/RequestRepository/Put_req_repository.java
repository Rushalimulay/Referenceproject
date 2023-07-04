package RequestRepository;

public class Put_req_repository {
	
	public static String BaseURI() {
	String baseURI = "https://reqres.in/";
	return baseURI;
	}
	public static String Put_Resourse() {
		String Put_resourse ="api/users/2";
		return Put_resourse;
	}
	public static String Put_req_TC1() {

		String requestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		return requestBody;
		
	}

}
