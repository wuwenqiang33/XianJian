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
 * ����Ҵ�ͼƬ�滭����Ϸ��������ʾ
 * 
 * @author Administrator
 *
 */
public class MyGame
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		// 1.�����������ʵ���������������ԣ���ʾ����
		JFrame gameFrame = new JFrame();
		// setDefaultCloseOperation
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(1024, 768);
		gameFrame.setTitle("�ɽ���������Ϸ����");
		gameFrame.setLocationRelativeTo(null);

		// 3.�����������ʵ��������,�봰�ڶ������
		GamePanel gamePanle = new GamePanel();
		// 3.�����̶߳��󣬹���������󣬲������̶߳���
		Thread thread = new Thread(gamePanle, "Thread1");
		thread.start();
		gameFrame.add(gamePanle);
		//�� listener
		gameFrame.addKeyListener(gamePanle);
		gamePanle.addKeyListener(gamePanle);
		gameFrame.setVisible(true);
	}

}

// 2.��д������ ��ɻ滭����
@SuppressWarnings("serial")
class GamePanel extends JPanel implements Runnable,KeyListener
{
	// ����һ������������Ű���ɩ�� 1
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

	// ��ʼ��
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
		// ����xiaoyS
		for (int i = 0; i <= 7; i++)
		{
			Image xjImage = Toolkit.getDefaultToolkit().getImage(
					MyGame.class.getResource("xiaoyS" + i + ".png"));
			xiaoySs.add(xjImage);
		}
		// ����xiaoyX
		for (int i = 0; i <= 7; i++)
		{
			Image xjImage = Toolkit.getDefaultToolkit().getImage(
					MyGame.class.getResource("xiaoyX" + i + ".png"));
			xiaoyXs.add(xjImage);
		}
		// ����xiaoyL
				for (int i = 0; i <= 7; i++)
				{
					Image xjImage = Toolkit.getDefaultToolkit().getImage(
							MyGame.class.getResource("xiaoyL" + i + ".png"));
					xiaoyLs.add(xjImage);
				}
		// ����xiaoyR
		for (int i = 0; i <= 7; i++)
		{
			Image xjImage = Toolkit.getDefaultToolkit().getImage(
					MyGame.class.getResource("xiaoyR" + i + ".png"));
			xiaoyRs.add(xjImage);
		}
		// ����СС��
				for (int i = 0; i <= 1; i++)
				{
					Image xjImage = Toolkit.getDefaultToolkit().getImage(
							MyGame.class.getResource("xxj" + i + ".png"));
					xxjs.add(xjImage);
				}
		// ����С��
		for (int i = 0; i <= 1; i++)
		{
			Image xjImage = Toolkit.getDefaultToolkit().getImage(
					MyGame.class.getResource("xj" + i + ".png"));
			xjs.add(xjImage);
		}
		// ���밢��ɩ
		for (int i = 0; i <= 16; i++)
		{
			Image awsImage = Toolkit.getDefaultToolkit().getImage(
					GamePanel.class.getResource("aws" + i + ".png"));
			awss.add(awsImage);
		}
		// ���밢��ι��
		for (int i = 0; i <= 5; i++)
		{
			Image azwjImage = Toolkit.getDefaultToolkit().getImage(
					GamePanel.class.getResource("azwj" + i + ".png"));
			azwjs.add(azwjImage);

		}

	}

	// �滭����
	@Override
	public void paint(Graphics g)
	{
		// ����Ҵ�ͼƬ�滭��������
		// ��һ����ȡͼƬ����
		Image ljcImage = Toolkit.getDefaultToolkit().getImage(
				GamePanel.class.getResource("ljc.png"));
		Image jImage = Toolkit.getDefaultToolkit().getImage(
				GamePanel.class.getResource("jing.png"));
		// ׼��������Ҵ�ͼƬ��GameFrame������ͬһ·����
		// �ڶ����滭ͼƬ����
		g.drawImage(ljcImage, 0, 0, 1024, 768, null);
		g.drawImage(aws, 300, 290, null);
		g.drawImage(azwj, 210, 200, null);// ����ι��
		g.drawImage(xj, 260, 300, null);//С��
		g.drawImage(xxj, 270, 310, null);//СС��
		g.drawImage(xiaoyR, x, y, null);//xiaoyR
	}

	@Override
	public void run()
	{
		while (true)
		{

			// �ж�awss�Ƿ�Ϊ�գ�����Ϊ�ս��и�ֵ
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
				//��
				xiaoyR=xiaoyLs.get(x%7);
				x--;
			}else if(keyCode ==38){
				//��
				xiaoyR=xiaoySs.get(y%7);
				y--;
			}else if(keyCode ==39){
				//��
				xiaoyR=xiaoyRs.get(x%7);
				x++;
			}else if(keyCode ==40){
				//��
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
