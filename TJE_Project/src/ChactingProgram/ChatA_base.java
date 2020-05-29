package ChactingProgram;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA_base extends JFrame implements ActionListener {
	JPanel p_north,p_south; // ����,���� �����̳�
	JButton bt_call,bt_ms; // ä��ģ�� ȣ��, �޽�������
	JTextArea area; // �ؽ�Ʈ ����
	JScrollPane scroll; // ��ũ��
	JTextField t_input; // �ؽ�Ʈ�Է�
	ChatB_base chatB;
	ChatC_base chatC;
	
	//�ð�ǥ��
	SimpleDateFormat format;
	Calendar cal;
	String time;
	String showTime ;
	int hour, min;

	
	public ChatA_base() {
		super("ChatA");
		p_north = new JPanel();
		bt_call = new JButton("ģ������");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input = new JTextField(15);
		bt_ms = new JButton("����"); // �޽�������

		//�ð�ǥ��
		format = new SimpleDateFormat("a HH:mm");
		cal = Calendar.getInstance();
		hour = cal.get(cal.HOUR_OF_DAY);
		min = cal.get(cal.MINUTE);
		showTime = format.format(cal.getTime());
		
		// ����
		p_north.add(bt_call); // �����г� ��ư ����
		// ������ ���ʿ� �гκ���
		add(p_north, BorderLayout.NORTH);
		
		// ������ ���� ��ũ�Ѻ���
		add(scroll);
		
		// �����гο� �ؽ�Ʈ�Է�, ��ư ����
		p_south.add(t_input);
		p_south.add(bt_ms);
		// ������ ���ʿ� �г� ����
		add(p_south, BorderLayout.SOUTH);
		
		// ������ ũ���? ���̰�.
		setBounds(100,100,300,400);//x,y,width,height
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// ��ư������ ģ������!
		bt_call.addActionListener(this);
		
		// �ؽ�Ʈ �ۼ� �ϰ� ���ʹ����� ȭ�鿡 �۾� �ø���.
		t_input.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER) {
					if(t_input.getText().length()>0) {
						String msgA = t_input.getText();
						
						area.append(showTime+"A.user : "+msgA+"\n");
						if(chatB!=null) {
							chatB.area.append(showTime+"A.user : "+msgA+"\n");
						}
						if(chatC!=null) {
							chatC.area.append(showTime+"A.user : "+msgA+"\n");
						}

						t_input.setText("");
					}

				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
	}
	public void textA(String text) {
		area.append(text+"\n");
	}
	
	public void actionPerformed(ActionEvent e) {
		if(chatB==null) {
			chatB = new ChatB_base();
		}
		if(chatC==null) {
			chatC = new ChatC_base();
		}
		
		chatB.setChatA(this);
		chatB.setChatC(chatC);
		
		chatC.setChatA(this);
		chatC.setChatB(chatB);
	}

	public static void main(String[] args) {
		new ChatA_base();
	}

}
