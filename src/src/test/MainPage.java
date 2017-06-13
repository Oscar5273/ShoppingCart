package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
	
/**
 * Main Class where the main page is created
 * @author Oscar Vasquez
 * Test
 */
public class MainPage {

	static JFrame frame;
	static Seller s=new Seller();
	static Buyer b;
    static Border border2=BorderFactory.createRaisedSoftBevelBorder();
    static GridLayout experimentLayout = new GridLayout(0,1);

	/**
	 * Sets up the JPanel that displays the products for sale for the buyer
	 * @param panel: Where items for sale will be added
	 * @param panel2: Side panel so that it can be repainted
	 * @author Oscar Vasquez
	 */  
public static void buyerPanelArray(JPanel panel,JPanel panel2){
	for(int i=0;i<s.itemSales.inventory.size();i++){
		String str1=String.format(s.itemSales.getProductName(i));
		String str2="Sales Price: $";
		str2+=String.format( "%.2f", s.itemSales.getProductSalesPrice(i));
		String str3="Product Qty: ";
		str3+=Integer.toString(s.itemSales.getProductQty(i));
		addNewBPanel(panel,panel2,str1,str2,str3,i);
}
}
/**
 * Sets up the JPanel that displays the products the seller has up for sale
 * @param panel: Where sellers products will be added
 * @param panel2: Side panel so that it can be repainted
 * @author Oscar Vasquez
 */
public static void sellerPanelArray(JPanel panel,JPanel panel2){
 
    JPanel p4=new JPanel();
    JButton b3=new JButton("Add Product");
    for(int i=0;i<s.itemSales.inventory.size();i++){
    	String str1="Product Cost: $";
    	str1+=String.format( "%.2f", s.itemSales.getProductCost(i));
    	String str2="Sales Price: $";
    	str2+=String.format( "%.2f", s.itemSales.getProductSalesPrice(i));
    	String str3="Product Qty: ";
    	str3+=Integer.toString(s.itemSales.getProductQty(i));
    	addNewSPanel(p4,panel,s.itemSales.getProductName(i),str1,str2,str3,i);
    }


	JLabel l[]=new JLabel[5];
	JTextField textField[]=new JTextField[4];
    String[] labels = {"Product Name: ", "Product Price: ", "Quantity: "};
    int numPairs = labels.length;
    GridLayout experimentLayout2 = new GridLayout(0,1);
    JPanel p = new JPanel(experimentLayout2);
   for (int i = 0; i < numPairs; i++) {
        l[i] = new JLabel(labels[i]);
        p.add(l[i],BorderLayout.NORTH);
        textField[i] = new JTextField(1);
        textField[i].setName("field"+i);
        l[i].setLabelFor(textField[i]);
        p.add(textField[i],BorderLayout.NORTH);
    }
    l[3] = new JLabel("Product Description");
    p.add(l[3],BorderLayout.NORTH);
    JTextArea textArea = new JTextArea(1,1);
    l[3].setLabelFor(textArea);
    Border grayline = BorderFactory.createLineBorder(Color.gray);
    textArea.setBorder(grayline);
    p.add(textArea,BorderLayout.NORTH);
    p.add(b3,BorderLayout.SOUTH);
	panel2.add(p,BorderLayout.SOUTH);
	/**
	 * Sets up action listener for add to product class, repaints panel to update new balance
	 * @author Oscar Vasquez
	 */
    b3.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e)
         {
//             //Execute when button is pressed
     		Product prod=new Product(0,textField[0].getText() ,Double.parseDouble(textField[1].getText()),
   				 Integer.parseInt(textField[2].getText()),textArea.getText(),
   				Double.parseDouble(textField[1].getText()));
     		s.addNewProduct(prod);
     		int x=s.itemSales.inventory.size();
			String str1="Product Cost: $";
			str1+=String.format( "%.2f", s.itemSales.getProductCost(x));
			String str2="Sales Price: $";
			str2+=String.format( "%.2f", s.itemSales.getProductSalesPrice(x));
			String str3="Product Qty: ";
			str3+=Integer.toString(s.itemSales.getProductQty(x));
			addNewSPanel(p4,panel,s.itemSales.getProductName(x),str1,str2,str3,x-1);
             
             frame.validate();
             frame.repaint();
         
         }
     });

}
/**
 * Add the JPanel that contains the product information for the seller
 * @param p4: Where sellers products will be added
 * @param panel: Side panel so that it can be repainted
 * @param s1: Product Name
 * @param s2: Product Cost
 * @param s3: Product Sales Price
 * @param s4: Product Quantity
 * @param x: Product id
 * @author Oscar Vasquez
 */
