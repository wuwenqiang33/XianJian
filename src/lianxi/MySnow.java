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
		//1.�������壬��ʼ������
		MySnow mySonw = new MySnow();
		mySonw.setSize(1024, 768);
		mySonw.setBackground(Color.black);
		mySonw.setLocationRelativeTo(null);
		//2.����Panle����
		MyPanle myPanle = new MyPanle();
		//2.��������ɩPanle����
		//3.�����̶߳��󣬹���������󣬲������̶߳���
		Thread snowThread = new Thread(myPanle);
		snowThread.start();
		//4.��Panle����ӵ�Frame��
		mySonw.add(myPanle);
		//5.�����ʾ����
		mySonw.show();

	}

}
//�Զ���Panle���̳�Panle�࣬ʵ��Runnable�ӿ�
class MyPanle extends Panel implements Runnable
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
		for (int i = 0; i < 300; i++)
		{
			
			g.setColor(Color.lightGray);
			// ��������
			Font font = new Font("΢���ź�", Font.BOLD, 30);
			g.setFont(font);
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
