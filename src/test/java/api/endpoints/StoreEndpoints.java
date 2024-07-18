package api.endpoints;
/*
 * {
    "id": 200000,
    "petId": 10,
    "quantity": 0,
    "shipDate": "2024-07-16T06:20:34.651+0000",
    "status": "placed",
    "complete": true
}
 */
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndpoints {
public static Response createOrder(Store payload){
	Response response=given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(payload)
	.when()
	.post(Routes.post_store_url);
	return response;
}
public static Response getOrder(int orderid) {
	Response response=given()
			.contentType(ContentType.JSON)
			.pathParam("orderid", orderid)
			.when()
			.get(Routes.get_order_url);
			return response;
}
public static Response getStoreInventory() {
	Response response=given()
			.contentType(ContentType.JSON)
			.when()
			.get(Routes.get_store_url);
			return response;
}
public static Response deleteOrder(int orderid) {
	Response response=given()
			.pathParam("orderid", orderid)
			.when()
			.get(Routes.delete_order_url);
			return response;
}
}
