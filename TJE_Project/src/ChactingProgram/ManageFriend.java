package ChactingProgram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ManageFriend extends PageChat {
	
	JPanel p_center;
	JPanel p_west;
	JPanel p_south;
	JPanel p_north;
	JPanel p_ad; // �ϴ� ����
	JButton bt_Friend; // ģ��
	JButton bt_Chat; // ä��
	JButton bt_More; // ������
	JButton bt_Imo; // �̸�Ƽ�� ��
	JButton bt_Inform; // �˸�
	JButton bt_Setting; // ����
//---------------�����г�----------------------------

	JPanel p_containr;// �����г� ���� �г�
	JPanel p_content; // �����г�
	JPanel p_north1; // �󺧰� ģ���߰���ư ���� �г�
	JPanel p_north2; // �̸��˻��� �� �ִ� jtextfield ���� �г�\
	JPanel p_south1; // ���� ���? ��.
	JLabel la_title;
	JButton bt_add;
	JTextField f_find;
	JPanel p_friend;
	JScrollPane scroll;
	ModelFriend modelFriend;
	
	//�̰� �� �������� �����???
	Image img;
	Label la_name;
	Label la_message;
//---------------�����г�----------------------------

	public ManageFriend(ChatApp chatApp, String title, int width, int height, Color color, boolean showFlag) {
		super(chatApp, title, width, height, color, showFlag);
		this.chatApp = chatApp;
		this.title = title;
		this.color = color;
		this.width = width;
		this.height = height;

		p_ad = new JPanel();// �ϴ� ����
		p_center = new JPanel(new BorderLayout());
		p_west = new JPanel(new BorderLayout());
		p_south = new JPanel(); // p_west�� ���� �г� --ģ��, ä��, ������
		p_north = new JPanel();// p_west�� ���� �г� --ģ��, ä��, ������
		bt_Friend = new JButton("ģ��");
		bt_Chat = new JButton("ä��");
		bt_More = new JButton("������");
		bt_Imo = new JButton("�̸�Ƽ�ܼ�");
		bt_Inform = new JButton("�˸�");
		bt_Setting = new JButton("����");
//---------------�����г� ����----------------------------
		modelFriend = new ModelFriend();
		p_friend = new JPanel();
		scroll = new JScrollPane(p_friend);
		p_containr = new JPanel(new BorderLayout());
		p_content = new JPanel(new BorderLayout());
		p_north1 = new JPanel(new BorderLayout());
		p_north2 = new JPanel();
		p_south1 = new JPanel();
		la_title = new JLabel("ģ��");
		bt_add = new JButton("ģ���߰�");
		f_find = new JTextField(10);
//---------------�����г� ����----------------------------

		p_north.add(bt_Friend);
		p_north.add(bt_Chat);
		p_north.add(bt_More);
		p_south.add(bt_Imo);
		p_south.add(bt_Inform);
		p_south.add(bt_Setting);
		p_north.setPreferredSize(new Dimension(50, 220));
		p_south.setPreferredSize(new Dimension(50, 120));

		p_west.add(p_north, BorderLayout.NORTH);
		p_west.add(p_south, BorderLayout.SOUTH);
		p_west.setPreferredSize(new Dimension(100, 450));
		p_center.setPreferredSize(new Dimension(300, 380));
		p_center.setBackground(Color.GREEN);
		p_ad.setPreferredSize(new Dimension(350, 100));
		p_ad.setBackground(Color.PINK);
		p_friend.setPreferredSize(new Dimension(320,400));

//---------------�����г� ����----------------------------

		p_north1.add(la_title, BorderLayout.WEST);
		p_north1.add(bt_add, BorderLayout.EAST);
		p_north1.add(f_find, BorderLayout.SOUTH);
		p_north1.setPreferredSize(new Dimension(300, 70));
//---------------�����г� ����----------------------------

		// 350,550

		p_content.add(p_north1, BorderLayout.NORTH);
		p_containr.add(p_content, BorderLayout.NORTH);
		p_containr.add(scroll);
		add(p_west, BorderLayout.WEST);
		add(p_containr, BorderLayout.CENTER);
		add(p_ad, BorderLayout.SOUTH);

		//ģ����ư�� ������
		bt_Friend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getList();
			}
		});
		
		//ģ����ư ������ �� ä��â �ߵ��� ����;
		bt_Chat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainChatWithJFrame();
			}
		});
		
		//�ؽ�Ʈ�ʵ忡 ��Ʈ�ֱ�
		  String hint = "Search Name";
		  Font gainFont = new Font("verdana", Font.PLAIN, 11);  
		  Font lostFont = new Font("Tahoma", Font.ITALIC, 11);
		  f_find.setText(hint);
		  f_find.setFont(lostFont);
		  f_find.setForeground(Color.GRAY);

		f_find.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(f_find.getText().equals(hint)) {
					f_find.setText("");
					f_find.setFont(gainFont);
					f_find.setForeground(Color.BLACK);
				}else {
					f_find.setText(f_find.getText());  
					setFont(gainFont);  
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
		        if (f_find.getText().equals(hint)|| f_find.getText().length()==0) {  
		        	f_find.setText(hint);  
		            setFont(lostFont);  
		            setForeground(Color.GRAY);  
		          } else {  
		        	  f_find.setText(f_find.getText());  
		        	  f_find.setFont(gainFont);  
		        	  setForeground(Color.BLACK);  
		          }  
			}
		});
		
		this.setBackground(color);
		this.setPreferredSize(new Dimension(width, height));
		this.setVisible(this.showFlag);
	}
	
	
	//���? ���̺��? ��������
	public void getList() {
		String sql = "select * from chat_friend order by chat_friend_id desc";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = chatApp.con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// Ŀ���� �������鼭 VO�� ���ڵ带 ����!!
			// List�� �����Ͽ� �Ʒ��� VO���� �������� �־����?!!
			// �׷��� TableModel���� �迭ó�� �����? �� �����ϱ�!!
			
			ArrayList friendList = new ArrayList();
			while (rs.next()) {// Ŀ�� ��ĭ �̵�!!
				Friend friend = new Friend();
				// �迭�� �ε����� �ƴ϶�, �������� �̿��ϹǷ� �ξ� �������̴�!!
				friend.setChat_friend_id(rs.getInt("chat_friend_id"));
				friend.setName(rs.getString("name"));
				friend.setState(rs.getString("state"));
				friend.setImg(rs.getString("img"));

				friendList.add(friend); // �ϼ��� VO�� ����Ʈ�� ������Ű��!!

				CardFriend card = new CardFriend(friend);
				p_friend.add(card);
			}
			System.out.println("�����? �� ��ǰ�� ����" + friendList.size());
			
			// ������ ����Ʈ�� TableModel���� ��������!!
			modelFriend.list = friendList;
			// jtable ���ΰ�ħ

			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			chatApp.connectionManager.closeDB(pstmt, rs);
		}
	}
}


