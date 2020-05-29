package ChactingProgram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChatApp extends JFrame{
	JPanel p_content;
	
	PagePrimary[] pages = new PagePrimary[5]; // �α���ȭ�� 2��, ä�� ȭ�� 3�� �� 5��
	ConnectionManager connectionManager;
	Connection con; // �гε� �� ���������� ���? ������ �� �ֵ��� �����س���!!
	
	boolean hasAuth = false; // �α����� ���? true, ���Ѱ��? false
	Object obj;

	public ChatApp() {
//		p_content = new JPanel(new BorderLayout());
		p_content = new JPanel();
		//������ ����
		pages[0] = new ManageLogin(this, "�α���1", 450, 550, Color.DARK_GRAY, false, true);
		pages[1] = new ManageLoggingIn(this, "�α���2", 450, 550, Color.CYAN, true,true);
		pages[2] = new ManageFriend(this, "ģ��", 450, 550, Color.YELLOW, false);
		pages[3] = new ManageChat(this, "ä��", 450, 550, Color.BLUE, false);
		pages[4] = new ManageMore(this, "������", 450, 550, Color.RED, false);
		
		
		//task1. ���? �г��� �ƹ� ���� ���� p_content�� �ٿ� ������
		//				�޵��� ũ�� ���� panel�� Ŀ������ �ʴ´�.
		//				������ ����Ѵ�?.
		
		//������ ����
		//�α��� �Ǹ� �α��� �Ⱥ��̰� �ϴ� ������ manageLoggingin�� �α��� �ɶ� ����.
		p_content.add(pages[0]);
		p_content.add(pages[1]);
		p_content.add(pages[2]);
		p_content.add(pages[3]);
		p_content.add(pages[4]);
		
		add(p_content);
		
		
		
		//���Ӱ����� 
		connectionManager = new ConnectionManager();
		
		pack(); // ������ ���빰���� �ɱ׶���!!
		setVisible(true);
		setMinimumSize( new Dimension(460,510) ); //������ �ּһ����� ����
		
		
		// �ӽ������� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//����Ŭ ����
		con = connectionManager.getConnection();
		if(con==null) {
			JOptionPane.showMessageDialog(this, "DB���� ����");
		}else {
			//JOptionPane.showMessageDialog(this, "DB���� ����");
		}

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				connectionManager.closeDB(con);
				System.exit(0);
			}
			
			
			
		});
	}
	


	
	public static void main(String[] args) {
		new ChatApp();
	}
}


//task1. ���? �г� �������� ���̸� �ȵ�. �гΤ� ���� ���������?.