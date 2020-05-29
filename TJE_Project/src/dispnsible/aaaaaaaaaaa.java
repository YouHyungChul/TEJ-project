package dispnsible;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import ChactingProgram.MyChatContentPanel;
import ChactingProgram.MyTextPane;

public class aaaaaaaaaaa extends JFrame {

	JButton bt;
	JPanel papa;
	JLabel lalala;
	
	
	
	
	MyChatContentPanel p_content;
	JPanel p_south;
	JScrollPane scroll;
	JTextField t_input;
	JTextArea area;
	JButton bt_input;
	MyTextPane textPane;
	boolean flag;
	private int x;
	
	
	public aaaaaaaaaaa() {
		p_content = new MyChatContentPanel(new GridBagLayout());

		t_input = new JTextField(10);
		scroll = new JScrollPane(p_content);
	
		//텍스트 감싸기 위한
		p_south = new JPanel();
		bt_input = new JButton("전송");
		
		//붙이기
		p_south.add(t_input);
		p_south.add(bt_input);

		add(p_south, BorderLayout.SOUTH);
		
		
		GridBagConstraints c = new GridBagConstraints();
		//디자인
		p_content.setBackground(Color.BLUE);
		
		t_input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				JPanel p = new JPanel(new BorderLayout());
				System.out.println("dd");

				if (true) {
					// natural height, maximum width
					c.fill = GridBagConstraints.HORIZONTAL;
				}

				JPanel ppp = new JPanel();
				ppp.setPreferredSize(new Dimension(60 ,60));
				ppp.setBackground(Color.BLACK);
				if (true) {
					c.fill = GridBagConstraints.WEST;
					c.weightx = 0;
				}
				c.fill = GridBagConstraints.HORIZONTAL;
				c.gridx = 0;
				c.gridy = 0;
				c.gridy = x; 
				p_content.add(ppp, c);

				papa = new JPanel(new BorderLayout());
				lalala = new JLabel("난나야");
				papa.add(lalala, BorderLayout.NORTH);
				papa.setBackground(Color.RED);
				papa.setPreferredSize(new Dimension(50 ,50));
				//c.fill = GridBagConstraints.NORTH;
				c.weightx = 0;
				c.gridx = 1;
				c.gridy = x; 
				p_content.add(papa, c);
				
				papa = new JPanel(new BorderLayout());
				textPane = new MyTextPane(true, "dd", true);
                textPane.setEditable(true);
                textPane.setBackground(Color.YELLOW);
                
                String msg = t_input.getText();
                StyledDocument doc = textPane.getStyledDocument();
                SimpleAttributeSet right = new SimpleAttributeSet();
                StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
                StyleConstants.setForeground(right, Color.BLUE);
        		try {
					doc.insertString(doc.getLength(),msg, right );
					doc.setParagraphAttributes(doc.getLength(), 1, right, false);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		

				papa.setPreferredSize(new Dimension(50 ,50));
				papa.add(textPane);
				//c.fill = GridBagConstraints.NORTH;
				c.weightx = 0.5;
				c.gridx = 2;
				c.gridy = x; 
				p_content.add(papa, c);
				
				papa = new JPanel(new BorderLayout());
				papa.setBackground(Color.GRAY);
				lalala = new JLabel("시간");
				lalala.setBackground(Color.RED);
				papa.add(lalala, BorderLayout.SOUTH);
				papa.setPreferredSize(new Dimension(50 ,50));
				c.fill = GridBagConstraints.HORIZONTAL;
				c.weightx = 0;
				c.gridx = 3;
				c.gridy = x; 
				p_content.add(papa, c);
				
				JPanel pppp = new JPanel();
				pppp.setPreferredSize(new Dimension(60 ,60));
				pppp.setBackground(Color.BLUE);
				if (true) {
					c.fill = GridBagConstraints.WEST;
					c.weightx = 0;
				}
				c.fill = GridBagConstraints.HORIZONTAL;
				c.gridx = 4;
				c.gridy = x; 
				p_content.add(pppp, c);
				x++;
				aaaaaaaaaaa.this.repaint();
				
				
				getContentPane().add(scroll, BorderLayout.CENTER);


        		p_content.revalidate();
        		textPane.setCaretPosition(textPane.getDocument().getLength());
        		

				t_input.setText("");
			}
		});
		
		
		
		
		
		
		
		
		
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(scroll, BorderLayout.CENTER);
		
		add(scroll);
		
		
	    setPreferredSize(new Dimension(420,450));  // 카톡 크기만큼 조정
		pack();
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	    setMinimumSize( this.getSize() ); // 420, 450 사이즈보다 줄어들지 안는다.

	}
	
	public static void main(String[] args) {
		new aaaaaaaaaaa();
	}
}
