package lianxi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;

public class MySnow extends Frame
{

	public static void main(String[] args)
	{
		//1.创建窗体，初始化设置
		MySnow mySonw = new MySnow();
		mySonw.setSize(1024, 768);
		mySonw.setBackground(Color.black);
		mySonw.setLocationRelativeTo(null);
		//2.创建Panle对象
		MyPanle myPanle = new MyPanle();
		//2.创建阿旺嫂Panle对象
		//3.创建线程对象，关联画板对象，并启动线程对象
		Thread snowThread = new Thread(myPanle);
		snowThread.start();
		//4.把Panle对象加到Frame上
		mySonw.add(myPanle);
		//5.最后显示窗体
		mySonw.show();

	}

}
//自定义Panle，继承Panle类，实现Runnable接口
class MyPanle extends Panel implements Runnable
{
//数组  把雪花坐标设置成成员变量  通过构造方法进行初始化  方便使用
	int [] xs = new int[300];
	int [] ys = new int[300];
	public MyPanle()
	{
		for(int i = 0;i<ys.length;i++){
			xs[i]=(int) (Math.random() * 1024);
			ys[i]=(int) (Math.random() * 768);
		}
	}
	//绘制雪花
	public void paint(Graphics g)
	{
		for (int i = 0; i < 300; i++)
		{
			
			g.setColor(Color.lightGray);
			// 设置字体
			Font font = new Font("微软雅黑", Font.BOLD, 30);
			g.setFont(font);
			g.drawString("*", xs[i], ys[i]);
		}
	}

	// 实现运动效果
	@Override
	public void run()
	{
		while(true)
		{
			//改变1.改变y轴坐标
			for (int i = 0; i < ys.length; i++)
			{
				ys[i]++;
				//补充 判断坐标是否超出边界
				if(ys[i]>=768){
					ys[i] = 0;
				}
			}
			try
			{
				Thread.sleep(10);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			//重绘：重新调用paint()方法
			repaint();
			
		}

	}

}
