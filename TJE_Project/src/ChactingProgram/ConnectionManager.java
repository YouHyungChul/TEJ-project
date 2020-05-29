package ChactingProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="c##suyou881";
	String password="1234";
	
	//������ ���̽� ����
		public Connection getConnection() {
			Connection con=null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
		}
		
		
		//�����ͺ��̽� �ڿ� ����
		//������â ���� �� ȣ��
		public void closeDB(Connection con) {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
		//DML(insert, update, delete)�� ������ ���?
		// Connection�� PreparedStatemnet�� �ݳ�
		public void closeDB(PreparedStatement pstmt) {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		//select�� ���? preparedStatement, ResultSet ����
		public void closeDB(PreparedStatement pstmt, ResultSet rs) {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
}
