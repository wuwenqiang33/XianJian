package com.tarena.day04;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//	1.窗口类：
public class GameJFrame
{
	public static void main(String[] args)
	{
		JFrame gameFrame = new JFrame();
		// 大小
		gameFrame.setSize(1024, 768);
		// 标题Title
		gameFrame.setTitle("仙剑奇侠传游戏1.0");
		// 居中
		gameFrame.setLocationRelativeTo(null);
		// 关闭方式
		gameFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		gameFrame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				int number = JOptionPane.showConfirmDialog(null, "退出？","退出",JOptionPane.YES_NO_OPTION);
				if(number ==JOptionPane.YES_OPTION){
					//结束游戏
					System.exit(0);
				}
			}
		});// 添加退出是确认对话框
			// 创建游戏画板对象，与窗口对象关联
		GamePanel gamePanel = new GamePanel();
		gameFrame.add(gamePanel);
		// 创建线程对象，关联画板对象，并启动线程对象
		Thread thread1 = new Thread(gamePanel);
		thread1.start();
		// 绑定 listener
		gameFrame.addKeyListener(gamePanel);
		gamePanel.addKeyListener(gamePanel);
		// 可见性
		gameFrame.setVisible(true);

	}

}
