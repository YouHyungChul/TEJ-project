package ChactingProgram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PageChat extends PagePrimary{
	ChatApp chatApp;
	String title;
	int width;
	int height;
	Color color;
	boolean showFlag;
	


	
	public PageChat(ChatApp chatApp,String title,int width, int height, Color color, boolean showFlag ) {

		this.chatApp = chatApp;
		this.title = title;
		this.width = width;
		this.height = height;
		this.color =  color;
		this.showFlag = showFlag;
		

		

		
		
		setLayout(new BorderLayout());
		this.setBackground(color);
		this.setPreferredSize(new Dimension(width,height));
		this.setVisible(this.showFlag);
	}
	
}
