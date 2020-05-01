
public class Merch {
//---------------------------------data field
	String name;
	int UPC;
	int LOT;
	double price;
	int onHand;
	
//-------------------------------method field

	//constructor method
	public Merch() {
		name = "";
		UPC = 0;
		LOT = 0;
		price = 0.00;
		onHand = 0;
	}
	
/**********************************************************************/
	
	//constructor method
	public Merch(String name, int UPC, int LOT, double price, int onHand) {
		this.name = name;
		this.UPC = UPC;
		this.LOT = LOT;
		this.price = price;
		this.onHand = onHand;
	}
	
/***********************************************************************/
	
	//increase quantity of an item
	public void addQty(int amount) {
		this.onHand += amount; 
	}
	
/************************************************************************/
	
	//decrease quantity of an item
	public void removeQty(int amount) {
		this.onHand -= amount;
	}
	
/************************************************************************/	

	//get name of item
	public String getName() {
		return this.name;
	}
	
/*************************************************************************/
	
	//get UPC of item
	public int getUPC() {
		return this.UPC;
	}
	
/**************************************************************************/
	
	//get LOT of item
	public int getLOT() {
		return this.LOT;
	}
	
	
/**************************************************************************/
	
	//get Price of item
	public double getPrice() {
		return this.price;
	}
	
/**************************************************************************/
	
	//get quantity of item
	public int getOnHand() {
		return this.onHand;
	}
}
