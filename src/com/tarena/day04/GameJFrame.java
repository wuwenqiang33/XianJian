package com.tarena.day04;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//	1.�����ࣺ
public class GameJFrame
{
	public static void main(String[] args)
	{
		JFrame gameFrame = new JFrame();
		// ��С
		gameFrame.setSize(1024, 768);
		// ����Title
		gameFrame.setTitle("�ɽ���������Ϸ1.0");
		// ����
		gameFrame.setLocationRelativeTo(null);
		// �رշ�ʽ
		gameFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		gameFrame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				int number = JOptionPane.showConfirmDialog(null, "�˳���","�˳�",JOptionPane.YES_NO_OPTION);
				if(number ==JOptionPane.YES_OPTION){
					//������Ϸ
					System.exit(0);
				}
			}
		});// ����˳���ȷ�϶Ի���
			// ������Ϸ��������봰�ڶ������
		GamePanel gamePanel = new GamePanel();
		gameFrame.add(gamePanel);
		// �����̶߳��󣬹���������󣬲������̶߳���
		Thread thread1 = new Thread(gamePanel);
		thread1.start();
		// �� listener
		gameFrame.addKeyListener(gamePanel);
		gamePanel.addKeyListener(gamePanel);
		// �ɼ���
		gameFrame.setVisible(true);

	}

}