public static void addNewSPanel(JPanel p4,JPanel panel,String s1,String s2,String s3,String s4,int x){

    JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	
	SpinnerModel model =new SpinnerNumberModel(0,0,100,1); 
	JSpinner spin=new JSpinner(model);
	JLabel l=new JLabel(s1);
	JLabel l2=new JLabel(s2);
	JLabel l3=new JLabel(s3);
	JLabel l4=new JLabel(s4);
    JButton b1=new JButton("Edit");
    JButton b2=new JButton("Delete");
    
    b2.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e)
         {
             //Execute when button is pressed
			 p1.setVisible(false);
             s.itemSales.remove(x);
             panel.remove(p1);          
         }
     });
    b1.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e)
         {
             //Execute when button is pressed
              s.itemSales.UpdateQuantity(s.itemSales.getProductId(x), (int) model.getValue());
              panel.removeAll();
              for(int i=0;i<s.itemSales.inventory.size();i++){
            	  int id=s.itemSales.inventory.get(i).getPid();
              	String str1="Product Cost: $";
              	str1+=String.format( "%.2f", s.itemSales.inventory.get(i).getCost());
              	String str2="Sales Price: $";
              	str2+=String.format( "%.2f", s.itemSales.inventory.get(i).getSalesPrice());
              	String str3="Product Qty: ";
              	str3+=Integer.toString(s.itemSales.inventory.get(i).getQty());
              	String str4=s.itemSales.inventory.get(i).getName();
              	addNewSPanel(p4,panel,str4,str1,str2,str3,id);
              	frame.validate();
              	frame.repaint();
              }
              
         }
     });
    b1.setName("test");
    b2.setName("delete");
    p1.setBorder(border2);
    p1.setLayout(new BorderLayout());
    p4.setLayout(new BorderLayout());
    p3.setLayout(experimentLayout);
    p3.add(l);
    p3.add(l2);
    p3.add(l3);
    p3.add(l4);
    p2.add(spin);
    p2.add(b1);
    p2.add(b2);
    p1.add(p3,BorderLayout.CENTER);
    p1.add(p2,BorderLayout.SOUTH);
    panel.add(p1,BorderLayout.CENTER);
}
/**
 * Add the JPanel that contains the product information for the buyer
 * @param p4: Where sellers products will be added
 * @param panel: Side panel so that it can be repainted
 * @param s1: Product Name
 * @param s2: Product Cost
 * @param s3: Product Quantity
 * @param x: Product id
 * @author Oscar Vasquez
 */
public static void addNewBPanel(JPanel panel,JPanel panel2,String s1,String s2,String s3,int x){
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JLabel l1=new JLabel(s1);
	JLabel l2=new JLabel(s2);
	JLabel l3=new JLabel(s3);
    JButton b1=new JButton("Add To Cart");
    JButton b2=new JButton("More Info");
    b2.setName("Product "+x);
    b2.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e)
         {
			 //Execute when button is pressed
			 InfoFrame info=new InfoFrame(s.itemSales.getProductDesc(x));      
         }
     });
    
    b1.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		SaleProduct a=new SaleProduct(x,s.itemSales.getProductName(x),
    		s.itemSales.getProductSalesPrice(x),1);
    		b.cart.addNewProduct(a,s,x);
    		panel2.removeAll();
			addNewSidePanelBuyer(panel2);
			frame.validate();
			frame.repaint();

    	}
    });
    b1.setName("test"+x);
    p1.setBorder(border2);
    p1.setLayout(new BorderLayout());
    p3.setLayout(experimentLayout);
    p3.add(l1);
    p3.add(l2);
    p3.add(l3);
    p2.add(b1);
    p2.add(b2);
    p1.add(p3,BorderLayout.WEST);
    p1.add(p2,BorderLayout.SOUTH);
    panel.add(p1,experimentLayout);
    b1.addActionListener(ButtonListener);
}
/**
 * Calls the addNewSidePanelBuyer method for panel
 * @param panel: Where panel will be added
 * @author Oscar Vasquez
 */
public static void setBuyerSidePanel(JPanel panel){

    addNewSidePanelBuyer(panel);

}
/**
 * Add the JPanel that contains the product information for the buyer
 * @param panel: Panel where new JPanel will be added
 * @author Oscar Vasquez
 */
