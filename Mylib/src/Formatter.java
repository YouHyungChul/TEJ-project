import java.text.DecimalFormat;

//���ϴ� ���ڸ� �Ѱܹ�����, ��ǥó���� ��ȭ��  ��ȯ�ϴ� �޼���
public class Formatter {
	public static String getCurrency(int price) {
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		return formatter.format(price);
	}

}
