package com.tarena.day02;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MySnow02
{

	public static void main(String[] args)
	{
		
		JFrame mySonw = new JFrame();
		mySonw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mySonw.setSize(1024, 768);
		mySonw.setLocationRelativeTo(null);
		MyPanle myPanle = new MyPanle();
		Thread snowThread = new Thread(myPanle);
		snowThread.start();
		mySonw.add(myPanle);
		mySonw.setVisible(true);

	}

}
//自定义Panle，继承Panle类，实现Runnable接口
class MyPanle extends JPanel implements Runnable
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
		super.paint(g);
		this.setBackground(Color.BLACK);
		g.setColor(Color.lightGray);
		Font font = new Font("微软雅黑", Font.BOLD, 30);
		g.setFont(font);
		for (int i = 0; i < 300; i++)
		{
			
			// 设置字体
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
