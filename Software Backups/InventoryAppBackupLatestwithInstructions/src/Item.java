
public class Item {

	private String itemID;
	private String itemName;
	private String quantity;
	private String price;
	private String itemDescription;
	
	
	public Item(){
		
	}
	
	public Item(String id,String name,String quantity, String price, String description){
		this.itemID = id;
		this.itemName = name;
		this.quantity = quantity;
		this.price = price;
		this.itemDescription = description;
	}
	
	
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	
}
