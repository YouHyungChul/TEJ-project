
public class FileManager {

	//������ Ȯ���� ���ϱ�
	public String getExt(String path) {
		String pathImg = "C:/Users/suyou/Desktop/images/enemy/e...png";
		
		//1�ܰ� : ���ϸ� �����ϱ�
		//			������ ������ ��������, �������� ���ϸ�
		int lastIndex = path.lastIndexOf("/"); // escape ����
		
		String filename = path.substring(lastIndex+1, path.length());
		
		//2�ܰ� : ���ϸ��� ������� Ȯ���ڸ� ��������
		//			���ϸ����� ������ ������ ����!!
		lastIndex = filename.lastIndexOf(".");
		String ext = filename.substring(lastIndex+1, filename.length());
		
		return ext; // ȣ���ڿ��� ��� ����!!
	}
}
