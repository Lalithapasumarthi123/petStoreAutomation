package api.endpoints;
/*
 * To implement CRUD operations of the user apis in user module
 */
//import api.endpoints.Routes;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndpoints2 {
	
	//Created to pass the urls from routes.properties
	static ResourceBundle getURL(){
		ResourceBundle routes=ResourceBundle.getBundle("routes"); // load properties file
		return routes;
		
	}
	//Pass the payload to create the user
	public static Response createUser(User payload) 
	{
		String post_url=getURL().getString("post_url");
		System.out.println(post_url);
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(post_url);
		return response;
	}
	
	public static Response readUser(String username) 
	{
		String get_url=getURL().getString("get_url");
		Response response=given()
			.pathParam("username", username)
		.when()
			.get(get_url);
		return response;
	}
	public static Response updateUser(User payload, String username) 
	{
		String update_url=getURL().getString("update_url");
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", username)
		.body(payload)
		.when()
		.put(update_url);
		return response;
	}
	public static Response deleteUser(String username) 
	{
		String delete_url=getURL().getString("delete_url");
		Response response=given()
			.pathParam("username", username)
		.when()
			.delete(delete_url);
		return response;
	}
}
