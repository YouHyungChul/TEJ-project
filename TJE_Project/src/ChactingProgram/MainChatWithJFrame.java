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

	// 이미지
	ImageIcon icon;
	Icon img;
	// 이미지패스
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

		// 이미지
		// icon = new ImageIcon(path);

		p_content = new MyChatContentPanel(new GridBagLayout());
		t_input = new JTextField(25);
		scroll = new JScrollPane(p_content);

		// 텍스트 감싸기 위한
		p_south = new JPanel();
		bt_input = new JButton("전송");

		// 붙이기
		p_south.add(t_input);
		p_south.add(bt_input);

		add(p_south, BorderLayout.SOUTH);

		// 디자인
		p_content.setBackground(Color.white);

		// 텍스트 필드에 이벤트 리스너
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

					// content 패널에 붙일 패널생성
					JPanel p = new JPanel(new BorderLayout());
					// 패널에 검정색 테두리 효과
//	                p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
					p.setBackground(Color.YELLOW);
					GridBagConstraints gbc = new GridBagConstraints();

					// flag는 누가 보냈는지 확인하는 용도로 일단 씀.
					// task1
//	                MainChatWithJFrame.this.getWidth()-t_input.getText().length()*3
					int widthOfEmpty = MainChatWithJFrame.this.getWidth() - 100;
					if (flag) {
						gbc.insets = new Insets(10, 0, 10, 100);
						System.out.println("오른쪽");
					} else if (!flag) {
						gbc.insets = new Insets(10, 100, 10, 0);
						System.out.println("인쪽");
					}
					// 칠때마다 flag값 변경되게
					flag = !flag;
					gbc.weightx = 0.5;
					gbc.gridy = x++; // 값이 증가해야 하기 때문에 ++;
					gbc.fill = GridBagConstraints.HORIZONTAL;

					// MyTextPane 생성자변경
					textPane = new MyTextPane(true, msg, flag);
					textPane.insertComponent(la_profile);
//	                이미지 사이즈 변경해주는거 따로 뺴놈
					icon = ResizeImageIcon.resizeImageIcon(path, 70, 70);
					img = ResizeImageIcon.resizeImageIcon(path, 70, 70);
//					textPane.insertIcon(icon);

					JPanel p_time = new JPanel(new BorderLayout());

					JLabel la_time = new JLabel("오후 4:05");
					p_time.setBackground(Color.BLACK);
					System.out.println(la_time.getWidth());
					la_time.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
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

		// 강제로 텍스트를 랩핑하는 과정.
		// getContentPane 클래스가 현재 클래스가 있는 패키지에 같이 있어야 된다.
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(scroll, BorderLayout.CENTER);

		add(scroll);
		setPreferredSize(new Dimension(420, 450)); // 카톡 크기만큼 조정
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setMinimumSize(this.getSize()); // 420, 450 사이즈보다 줄어들지 안는다.

	}

	public static void main(String[] args) {
		new MainChatWithJFrame();
	}
}

//task1 --> text의 픽셀크기를 구해서 윈도우 현재창에서 빼줘야 함. --> 해결
//task2 --> 이미지 창 띄우고 클릭하면 사이즈 변경해서 textpane에 붙이기 --> ing
//task3 --> 현재시간 메소드 만들고 라벨에 현재시간 붙이기.
//task4 --> gif 파일 jlabel에 붙이기.
//task5 --> 이미지 올릴때 시간 아래로 떨어지게 하는거 불가능함. 

//area 정렬 후 붙여도 안되고 p 패널 자체에 보더를 줘서 west east 불이면
//area 패널 자체가 최소 크기로 줄어듬 그래서 안됨.
//--> jtextpane 이용해보자.
//if(flag) {
//	area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//	p.add(area);
//}else if(!flag){
//	p.add(area, BorderLayout.WEST);
//}
//p패널에 area담기
