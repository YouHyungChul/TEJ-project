package ChactingProgram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

//ģ�� �ϳ��ϳ��� ǥ���ϴ� Ŭ����!!
public class CardFriend extends JPanel{
	JPanel p_container; // �̹����� �� ���� �г�
	JPanel p_con_canvas; // ĵ���� ���� ��
	ManageFriend fm;
	JPanel p_canvas; //�̹��� ���� ��
	JLabel la_name, la_state;
	Friend friend; // VO ����!!
	
	public CardFriend(Friend friend) {
		this.friend = friend;
		p_con_canvas = new JPanel();
		//������ ����
		p_container = new JPanel(new BorderLayout());
		p_canvas = new JPanel() {
			//task1 �̹��� �ٽ� �������� �ؾ���.
		};
		
		la_name = new JLabel(friend.getName());
		la_state = new JLabel(friend.getState());
		
		//��Ÿ�� ����
		setPreferredSize(new Dimension(320,60));
		setBackground(Color.YELLOW);
		
		p_con_canvas.setPreferredSize(new Dimension(60,60));
		p_container.setPreferredSize(new Dimension(250,60));
		p_canvas.setPreferredSize(new Dimension(50,50));
		p_canvas.setBackground(Color.BLUE);
		la_name.setPreferredSize(new Dimension(250,20));
		la_state.setPreferredSize(new Dimension(250,40));
		
		p_container.add(la_name, BorderLayout.NORTH);
		p_container.add(la_state, BorderLayout.SOUTH);
		
		p_container.setBackground(Color.BLACK);
		p_con_canvas.setBackground(Color.RED);
		
		
		p_con_canvas.add(p_canvas);
		setLayout(new BorderLayout());
		add(p_con_canvas, BorderLayout.WEST);
		add(p_container, BorderLayout.CENTER);


		
		
		
	}
}


//task1.