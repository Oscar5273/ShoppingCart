package test;

import java.util.LinkedList;
import java.util.ListIterator;

public class Inventory 
{
	/**
	 * Assigns the first product id to be zero
	 */
	Inventory()
	{
		pid = 0;
	}
	
	/**
	 * returns the product ID
	 * @param pname: product's name
	 * @return product's ID
	 */
	public int getProductId(int pid)
	{
		return findProduct(pid);
	}
	
	/**
	 * returns the products name
	 * @param pname: products name
	 * @return product's name
	 */
	public String getProductName(int pid)
	{
		return inventory.get(findProduct(pid)).getName();
	}
	
	/**
	 * returns the product's cost
	 * @param pname: product's name
	 * @return product's cost
	 */
	public double getProductCost(int pid)
	{
		return inventory.get(findProduct(pid)).getCost();
	}
	
	/**
	 * returns the product's price
	 * @param pname: product's name
	 * @return product's price
	 */
	public double getProductPrice(int pid)
	{
		return inventory.get(findProduct(pid)).getPrice();
	}
	
	/**
	 * returns the product's sales price
	 * @param pname:product's name
	 * @return product's sales price
	 */
	public double getProductSalesPrice(int pid)
	{

		return inventory.get(findProduct(pid)).getSalesPrice();
	}
	
	/**
	 * returns the product's description
	 * @param pname: product's name
	 * @return product's description
	 */
	public String getProductDesc(int pid)
	{

		return inventory.get(findProduct(pid)).getDesc();
	}
	
	/**
	 * returns the product's quantity 
	 * @param pname: product's name
	 * @return product's quantity
	 */
	public int getProductQty(int pid)
	{

		return inventory.get(findProduct(pid)).getQty();
	}
	
	/**
	 * add a new product
	 * @param a: product object
	 */
	public void addNewProduct(Product a)
	{
		a.setPid(pid);
		inventory.add(a);
		pid = pid + 1;
	}
	
	/**
	 * updates the product's name
	 * @param pname: old product name
	 * @param name: new product name
	 */
	public void setProductName(int pid, String name)
	{
		inventory.get(findProduct(pid)).setName(name);
	}
	
	/**
	 * updates the product's price
	 * @param pname: product's name
	 * @param price: product's new price
	 */
	public void setProductPrice(int pid, double price)
	{
		inventory.get(findProduct(pid)).setPrice(price);
	}
	
	/**
	 * updates the product's cost
	 * @param pname: product's name
	 * @param cost: product's new cost
	 */
	public void setProductCost(int pid, double cost)
	{
		inventory.get(findProduct(pid)).setCost(cost);
	}
	
	/**
	 * updates the product's description
	 * @param pname: product's name
	 * @param desc: product's new description
	 */
	public void setProductDesc(int pid, String desc)
	{
		inventory.get(findProduct(pid)).setDesc(desc);
	}
	
	/**
	 * Prints out a list of products in the inventory
	 */
	public void printInven()
	{
		ListIterator<Product> listIterator = inventory.listIterator();
		int i = 0;
		while(listIterator.hasNext() && i != inventory.size())
		{
			System.out.println("Product ID: "+ inventory.get(i).getPid() + 
					" Product Name: "+ inventory.get(i).getName() + 
					" Product Price: " + inventory.get(i).getPrice() + 
					" Quantity: " + inventory.get(i).getQty() +
					" Description: " + inventory.get(i).getDesc() + 
					" Sales Price: " + String.format( "%.2f", inventory.get(i).getSalesPrice() ) + "\n");
			i++;
		}
	}
	
	/**
	 * updates the quantity of product
	 * @param pname: product's name
	 * @param qty: added quantity
	 */
	public void UpdateQuantity(int pid, int qty)
	{
		inventory.get(pid).setQty(qty);
	}
	
	/**
	 * finds the product using its unique name
	 * @param pname: product's name
	 * @return the product's ID
	 */
	public int findProduct(int pid)
	{
		ListIterator<Product> listIterator = inventory.listIterator();
		int id = 0;
		while(listIterator.hasNext())
		{
			if (pid == inventory.get(id).getPid())
			{
				return id;
			}
			else
			{
				id++;
			}
		}
		return -1;
	}
	
	
	/**
	 * deletes a product from the inventory list
	 * @param pname: product name
	 */
	public void remove(int pid)
	{
		inventory.remove(findProduct(pid));
	}
	
	public double totalCost()
	{
		ListIterator<Product> listIterator = inventory.listIterator();
		int id = 0;
		while(listIterator.hasNext() && id != inventory.size())
		{
			total_cost = total_cost + (inventory.get(id).getCost() * inventory.get(id).getQty());
		}
		return total_cost;
	}

	public int pid;
	public double total_cost;
	public LinkedList<Product> inventory = new LinkedList<Product>();
}
