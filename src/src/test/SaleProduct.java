package test;
public class SaleProduct 
{
	
	
		
		/**
		 * simple constructor
		 */
		SaleProduct ()
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
		SaleProduct(int pid, String name, double price, int qty)
		{
			this.pid = pid;
			this.name = name;
			this.price = price;
			this.qty = qty;

			
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
		 * assigns the quantity of a product
		 * @param qty quantity of product
		 */
		public void changeQty(int qty)
		{
			this.qty =qty;
		}
		

		

		
		

		public int pid;
		public String name;
		public int qty;
		public double price;

	}