public static void addNewSidePanelBuyer(JPanel panel){
	GridLayout experimentLayout = new GridLayout(0,1); 
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JLabel l=new JLabel("Shopping Cart");
	JLabel l2=new JLabel("Balance: $"+String.format( "%.2f",b.cart.getTotalBalance()));
    JButton b1=new JButton("Go To Cart");
    b1.setName("goToCart");
    JButton b2=new JButton("Logout");
    b2.setName("logout");
    p1.setLayout(new BorderLayout());
    p2.setLayout(experimentLayout);
    p1.add(l,BorderLayout.NORTH);
    p2.add(l2);
    p2.add(b1);
    p1.add(p2);
    p1.add(b2,BorderLayout.SOUTH);
    addImage(panel);
    b1.addActionListener(new ActionListener(){
	@Override
		public void actionPerformed(ActionEvent arg0) {
				CheckoutCart c=new CheckoutCart(b,frame,s);
				frame.setVisible(false);
				if(frame.isVisible()==true){
		    		panel.removeAll();
					addNewSidePanelBuyer(panel);
					frame.validate();
					frame.repaint();
				}
			
		}
    	
    });
    b2.addActionListener(ButtonListener);
    panel.add(p1);
}
/**
 * Add the JPanel that contains the product information for the seller
 * @param panel: Panel where new JPanel will be added
 * @author Oscar Vasquez
 */
public static void setSellerSidePanel(JPanel panel){
	GridLayout experimentLayout = new GridLayout(0,1); 
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JLabel l=new JLabel("Seller Menu");
	Font f=l.getFont();
	l.setFont(new Font(f.getFontName(), Font.PLAIN, 25));
	JLabel l2=new JLabel("Profit: $0.00");
	JLabel l3=new JLabel("Revenue: $0.00");
	JLabel l4=new JLabel("Costs: $0.00");
    JButton b1=new JButton("Logout");
    b1.setName("logout");
    p1.setLayout(new BorderLayout());
    p3.setLayout(new BorderLayout());
    p2.setLayout(experimentLayout); 
    p1.add(l,BorderLayout.NORTH);
    p2.add(l2);
    p2.add(l3);
    p2.add(l4);
    p1.add(p2,BorderLayout.CENTER);
    p3.add(p1,BorderLayout.CENTER);
    p3.add(b1,BorderLayout.SOUTH);
    panel.add(p3);
    b1.addActionListener(ButtonListener);
}
/**
 * Adds an image to the specified JPanel
 * @param panel: Panel where new image will be added
 * @author Oscar Vasquez
 */
public static void addImage(JPanel panel){
	ImageIcon image = null;
	try{
		image= new ImageIcon("scart.png");
	}
	catch(Exception e){
		
	}
	JLabel picLabel= new JLabel("",image,JLabel.CENTER);
	panel.add(picLabel);
}
/**
 * Action listener to logout the user and open login view
 * @author Oscar Vasquez
 */
static ActionListener ButtonListener = new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
		JButton source = (JButton) e.getSource();
		if(source.getName()=="logout"){
			LoginView n=new LoginView();
			n.main(null);
			frame.dispose();
			}}
	};



	
	
	public static void main(String[] args,String x,String y){
		//args=new String[1];
		//args[0]="b";
		b=new Buyer(x,y);
		if(args.length!=0) {
		if(args[0]=="b"){
				frame = new JFrame();
		       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		       GridLayout experimentLayout = new GridLayout(0,2);
		       JPanel p=new JPanel();
		       Border blackline = BorderFactory.createLineBorder(Color.black);
		       p.setBorder(blackline);
		       JPanel p2=new JPanel();
		       p2.setLayout(experimentLayout);
		       buyerPanelArray(p2,p);
		       p2.setBorder(blackline);
		       JScrollPane p3 = new JScrollPane(p2);
		       p3.setSize(new Dimension(425, 80));
		       setBuyerSidePanel(p);
		       frame.setResizable(false);
		       p.setMaximumSize(new Dimension(625,500));
		       frame.add(p,BorderLayout.CENTER);
		       frame.add(p3,BorderLayout.WEST);
		       frame.setSize(650,600);
		       frame.setLocationRelativeTo(null);
		       frame.setVisible(true);
		       
		}
		else if(args[0]=="s"){
			   frame = new JFrame();
			   frame.setLocationRelativeTo(null);
		       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		       GridLayout experimentLayout = new GridLayout(0,2);
		       JPanel p=new JPanel();
		       Border blackline = BorderFactory.createLineBorder(Color.black);
		       p.setBorder(blackline);
		       JPanel p2=new JPanel();
		       JPanel p4=new JPanel();
		       p4.setLayout(new BorderLayout());
		       p2.setLayout(experimentLayout);
		       sellerPanelArray(p2,p4);
		       p2.setBorder(blackline);
		       JScrollPane p3 = new JScrollPane(p2);
		       p.setLayout(new BorderLayout());
		       p4.add(p3,BorderLayout.CENTER);

		       setSellerSidePanel(p);
		       frame.add(p,BorderLayout.CENTER);
		       frame.add(p4,BorderLayout.WEST);
		       frame.setSize(675,600);
		       frame.setVisible(true);
		}
		}

	}
}
