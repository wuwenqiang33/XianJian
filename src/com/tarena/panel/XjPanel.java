package com.tarena.panel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import com.tarena.day01.MyGame;

//2.创建阿旺嫂Panle对象
//自定义Panle，继承Panle类，实现Runnable接口
public class XjPanel extends Panel implements Runnable
{
	public List<Image> xjs;
	public Image xj;

	public XjPanel()
	{
		xjs = new ArrayList<Image>();
		// 存入小鸡
		for (int i = 0; i <= 1; i++)
		{
			Image xjImage = Toolkit.getDefaultToolkit().getImage(
					MyGame.class.getResource("xj" + i + ".png"));
			xjs.add(xjImage);
		}
	}

	@Override
	public void paint(Graphics g)
	{

		g.drawImage(xj, 210, 200, null);//小鸡
	}

	// 实现运动效果
	@Override
	public void run()
	{

		while(true){
			//小鸡
			if (xjs.size() > 0)
			{

				for (int i = 0; i < xjs.size(); i++)
				{
					xj = xjs.get(i);
					repaint();
					try
					{
						Thread.sleep(100);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
		
		
	}

}
