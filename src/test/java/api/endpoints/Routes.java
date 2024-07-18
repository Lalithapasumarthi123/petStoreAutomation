package api.endpoints;
/*
 * Contains only URL's for all requests
 * Swagger uri=https://petstore.swagger.io/v2
 * https://petstore.swagger.io/v2/user
 * https://petstore.swagger.io/v2/user/{username} -https://petstore.swagger.io/v2/user/user1
 * 
 */
public class Routes {
 public static String basic_url="https://petstore.swagger.io/v2";
 //End points for user module
 public static String post_url=basic_url+"/user";
 public static String get_url=basic_url+"/user/{username}";
 public static String delete_url=basic_url+"/user/{username}";
 public static String update_url=basic_url+"/user/{username}";
 //End points for store module
 public static String get_store_url="https://petstore.swagger.io/v2/store/inventory";
 public static String post_store_url="https://petstore.swagger.io/v2/store/order";
 public static String get_order_url=post_store_url+"/{orderid}";
 public static String delete_order_url=post_store_url+"{orderid}";
 
 //End points for pet modules
}
