package utilities;

import java.util.Map;

public class Test {
	public static void main(String[] args) {
		DatabaseConnection db=new DatabaseConnection();
		Map<String, String> userData = db.getUserData("demo@gmail.com");
		System.out.println(userData);
		
		
	}

}
