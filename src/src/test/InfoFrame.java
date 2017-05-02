package test;

import java.awt.TextArea;


import javax.swing.JFrame;
/**
 * New JFrame with info on a product
 * @author Oscar Vasquez
 */
public class InfoFrame{
	/**
	 * Creates a new JFrame displaying Description of a product
	 * @param s: String containing the description of a product
	 * @author Oscar Vasquez
	 */
	public InfoFrame(String s){
		JFrame iframe= new JFrame();
	       TextArea field=new TextArea();
	       field.append(s);
	       field.setEditable(false);
	       iframe.add(field);
		   iframe.setSize(300,150);
	       iframe.setVisible(true);
	}

}
