package ChactingProgram;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatC_base extends JFrame {
	JPanel p_south; // ���� �����̳�
	JButton bt_ms; // �޽�������
	JTextArea area; // �ؽ�Ʈ ����
	JScrollPane scroll; // ��ũ��
	JTextField t_input; // �ؽ�Ʈ�Է�
	ChatA_base chatA;
	ChatB_base chatB;
	
	// �ð�ǥ��
	SimpleDateFormat format;
	Calendar cal;
	String time;
	String showTime;
	int hour, min;
	
	public ChatC_base() {
		super("ChatC");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input = new JTextField(15);
		bt_ms = new JButton("����"); // �޽�������
		
		format = new SimpleDateFormat("a HH:mm");
		cal = Calendar.getInstance();
		hour = cal.get(cal.HOUR_OF_DAY);
		min = cal.get(cal.MINUTE);
		showTime = format.format(cal.getTime());
		
		// ������ ���� ��ũ�Ѻ���
		add(scroll);
		
		// �����гο� �ؽ�Ʈ�Է�, ��ư ����
		p_south.add(t_input);
		p_south.add(bt_ms);
		// ������ ���ʿ� �г� ����
		add(p_south, BorderLayout.SOUTH);
		
		// ������ ũ���? ���̰�.
		setBounds(600,200,300,400);//x,y,width,height
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// �ؽ�Ʈ �ۼ� �ϰ� ���ʹ����� ȭ�鿡 �۾� �ø���.
		t_input.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER) {
					if (t_input.getText().length() > 0) {
						String msgC = t_input.getText();

						area.append(showTime + "A.user : " + msgC + "\n");
						if (chatA != null) {
							chatA.area.append(showTime + "A.user : " + msgC + "\n");
						}
						if (chatB != null) {
							chatB.area.append(showTime + "A.user : " + msgC + "\n");
						}
						System.out.println(showTime);
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
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

			}
		});
		
	}


	public void setChatA(ChatA_base chatA) {
		this.chatA = chatA;
	}


	public void setChatB(ChatB_base chatB) {
		this.chatB = chatB;
	}
	
}
