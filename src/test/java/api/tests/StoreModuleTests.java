package api.tests;

import org.testng.annotations.BeforeTest;

import com.github.javafaker.Faker;

import api.payload.Store;

public class StoreModuleTests {
	Faker faker;
	Store storepayload;
	@BeforeTest
public void setup() {
		faker=new Faker();
		storepayload=new Store();
		storepayload.setId(faker.idNumber().hashCode());
		storepayload.setPetId(faker.idNumber().hashCode());
		
}
}
