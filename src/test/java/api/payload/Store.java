package api.payload;
/*{
    "id": 200000,
    "petId": 10,
    "quantity": 0,
    "shipDate": "2024-07-16T06:20:34.651+0000",
    "status": "placed",
    "complete": true
}
*/
public class Store {
int id,petId, quantity;
String shipDate,status;
boolean complete;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getPetId() {
	return petId;
}
public void setPetId(int petId) {
	this.petId = petId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getShipDate() {
	return shipDate;
}
public void setShipDate(String shipDate) {
	this.shipDate = shipDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public boolean isComplete() {
	return complete;
}
public void setComplete(boolean complete) {
	this.complete = complete;
}
}
