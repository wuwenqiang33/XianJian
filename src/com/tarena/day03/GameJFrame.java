package com.tarena.day03;

import javax.swing.JFrame;

//	1.窗口类：
public class GameJFrame
{
	public static void main(String[] args)
	{
		JFrame gameFrame = new JFrame();
//	大小
		gameFrame.setSize(1024, 768);
//	标题Title
		gameFrame.setTitle("仙剑奇侠传游戏1.0");
//	居中
		gameFrame.setLocationRelativeTo(null);
//	关闭方式
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//创建游戏画板对象，与窗口对象关联
		GamePanel gamePanel = new GamePanel();
		gameFrame.add(gamePanel);
		// 创建线程对象，关联画板对象，并启动线程对象
		Thread thread1 = new Thread(gamePanel);
		thread1.start();
		//绑定 listener
				gameFrame.addKeyListener(gamePanel);
				gamePanel.addKeyListener(gamePanel);
//	可见性
		gameFrame.setVisible(true);
		
		
	}

}
