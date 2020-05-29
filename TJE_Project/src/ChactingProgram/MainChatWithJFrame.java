package ChactingProgram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainChatWithJFrame extends JFrame {

	// �̹���
	ImageIcon icon;
	Icon img;
	// �̹����н�
	String path = "C:/Users/suyou/Desktop/images/love.gif";
//	String path = "C:/Users/suyou/Desktop/images/ball/ball7.png";

	MyChatContentPanel p_content;
	JPanel p_south;
	JScrollPane scroll;
	JTextField t_input;
	JTextArea area;
	JButton bt_input;
	JButton bt_img;
	MyTextPane textPane;
	boolean flag;
	private int x;

	public MainChatWithJFrame() {

		// �̹���
		// icon = new ImageIcon(path);

		p_content = new MyChatContentPanel(new GridBagLayout());
		t_input = new JTextField(25);
		scroll = new JScrollPane(p_content);

		// �ؽ�Ʈ ���α� ����
		p_south = new JPanel();
		bt_input = new JButton("����");

		// ���̱�
		p_south.add(t_input);
		p_south.add(bt_input);

		add(p_south, BorderLayout.SOUTH);

		// ������
		p_content.setBackground(Color.white);

		// �ؽ�Ʈ �ʵ忡 �̺�Ʈ ������
		t_input.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int result = e.getKeyCode();
				if (result == KeyEvent.VK_ENTER) {
					
					
					
					path = "C:/Users/suyou/Desktop/images//ball/ball7.png";
					Icon i = new ImageIcon(path);
					i = ResizeImageIcon.resizeImageIcon(path, 50, 50);
					JLabel la_profile = new JLabel(i);
					la_profile.setOpaque(true);
					la_profile.setBackground(Color.BLACK);
					
					
					
					
					String msg = t_input.getText();

					// content �гο� ���� �гλ���
					JPanel p = new JPanel(new BorderLayout());
					// �гο� ������ �׵θ� ȿ��
//	                p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
					p.setBackground(Color.YELLOW);
					GridBagConstraints gbc = new GridBagConstraints();

					// flag�� ���� ���´��� Ȯ���ϴ� �뵵�� �ϴ� ��.
					// task1
//	                MainChatWithJFrame.this.getWidth()-t_input.getText().length()*3
					int widthOfEmpty = MainChatWithJFrame.this.getWidth() - 100;
					if (flag) {
						gbc.insets = new Insets(10, 0, 10, 100);
						System.out.println("������");
					} else if (!flag) {
						gbc.insets = new Insets(10, 100, 10, 0);
						System.out.println("����");
					}
					// ĥ������ flag�� ����ǰ�
					flag = !flag;
					gbc.weightx = 0.5;
					gbc.gridy = x++; // ���� �����ؾ� �ϱ� ������ ++;
					gbc.fill = GridBagConstraints.HORIZONTAL;

					// MyTextPane �����ں���
					textPane = new MyTextPane(true, msg, flag);
					textPane.insertComponent(la_profile);
//	                �̹��� ������ �������ִ°� ���� ����
					icon = ResizeImageIcon.resizeImageIcon(path, 70, 70);
					img = ResizeImageIcon.resizeImageIcon(path, 70, 70);
//					textPane.insertIcon(icon);

					JPanel p_time = new JPanel(new BorderLayout());

					JLabel la_time = new JLabel("���� 4:05");
					p_time.setBackground(Color.BLACK);
					System.out.println(la_time.getWidth());
					la_time.setFont(new Font("���� ���", Font.PLAIN, 13));
//					la_time.setAlignmentY(0.0000000001f);

					p_time.add(la_time, BorderLayout.SOUTH);
					textPane.insertComponent(la_time);
//					textPane.insertComponent(p_time);

					img = new ImageIcon(path);

					JLabel la_img = new JLabel(img);

					if (flag) {
						textPane.insertComponent(la_time);
						// textPane.insertComponent(la_img);

					} else {
						//textPane.insertComponent(la_img);
						textPane.insertComponent(la_time);
					}

					getContentPane().add(scroll, BorderLayout.CENTER);
					p.add(textPane);

					p_content.add(p, gbc);
					p_content.revalidate();
					textPane.setCaretPosition(textPane.getDocument().getLength());

					t_input.setText("");
				}
			}
		});

		// ������ �ؽ�Ʈ�� �����ϴ� ����.
		// getContentPane Ŭ������ ���� Ŭ������ �ִ� ��Ű���� ���� �־�� �ȴ�.
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(scroll, BorderLayout.CENTER);

		add(scroll);
		setPreferredSize(new Dimension(420, 450)); // ī�� ũ�⸸ŭ ����
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setMinimumSize(this.getSize()); // 420, 450 ������� �پ���� �ȴ´�.

	}

	public static void main(String[] args) {
		new MainChatWithJFrame();
	}
}

//task1 --> text�� �ȼ�ũ�⸦ ���ؼ� ������ ����â���� ����� ��. --> �ذ�
//task2 --> �̹��� â ���� Ŭ���ϸ� ������ �����ؼ� textpane�� ���̱� --> ing
//task3 --> ����ð� �޼ҵ� ����� �󺧿� ����ð� ���̱�.
//task4 --> gif ���� jlabel�� ���̱�.
//task5 --> �̹��� �ø��� �ð� �Ʒ��� �������� �ϴ°� �Ұ�����. 

//area ���� �� �ٿ��� �ȵǰ� p �г� ��ü�� ������ �༭ west east ���̸�
//area �г� ��ü�� �ּ� ũ��� �پ�� �׷��� �ȵ�.
//--> jtextpane �̿��غ���.
//if(flag) {
//	area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//	p.add(area);
//}else if(!flag){
//	p.add(area, BorderLayout.WEST);
//}
//p�гο� area���
