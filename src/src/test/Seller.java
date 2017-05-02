package test;

public class Seller 
{
	/**
	 * Instantiates the products for the seller to sell and add them to the inventory.
	 */
	Seller()
	{
		Product p1=new Product(0,"Cookies",3.99,10,"Delicious Chocolate Chip cookies,pack of 6",3.99);
		itemSales.addNewProduct(p1);
		Product p2=new Product(1,"Bread",6.99,10,"Low calorie whole wheat break,pack of 12",6.99);
		itemSales.addNewProduct(p2);
		Product p3=new Product(2,"Milk",4.99,10,"Silky smooth 2% milk,1 gallon",4.99);
		itemSales.addNewProduct(p3);
		Product p4=new Product(3,"Cheese",3.99,10,"12 slices of delicious provolone cheese",3.99);
		itemSales.addNewProduct(p4);
		Product p5=new Product(4,"Soda",2.99,10,"Bubbly Coca Cola, 1 liter",2.99);
		itemSales.addNewProduct(p5);
		Product p6=new Product(5,"Candy bar",0.99,10,"Hershey candy bar",0.99);
		itemSales.addNewProduct(p6);
		Product p7=new Product(6,"Eggs",5.99,10,"A dozen large eggs",5.99);
		itemSales.addNewProduct(p7);
		Product p8=new Product(7,"T-Shirt",15.99,10,"Collectable Game of Thrones T-Shirt, Size X-large",15.99);
		itemSales.addNewProduct(p8);
		
	}
	
	
	public void completeClientOrder(/*Shopping cart order*/)
	{
		//processes what the buyer bought and maybe return as a receipt
	}
	/**
	 * adds a new product to the item inventory 
	 * @param a new product
	 */
	public void addNewProduct(Product a)
	{
		itemSales.addNewProduct(a);
	}
	
	/**
	 * prints the inventory list
	 */
	public void printInven()
	{
		itemSales.printInven();
	}
	
	/**
	 * updates the name of product
	 * @param pname: old product name 
	 * @param name: new product name
	 */
	public void updateName(int pid, String name)
	{
		itemSales.setProductName(pid ,name);
	}
	
	/**
	 * update product price
	 * @param pname: product name
	 * @param price: product new price
	 */
	public void updatePrice(int pid, double price)
	{
		itemSales.setProductPrice(pid, price);
	}
	
	/**
	 * update cost of product
	 * @param pname: name of product
	 * @param cost: new cost of product
	 */
	public void updateCost(int pid, double cost)
	{
		itemSales.setProductCost(pid, cost);
	}
	
	/**
	 * update description of product
	 * @param pname: product name
	 * @param desc: new product description
	 */
	public void updateDesc(int pid, String desc)
	{
		itemSales.setProductDesc(pid, desc);
	}
	
	/**
	 * update the quantity of product for one product
	 * @param pname: product name
	 * @param qty: how much more product has been bought
	 */
	public void updateQty(int pid, int qty)
	{
		
		itemSales.UpdateQuantity(pid, qty);
	}
	
	/**
	 * deletes a product out of the inventory 
	 * @param pname: product's name
	 */
	public void remove(int pid)
	{
		System.out.println("Here");
		itemSales.remove(pid);
	}
	
	/**
	 * calculates the amount of money that was made after a transaction
	 */
	public void calcProfit()
	{
		//
	}
	
	/**
	 * calcualtes the total cost of the entire inventory stock
	 * @return
	 */
	public double totalCost()
	{
		return total_cost = itemSales.totalCost();
	}
	
	private double profit;
	private double total_cost;
	 Inventory itemSales = new Inventory();
	public static void main(String[] args){
		Seller s= new Seller();
		s.printInven();
	}
}