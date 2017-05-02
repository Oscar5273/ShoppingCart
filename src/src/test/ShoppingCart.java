package test;

import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JOptionPane;
public class ShoppingCart 
{
		ShoppingCart()
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
			return findProductbyId(pid);
		}
		
		/**
		 * returns the products name
		 * @param pname: products name
		 * @return product's name
		 */
		public String getProductName(int pid)
		{
			return cart.get(findProductbyId(pid)).getName();
		}
		
		/**
		 * returns the product's price
		 * @param pname: product's name
		 * @return product's price
		 */
		public double getProductPrice(int pid)
		{
			return cart.get(findProductbyId(pid)).getPrice();
		}
		
		
		/**
		 * returns the product's quantity 
		 * @param pname: product's name
		 * @return product's quantity
		 */
		public int getProductQty(int pid)
		{
			return cart.get(findProductbyId(pid)).getQty();
		}
		
		/**
		 * add a new product
		 * @param a: product object
		 */
		public void addNewProduct(SaleProduct a,Seller s,int x)
		{
			a.setPid(pid);
			boolean there=false;
			for(int i=0;i<cart.size();i++)			{
				if (a.name==cart.get(i).getName())
				{	
					if(cart.get(i).getQty()<s.itemSales.getProductQty(x)){
						UpdateQuantity(i,a.getQty());
						there=true;
					}
					else{
						JOptionPane.showMessageDialog(null,"You have reasched the max amount of quantity");
						there=true;
					}
				}
			}
			if(there==false){
			cart.add(a);
			pid = pid + 1;}
		}
		
		/**
		 * updates the product's name
		 * @param pname: old product name
		 * @param name: new product name
		 */
		public void setProductName(int pid, String name)
		{
			cart.get(findProductbyId(pid)).setName(name);
		}
		
		/**
		 * updates the product's price
		 * @param pname: product's name
		 * @param price: product's new price
		 */
		public void setProductPrice(int pid, double price)
		{
			cart.get(findProductbyId(pid)).setPrice(price);
		}
		
		
		/**
		 * Prints out a list of products in the inventory
		 */
		public void printInven()
		{
			ListIterator<SaleProduct> listIterator = cart.listIterator();
			int i = 0;
			while(listIterator.hasNext() && i != cart.size())
			{
				System.out.println("Product ID: "+ cart.get(i).getPid() + 
						" Product Name: "+ cart.get(i).getName() + 
						" Product Price: " + cart.get(i).getPrice() + 
						" Quantity: " + cart.get(i).getQty() +"\n");
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
			cart.get(pid).setQty(qty);
		}
		/**
		 * updates the quantity of product
		 * @param pname: product's name
		 * @param qty: added quantity
		 */
		public void ChangeQuantity(int pid, int qty)
		{
			cart.get(pid).changeQty(qty);
		}
		
		/**
		 * finds the product using its unique name
		 * @param pname: product's name
		 * @return the product's ID
		 */
		public int findProductbyId(int pid)
		{
			ListIterator<SaleProduct> listIterator = cart.listIterator();
			int id = 0;
			while(listIterator.hasNext())
			{
				if (pid == cart.get(id).getPid())
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
			cart.remove(findProductbyId(pid));
		}
		
		public double getTotalBalance()
		{
			double x=0;
			balance=0;
			for(int i=0;i<cart.size();i++){
				 x=cart.get(i).price*cart.get(i).qty;
				 balance+=x;
				
			}
			return balance;
		}

		public int pid;
		public double total_cost;
		public double balance;
		public LinkedList<SaleProduct> cart = new LinkedList<SaleProduct>();
	

}
