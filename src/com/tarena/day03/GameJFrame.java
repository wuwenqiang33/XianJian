package com.tarena.day03;

import javax.swing.JFrame;

//	1.�����ࣺ
public class GameJFrame
{
	public static void main(String[] args)
	{
		JFrame gameFrame = new JFrame();
//	��С
		gameFrame.setSize(1024, 768);
//	����Title
		gameFrame.setTitle("�ɽ���������Ϸ1.0");
//	����
		gameFrame.setLocationRelativeTo(null);
//	�رշ�ʽ
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//������Ϸ��������봰�ڶ������
		GamePanel gamePanel = new GamePanel();
		gameFrame.add(gamePanel);
		// �����̶߳��󣬹���������󣬲������̶߳���
		Thread thread1 = new Thread(gamePanel);
		thread1.start();
		//�� listener
				gameFrame.addKeyListener(gamePanel);
				gamePanel.addKeyListener(gamePanel);
//	�ɼ���
		gameFrame.setVisible(true);
		
		
	}

}
