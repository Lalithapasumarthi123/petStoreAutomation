package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints2;
import api.payload.User;
import io.restassured.response.Response;

/*
 * Create data using setup function
 * Post user
 * get user
 * Update user
 * Delete user
 */
public class UserModuleTestsbyProperties {
	Faker faker;
	User payload;
	public Logger logger;
	@BeforeTest
public void setUp() {
		faker=new Faker();
		payload=new User();
		payload.setId(faker.idNumber().hashCode());
		payload.setUsername(faker.name().username());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().emailAddress());
		payload.setPassword(faker.internet().password(0, 5));
		payload.setPhone(faker.phoneNumber().cellPhone());
		//Logs
		logger= LogManager.getLogger(this.getClass());
}
	@Test(priority=1)
	public void testCreateUser() {
		logger.info("*********creating user************");
		Response response=UserEndpoints2.createUser(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*********created user************");
	}
	@Test(priority=2)
	public void UserGetByName() {
		logger.info("*********Selecting user by user Name************");
		Response response=UserEndpoints2.readUser(this.payload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*********Selected user by user Name************");
	}
	@Test(priority=3)
	public void updateUserByName() {
		logger.info("*********Updating user by user Name************");
		payload.setUsername(faker.name().username());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		
		Response response=UserEndpoints2.updateUser(payload,this.payload.getUsername());
		
		response.then().log().all();
		response.then().log().body().statusCode(200);
//		Assert.assertEquals(response.getStatusCode(), 200);
		//Checking data after updating
		Response responseUpdated=UserEndpoints2.readUser(this.payload.getUsername());
		responseUpdated.then().log().all();
		Assert.assertEquals(responseUpdated.getStatusCode(), 200);
		logger.info("*********Updated user by user Name************");
	}
	@Test(priority=4)
	public void deleteUserByusername() {
		logger.info("*********Deleting user by user Name************");
		Response response=UserEndpoints2.deleteUser(this.payload.getUsername());
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*********Deleted user by user Name************");
	}
}
//1234250905
//1234250905
