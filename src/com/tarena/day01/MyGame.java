package com.tarena.day01;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 将李家村图片绘画到游戏窗口中显示
 * 
 * @author Administrator
 *
 */
public class MyGame
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		// 1.创建窗体类的实例化对象，设置属性，显示窗体
		JFrame gameFrame = new JFrame();
		// setDefaultCloseOperation
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(1024, 768);
		gameFrame.setTitle("仙剑奇侠传游戏案例");
		gameFrame.setLocationRelativeTo(null);

		// 3.创建画板类的实例化对象,与窗口对象关联
		GamePanel gamePanle = new GamePanel();
		// 3.创建线程对象，关联画板对象，并启动线程对象
		Thread thread = new Thread(gamePanle, "Thread1");
		thread.start();
		gameFrame.add(gamePanle);
		//绑定 listener
		gameFrame.addKeyListener(gamePanle);
		gamePanle.addKeyListener(gamePanle);
		gameFrame.setVisible(true);
	}

}

// 2.编写画板类 完成绘画方法
@SuppressWarnings("serial")
class GamePanel extends JPanel implements Runnable,KeyListener
{
	// 创建一个集合用来存放阿旺嫂等 1
	public List<Image> awss;
	public List<Image> azwjs;
	public List<Image> xjs;
	public List<Image> xxjs;
	public List<Image> xiaoyRs;
	public List<Image> xiaoyLs;
	public List<Image> xiaoySs;
	public List<Image> xiaoyXs;
	public Image xj;
	public Image aws;
	public Image azwj;
	public Image xxj;
	public Image xiaoyR;
	public Image xiaoyL;
	public Image xiaoyS;
	public Image xiaoyX;
	//xiaoyao 
	int x=270;
	int y=310;

	// 初始化
	public GamePanel()
	{
		Image Image = Toolkit.getDefaultToolkit().getImage(
				MyGame.class.getResource("xiaoyX0.png"));
		xiaoyR = Image;
		awss = new ArrayList<Image>();
		azwjs = new ArrayList<Image>();
		xjs = new ArrayList<Image>();
		xxjs = new ArrayList<Image>();
		xiaoyRs = new ArrayList<Image>();
		xiaoyLs = new ArrayList<Image>();
		xiaoySs = new ArrayList<Image>();
		xiaoyXs = new ArrayList<Image>();
		// 存入xiaoyS
		for (int i = 0; i <= 7; i++)
		{
			Image xjImage = Toolkit.getDefaultToolkit().getImage(
					MyGame.class.getResource("xiaoyS" + i + ".png"));
			xiaoySs.add(xjImage);
		}
		// 存入xiaoyX
		for (int i = 0; i <= 7; i++)
		{
			Image xjImage = Toolkit.getDefaultToolkit().getImage(
					MyGame.class.getResource("xiaoyX" + i + ".png"));
			xiaoyXs.add(xjImage);
		}
		// 存入xiaoyL
				for (int i = 0; i <= 7; i++)
				{
					Image xjImage = Toolkit.getDefaultToolkit().getImage(
							MyGame.class.getResource("xiaoyL" + i + ".png"));
					xiaoyLs.add(xjImage);
				}
		// 存入xiaoyR
		for (int i = 0; i <= 7; i++)
		{
			Image xjImage = Toolkit.getDefaultToolkit().getImage(
					MyGame.class.getResource("xiaoyR" + i + ".png"));
			xiaoyRs.add(xjImage);
		}
		// 存入小小鸡
				for (int i = 0; i <= 1; i++)
				{
					Image xjImage = Toolkit.getDefaultToolkit().getImage(
							MyGame.class.getResource("xxj" + i + ".png"));
					xxjs.add(xjImage);
				}
		// 存入小鸡
		for (int i = 0; i <= 1; i++)
		{
			Image xjImage = Toolkit.getDefaultToolkit().getImage(
					MyGame.class.getResource("xj" + i + ".png"));
			xjs.add(xjImage);
		}
		// 存入阿旺嫂
		for (int i = 0; i <= 16; i++)
		{
			Image awsImage = Toolkit.getDefaultToolkit().getImage(
					GamePanel.class.getResource("aws" + i + ".png"));
			awss.add(awsImage);
		}
		// 存入阿朱喂鸡
		for (int i = 0; i <= 5; i++)
		{
			Image azwjImage = Toolkit.getDefaultToolkit().getImage(
					GamePanel.class.getResource("azwj" + i + ".png"));
			azwjs.add(azwjImage);

		}

	}

	// 绘画方法
	@Override
	public void paint(Graphics g)
	{
		// 将李家村图片绘画到画板上
		// 第一，获取图片内容
		Image ljcImage = Toolkit.getDefaultToolkit().getImage(
				GamePanel.class.getResource("ljc.png"));
		Image jImage = Toolkit.getDefaultToolkit().getImage(
				GamePanel.class.getResource("jing.png"));
		// 准备：将李家村图片和GameFrame类存放在同一路径下
		// 第二，绘画图片内容
		g.drawImage(ljcImage, 0, 0, 1024, 768, null);
		g.drawImage(aws, 300, 290, null);
		g.drawImage(azwj, 210, 200, null);// 阿朱喂鸡
		g.drawImage(xj, 260, 300, null);//小鸡
		g.drawImage(xxj, 270, 310, null);//小小鸡
		g.drawImage(xiaoyR, x, y, null);//xiaoyR
	}

	@Override
	public void run()
	{
		while (true)
		{

			// 判断awss是否为空，若不为空进行赋值
			if (awss.size() > 0)
			{

				int azwjFlag=0;
				for (int i = 0; i < 100; i++)
				{
					aws = awss.get(i%17);
					azwj = azwjs.get(i/3 % 6);
					xj = xjs.get(i%2);
					xxj = xxjs.get(i%2);
					repaint();
					try
					{
						Thread.sleep(100);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}

			}

		}

	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	int flag = 0;
	@Override
	public void keyPressed(KeyEvent e)
	{
		
		
		if(flag%2==0){
			
			int keyCode = e.getKeyCode();
			if(keyCode ==37 ){
				//左
				xiaoyR=xiaoyLs.get(x%7);
				x--;
			}else if(keyCode ==38){
				//上
				xiaoyR=xiaoySs.get(y%7);
				y--;
			}else if(keyCode ==39){
				//右
				xiaoyR=xiaoyRs.get(x%7);
				x++;
			}else if(keyCode ==40){
				//下
				xiaoyR=xiaoyXs.get(y%7);
				y++;
			}
		}
		flag++;
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}

}
