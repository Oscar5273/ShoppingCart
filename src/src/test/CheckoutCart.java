package test;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
/**
 * New JFrame that contains contents of shopping cart
 * @author Oscar Vasquez
 */
public class CheckoutCart {
	static GridLayout experimentLayout = new GridLayout(0,1);
	/**
	 * Sets up the new JFrame
	 * @param b: Buyer class to get buyer info
	 * @param frame1: Original jframe to set visible when done
	 * @param s: Seller class to get max quantity info
	 * @author Oscar Vasquez
	 */
public CheckoutCart(Buyer b,JFrame frame1,Seller s){
			JFrame frame=new JFrame();
			frame.setLayout(new BorderLayout());
			JPanel p =new JPanel();;
			JPanel p2=new JPanel();
			JTextField[] f3= new JTextField[b.cart.cart.size()];
			p2.setLayout(experimentLayout);
			for(int i=0;i<b.cart.cart.size();i++){
				setFrame(p2,f3,b,i);
			}
			JLabel l1=new JLabel("Balance: $"+String.format( "%.2f",b.cart.getTotalBalance()));
			JLabel l2=new JLabel("Addresss: "+b.address);
			JLabel l3=new JLabel("Credit Card #: "+b.creditCard);
			JLabel l4=new JLabel("Shipping: Free!");
			p2.add(l1);
			p2.add(l2);
			p2.add(l3);
			p2.add(l4);
			JScrollPane p3=new JScrollPane(p2);
			JPanel p4=new JPanel();
			p4.setLayout(new BorderLayout());
			JButton b1=new JButton("Update");
			JButton b2=new JButton("Checkout");
			JButton b3=new JButton("Close");
			p.setLayout(new BorderLayout());
			p4.add(p3,BorderLayout.CENTER);
			p4.add(b1,BorderLayout.SOUTH);
			p.add(b3,BorderLayout.SOUTH);
			p.add(p4,BorderLayout.CENTER);
			frame.add(p,BorderLayout.CENTER);
			frame.add(b2,BorderLayout.SOUTH);
			frame.setVisible(true);
			frame.setSize(350, 500);
			b1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					for(int i=0;i<b.cart.cart.size();i++){
						boolean toBig=false;
						for(int j=0;j<s.itemSales.inventory.size();j++){
							if(s.itemSales.inventory.get(j).name==b.cart.cart.get(i).name){
								if(s.itemSales.inventory.get(j).qty<Integer.parseInt(f3[i].getText())){
									b.cart.ChangeQuantity(i, s.itemSales.inventory.get(j).qty);
									toBig=true;
								}
							}
							
						}
						if(toBig==false)
						b.cart.ChangeQuantity(i, Integer.parseInt(f3[i].getText()));
					}
					p2.removeAll();
					for(int i=0;i<b.cart.cart.size();i++){
						setFrame(p2,f3,b,i);
					}
					JLabel l1=new JLabel("Balance: $"+String.format( "%.2f",b.cart.getTotalBalance()));
					JLabel l2=new JLabel("Addresss: "+b.address);
					JLabel l3=new JLabel("Credit Card #: "+b.creditCard);
					JLabel l4=new JLabel("Shipping: Free!");
					p2.add(l1);
					p2.add(l2);
					p2.add(l3);
					p2.add(l4);
					frame.validate();
					frame.repaint();
				}
				
			});
			b2.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,"Order Completed!");
					b.cart=new ShoppingCart();
					frame.setVisible(false);
					frame1.setVisible(true);
				}
				
			});
			b3.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					frame1.setVisible(true);
				}
				
			});
		}
/**
 * Repaints shopping cart when update is made
 * @author Oscar Vasquez
 */
public void setFrame(JPanel p2,JTextField[] f3,Buyer b,int i){
			JPanel p=new JPanel();
			JLabel l1=new JLabel("Product: ");
			JTextField f1=new JTextField();
			f1.setEditable(false);
			f1.setText(b.cart.getProductName(i));
			JLabel l2=new JLabel("Price: $");
			JTextField f2=new JTextField();
			f2.setEditable(false);
			f2.setText(String.format( "%.2f",b.cart.getProductPrice(i)));
			JLabel l3=new JLabel("Qty: ");
			f3[i]=new JTextField(3);
			f3[i].setText(Integer.toString(b.cart.getProductQty(i)));
			p.add(l1);
			p.add(f1);
			p.add(l2);
			p.add(f2);
			p.add(l3);
			p.add(f3[i]);
			p2.add(p);
			
		}
		
}
