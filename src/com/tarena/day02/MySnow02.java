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
//�Զ���Panle���̳�Panle�࣬ʵ��Runnable�ӿ�
class MyPanle extends JPanel implements Runnable
{
//����  ��ѩ���������óɳ�Ա����  ͨ�����췽�����г�ʼ��  ����ʹ��
	int [] xs = new int[300];
	int [] ys = new int[300];
	public MyPanle()
	{
		for(int i = 0;i<ys.length;i++){
			xs[i]=(int) (Math.random() * 1024);
			ys[i]=(int) (Math.random() * 768);
		}
	}
	//����ѩ��
	public void paint(Graphics g)
	{
		super.paint(g);
		this.setBackground(Color.BLACK);
		g.setColor(Color.lightGray);
		Font font = new Font("΢���ź�", Font.BOLD, 30);
		g.setFont(font);
		for (int i = 0; i < 300; i++)
		{
			
			// ��������
			g.drawString("*", xs[i], ys[i]);
		}
	}

	// ʵ���˶�Ч��
	@Override
	public void run()
	{
		while(true)
		{
			//�ı�1.�ı�y������
			for (int i = 0; i < ys.length; i++)
			{
				ys[i]++;
				//���� �ж������Ƿ񳬳��߽�
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
			//�ػ棺���µ���paint()����
			repaint();
			
		}

	}

}
