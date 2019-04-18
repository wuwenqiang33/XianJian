package com.tarena.day01;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
public class MyFrame
{
	public static void main(String[] args)
	{
		//�����������ʵ��������
		Frame window = new Frame();
		MyPanel myPanel = new MyPanel();
		//���ô��ڵĴ�С
		window.setSize(400, 600);
		//���ô��ڵ�λ��
//		window.setLocation(100,100);
		//�����ô�����е���ʾЧ��
		window.setLocationRelativeTo(null);
		window.add(myPanel);
		//��ʾ���ڵķ���
		window.show();
	}
	

}
//��д�����࣬��ɻ滭����
class MyPanel extends Panel{
	//
//	@Override
//	public void paint(Graphics g)
//	{
//		 Graphics2D g2 = (Graphics2D)g; 
//		//�滭����
//		//g �������Ϊһ֧���ʣ������ڻ����ϻ��� �ı�
//		 g2.drawOval(50, 50, 30, 30);
//		 // 4. ��������: �����߷�Ϊ���ɶΣ� ʵ�߶� �� �հ׶� ����Ϊ��һ�Σ�, ʵ�߶� �� �հ׶� �������,
//         //             ���Ƶ�ÿһ�Σ����� ʵ�߶� �� �հ׶Σ��� ���� �� dash ����ģʽ������ȡֵ������
//         //             Ԫ�ؿ�ʼѭ��ȡֵ��, �������鼴��ʾÿ�γ��ȷֱ�Ϊ: 5px, 10px, 5px, 10px, ...
//         float[] dash = new float[] { 2, 2 };
//         BasicStroke sroke = new BasicStroke(
//                 1,                      // ���ʿ��/�߿�
//                 BasicStroke.CAP_SQUARE,
//                 BasicStroke.JOIN_MITER,
//                 10.0f,
//                 dash,                   // ����ģʽ����
//                 0.0f
//         );
//		 g2.setStroke(sroke);
//		 int[] xPoints =new int[] {10,20,20,30};
//		int[] yPoints = {10,10,20,20};
//		g2.drawPolyline(xPoints, yPoints, 4);
//		
//	}
	
	@Override
	public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.drawLine(0, 0, 200, 200);
//        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        String s = "Java 2d ��ת";
        Font f = new Font("����", Font.BOLD, 16);
        Color[] colors = {Color.ORANGE, Color.LIGHT_GRAY};
        g2d.setFont(f);
        //   ƽ��ԭ�㵽ͼ�λ���������
        g2d.translate(this.getWidth() / 2, this.getHeight() / 2);
        //   ��ת�ı�
        g2d.rotate(90 * Math.PI / 180);
        g2d.setPaint(colors[1 % 2]);
        g2d.drawString(s, 0, 0);
        g2d.drawLine(0, 0, 200, 200);
//        for (int i = 0; i < 12; i++) {
//        }
    }
}
