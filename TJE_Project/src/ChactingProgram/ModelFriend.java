package ChactingProgram;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModelFriend extends AbstractTableModel{

	ArrayList<Friend> list = new ArrayList<Friend>();
	String[] columnNames = {
			"chat_friend_id","name","state","img"
	};
	
	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}
	
	//���̺� �̸� ����ϱ�?
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Friend friend = list.get(row);
		String data = null;
		if(col==0) {
			data = Integer.toString(friend.getChat_friend_id());
		}else if(col==1) {
			data = friend.getName();
		}else if(col==2) {
			data = friend.getState();
		}else if(col==3) {
			data = friend.getImg();
		}
		
		return data;
	}

}
