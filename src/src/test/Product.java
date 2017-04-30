package test;

import java.text.DecimalFormat;



public class Product extends Inventory
{	
	
	
	Product ()
	{
		
		
	}
	
	/**
	 * Product Constructor that assigns the id, name, price, quantity, description, cost, and calculates the salesprice of the product
	 * @param pid: id of product
	 * @param name: name of product
	 * @param price: price of product
	 * @param qty: quantity of product
	 * @param desc: description of product
	 * @param cost: cost of product
	 */
	Product(int pid, String name, double price, int qty, String desc, double cost)
	{
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.desc = desc;
		this.cost = cost;
		this.salesprice = price + (price * 0.06);

		
	}
	/**
	 * gets the product id
	 * @return product id
	 */
	public int getPid()
	{
		return pid;
	}
	
	/**
	 * This just gets the price of the product
	 * @return: the price of the specific product is returned
	 */
	public double getPrice()
	{
		return price;
	}
	
	/**
	 * gets the name of product
	 * @return product's name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * gets the quantity of product
	 * @return quantity of product
	 */
	public int getQty()
	{
		return qty;
	}
	
	/**
	 * gets the cost of product
	 * @return product's cost
	 */
	public double getCost()
	{
		return cost;
	}
	
	/**
	 * gets the description of product
	 * @return product's description
	 */
	public String getDesc()
	{
		return desc;
	}
	
	/**
	 * gets the sales price of product
	 * @return product's sales price
	 */
	public double getSalesPrice()
	{
		return salesprice;
	}
	
	/**
	 * assigns the product ID
	 * @param pid product ID
	 */
	public void setPid(int pid)
	{
		this.pid = pid;
	}
	
	/**
	 * assigns the price and calculates the sales price of product
	 * @param price product's price
	 */
	public void setPrice(double price)
	{
		this.price = price;
		salesprice = price + (price * 0.06);
	}
	
	/**
	 * assigns the name of product
	 * @param name product's name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * assigns the quantity of a product
	 * @param qty quantity of product
	 */
	public void setQty(int qty)
	{
		this.qty = this.qty + qty;
	}
	
	/**
	 * assigns the description of a product
	 * @param desc product's description
	 */
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	
	/**
	 * assigns the cost of the product
	 * @param cost product's cost
	 */
	public void setCost(double cost)
	{
		this.cost = cost;
	}
	
	/**
	 * calculates the discount on a product
	 * @param discount product discount
	 
	public void Discount(double discount)
	{
		if (discount > 0)
		{
			salesprice = salesprice - (salesprice * discount);
		}
		else
		{
			
		}
	}
	*/
	
	public double cost;
	public int pid;
	public String name;
	public double price;
	public int qty;
	public double salesprice;
	public String desc;
}
