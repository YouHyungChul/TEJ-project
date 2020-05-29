package ChactingProgram;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//�ڵ��α��� ���¿��� ��й��? �Է��ϸ� �ߴ� �α��� ȭ��
public class ManageLoggingIn extends PageLogin{
	JPanel loginBox;
	JPanel form; // �α��� ��
	JLabel la_id;
	JLabel la_pw;
	JTextField t_id;
	JPasswordField t_pw;
	JButton bt_regist;
	
	public ManageLoggingIn(ChatApp chatApp, String title, int width, int height, 
												Color color, boolean showFlag,boolean reSize) { // �θ������� �����Ѵ�!!
		super(chatApp,title, width,height,color,showFlag, reSize);
		
		loginBox = new JPanel();
		form = new JPanel();
		la_id = new JLabel("ID");
		la_pw = new JLabel("Password");
		t_id = new JTextField(10);
		t_pw = new JPasswordField(10);
		bt_regist = new JButton("Login");
		
		//��Ÿ�� ����
		loginBox.setBackground(Color.WHITE);
		loginBox.setPreferredSize(new Dimension(250,170));
		
		//���̾ƿ�����
		form.setLayout(new GridLayout(2,2));
		
		//����
		form.add(la_id);
		form.add(t_id);
		form.add(la_pw);
		form.add(t_pw);

		loginBox.add(form);
		loginBox.add(bt_regist);
//		loginBox.add(new JPanel().add(loginBox));
		
		add(loginBox);
		
		chatApp.setResizable(reSize);
		//��ư�� ������ ����!!
		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginCheck();
			}
		});
	}
	
	public void loginCheck() {
		// ? ����ǥ ǥ�����? ��Ȱ : ���ε� ������ �Ѵ�...
		// �����ͺ��̽� ���������? ���� ���?..
		String sql = "select * from admin where id=? and password=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = chatApp.con.prepareStatement(sql);
			pstmt.setString(1, t_id.getText());//id
			pstmt.setString(2, new String(t_pw.getPassword()));//ps
			//System.out.println(t_pw.getText());
			rs = pstmt.executeQuery(); //��������
			
			if(rs.next()) {
				chatApp.hasAuth=true;
				JOptionPane.showMessageDialog(this, "�α��οϷ�");
				//�α��� �Ǹ� �α��� ȭ�� �Ⱥ��̰� ����
				chatApp.pages[0].setVisible(false);
				chatApp.pages[1].setVisible(false);
				chatApp.pages[2].setVisible(true);
				
			}else { // �����ϴ� ������ ����
				chatApp.hasAuth=false;
				JOptionPane.showMessageDialog(this, "�α��� ����");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			chatApp.connectionManager.closeDB(pstmt, rs);
		}
		
	}
	
}