package dispnsible;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ChactingProgram.MyTextPane;

public class MMM extends JPanel{

	
	JButton bt;
	JPanel papa;
	JLabel lalala;
	public MMM(GridBagConstraints c) {
		

		JPanel ppp = new JPanel();

		ppp.setPreferredSize(new Dimension(60 ,60));
		ppp.setBackground(Color.BLUE);
		if (true) {
			c.fill = GridBagConstraints.WEST;
			c.weightx = 0;
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		add(ppp, c);

		papa = new JPanel(new BorderLayout());
		lalala = new JLabel("?‚œ?‚˜?•¼");
		papa.add(lalala, BorderLayout.NORTH);
		papa.setBackground(Color.RED);
		papa.setPreferredSize(new Dimension(50 ,50));
		//c.fill = GridBagConstraints.NORTH;
		c.weightx = 0;
		c.gridx = 1;
		c.gridy = 0;
		add(papa, c);
		
		papa = new JPanel(new BorderLayout());
		MyTextPane textPane = new MyTextPane(true, "dd4",true);
		papa.add(textPane, BorderLayout.CENTER);
		papa.setBackground(Color.yellow);
		papa.setPreferredSize(new Dimension(50 ,50));
		//c.fill = GridBagConstraints.NORTH;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		add(papa, c);
		
		papa = new JPanel(new BorderLayout());
		papa.setBackground(Color.GRAY);
		lalala = new JLabel("?‹œê°?");
		lalala.setBackground(Color.RED);
		papa.add(lalala, BorderLayout.SOUTH);
		papa.setPreferredSize(new Dimension(50 ,50));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.gridx = 3;
		c.gridy = 0;
		add(papa, c);
		
		JPanel pppp = new JPanel();
		pppp.setPreferredSize(new Dimension(60 ,60));
		pppp.setBackground(Color.BLUE);
		if (true) {
			c.fill = GridBagConstraints.WEST;
			c.weightx = 0;
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		add(pppp, c);
		
	}
	
}
