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
		//创建窗口类的实例化对象
		Frame window = new Frame();
		MyPanel myPanel = new MyPanel();
		//设置窗口的大小
		window.setSize(400, 600);
		//设置窗口的位置
//		window.setLocation(100,100);
		//具有让窗体居中的显示效果
		window.setLocationRelativeTo(null);
		window.add(myPanel);
		//显示窗口的方法
		window.show();
	}
	

}
//编写画板类，完成绘画方法
class MyPanel extends Panel{
	//
//	@Override
//	public void paint(Graphics g)
//	{
//		 Graphics2D g2 = (Graphics2D)g; 
//		//绘画方法
//		//g 可以理解为一支画笔，可以在画板上画画 的笔
//		 g2.drawOval(50, 50, 30, 30);
//		 // 4. 绘制虚线: 将虚线分为若干段（ 实线段 和 空白段 都认为是一段）, 实线段 和 空白段 交替绘制,
//         //             绘制的每一段（包括 实线段 和 空白段）的 长度 从 dash 虚线模式数组中取值（从首
//         //             元素开始循环取值）, 下面数组即表示每段长度分别为: 5px, 10px, 5px, 10px, ...
//         float[] dash = new float[] { 2, 2 };
//         BasicStroke sroke = new BasicStroke(
//                 1,                      // 画笔宽度/线宽
//                 BasicStroke.CAP_SQUARE,
//                 BasicStroke.JOIN_MITER,
//                 10.0f,
//                 dash,                   // 虚线模式数组
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
        String s = "Java 2d 旋转";
        Font f = new Font("宋体", Font.BOLD, 16);
        Color[] colors = {Color.ORANGE, Color.LIGHT_GRAY};
        g2d.setFont(f);
        //   平移原点到图形环境的中心
        g2d.translate(this.getWidth() / 2, this.getHeight() / 2);
        //   旋转文本
        g2d.rotate(90 * Math.PI / 180);
        g2d.setPaint(colors[1 % 2]);
        g2d.drawString(s, 0, 0);
        g2d.drawLine(0, 0, 200, 200);
//        for (int i = 0; i < 12; i++) {
//        }
    }
}
