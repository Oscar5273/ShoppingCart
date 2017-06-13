package test;

public class Buyer 
{
	public ShoppingCart cart = new ShoppingCart();
	String address;
	String creditCard;
	
	/**
	 * Creates a new Buyer 
	 */
	public Buyer(String address,String creditCard)
	{
		this.address= address;
		this.creditCard = creditCard;
	}
	/**
	 * Creates a new Buyer 
	 */
	public Buyer()
	{
		this.address= "4980 nw 99th street, Boca Raton FL";
		this.creditCard = "23443435556";
	}
	
}
