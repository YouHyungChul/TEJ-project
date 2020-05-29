package dispnsible;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

//���ڿ��� �ȼ��� �����ִ� �޼���
public class CalculatePixelOfString {
	public static int cal(String msg) {
//		this.msg = msg;
		   BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		   Graphics2D g2d = img.createGraphics();
		   FontMetrics fm = g2d.getFontMetrics();
		   fm.stringWidth(msg);
		   //System.out.println(result);
		   g2d.dispose();
		   return fm.stringWidth(msg);
		
	}
}