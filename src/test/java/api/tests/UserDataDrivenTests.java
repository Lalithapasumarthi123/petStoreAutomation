package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

/*
 * Passing data to user module from excel sheet
 */
public class UserDataDrivenTests {
	
	

	//Data providers are available in other packages, so need to mention dataProviderClass
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void createUserDD(String Userid,String UserStatus,String userName,String firstName,String lastName, String email,String password,String phone) {
		User payload=new User();
		payload.setId(Integer.parseInt(Userid));
		payload.setEmail(email);
		payload.setFirstName(firstName);
		payload.setLastName(lastName);
		payload.setPassword(password);
		payload.setPhone(phone);
		payload.setUserStatus(Integer.parseInt(UserStatus));
		payload.setUsername(userName);
		Response response=UserEndpoints.createUser(payload);
		response.then().log().all();
		System.out.println("User created"+response.body().toString());
		Assert.assertEquals(response.getStatusCode(), 200);
	Response responseUser=UserEndpoints.readUser(payload.getUsername());
	responseUser.then().log().all();
	
		
	}
	
	@Test(priority=2,dataProvider="usernames",dataProviderClass=DataProviders.class)
	public void deleteUser(String userName) {
//		User payload=new User();
		Response response=UserEndpoints.deleteUser(userName);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
