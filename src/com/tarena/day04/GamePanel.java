package com.tarena.day04;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.tarena.oop.AWangShen;
import com.tarena.oop.AZhuWeiJi;
import com.tarena.oop.TiaoSheng;
import com.tarena.oop.WCaiSao;

/**
 * 
 * @author Administrator Runnable,KeyListener
 */
public class GamePanel extends JPanel implements Runnable, KeyListener
{

	// 障碍物功能 ---未完成11
	// 定义李家村数据地图的相关属性
	BufferedImage ljcDataMap;
	BufferedImage ljcscDataMap;
	// 切换场景 定义李家村市场相关属性---未完成10
	private int mapType;
	private Image ljcscImage;
	int ljcscX;
	int ljcscY;
	boolean a = true;
	// 定义聊天功能属性 --- 未完成 9 已完成阿旺嫂
	private Image chatImage;
	private String chatString;
	private String[] chatStrings;
	private int chatX;
	private int chatY;
	private boolean chatMS;
	private int chatIndex;
	//
	int xiaoyDir;
	// 定义原始坐标
	private int oX;
	private int oY;
	// 李家村相关属性
	private Image ljcImage;
	private int ljcX;
	private int ljcY;
	// 阿旺嫂相关属性 ---完成1
	AWangShen aws;
	// 阿朱喂鸡相关属性 ---完成2
	AZhuWeiJi azwj;
	// 旺财嫂相关属性 ---完成3
	WCaiSao wcs;
	// 母鸡相关属性 ---完成4
	private List<Image> mjImages;
	private Image mjImage;
	private int mjX;
	private int mjY;
	private int mjIndex;
	// 小鸡相关属性 ---完成5
	private List<Image> xjImages;
	private Image xjImage;
	private int xjX;
	private int xjY;
	private int xjIndex;
	// 小小鸡相关属性 ---完成6
	private List<Image> xxjImages;
	private Image xxjImage;
	private int xxjX;
	private int xxjY;
	private int xxjIndex;
	// 跳绳相关属性 ---完成7
	private TiaoSheng ts;
	// 李逍遥相关属性---完成8
	private List<Image> xiaoyRs;
	private List<Image> xiaoyLs;
	private List<Image> xiaoySs;
	private List<Image> xiaoyXs;
	private Image xiaoyImage;
	private int xiaoyRIndex;
	private int xiaoyLIndex;
	private int xiaoySIndex;
	private int xiaoyXIndex;
	private int xiaoyx;
	private int xiaoyy;
	// 逍遥速度控制
	private int speed = 5;

	public GamePanel()
	{
		try
		{
			// 切换场景 初始化---未完成 10
			mapType = 1;
			ljcscX = -200;
			ljcscY = -200;
			ljcscImage = GameUtil.GetImageForName("李家村市场/0");
			// 初始化聊天功能属性 ---未完成 9 已完成阿旺嫂对话
			chatImage = GameUtil.GetImageForName("对话框/0");
			chatString = "你好啊！！！";
			chatMS = false;
			chatStrings = new String[5];
			chatIndex = 0;
			chatStrings[0] = "逍遥：你好阿旺嫂！";
			chatStrings[1] = "逍遥：听说这里有蛇妖出没，你知道她在哪了吗？";
			chatStrings[2] = "阿旺嫂：好像前村有个山洞，你可以去那里看看。";
			chatStrings[3] = "阿旺嫂：不过那山洞被道人封住了,你要去道人那拿解封符。";
			chatStrings[4] = "逍遥：好的！再见阿旺嫂。";
			// 调整
			oX = 235;
			oY = 270;
			// 初始李逍遥相关属性---完成8
			xiaoyx = 755;
			xiaoyy = 610;
			xiaoyRIndex = 0;
			xiaoyLIndex = 0;
			xiaoySIndex = 0;
			xiaoyXIndex = 0;
			xiaoyImage = ImageIO.read(new File("素材/李逍遥右/0.png"));
			xiaoyRs = GameUtil.GetImagesForNameAndNumber("李逍遥右", 8);
			xiaoyLs = GameUtil.GetImagesForNameAndNumber("李逍遥左", 8);
			xiaoySs = GameUtil.GetImagesForNameAndNumber("李逍遥上", 8);
			xiaoyXs = GameUtil.GetImagesForNameAndNumber("李逍遥下", 8);
			// 初始阿朱喂鸡相关属性2
			azwj = new AZhuWeiJi(210 + oX, 200 + oY);
			// 初始旺财嫂相关属性3
			wcs = new WCaiSao(830, 500);
			// 初始母鸡相关属性4
			mjX = 240 + oX;
			mjY = 300 + oY;
			mjIndex = 0;
			mjImages = GameUtil.GetImagesForNameAndNumber("母鸡", 6);
			// 初始小鸡相关属性5
			xjX = 260 + oX;
			xjY = 290 + oY;
			xjIndex = 0;
			xjImages = GameUtil.GetImagesForNameAndNumber("小鸡", 2);
			// 初始小小鸡相关属性6
			xxjX = 270 + oX;
			xxjY = 280 + oY;
			xxjIndex = 0;
			xxjImages = GameUtil.GetImagesForNameAndNumber("小小鸡", 2);
			// 初始跳绳相关属性7 670 + oX,375 + oY
			ts = new TiaoSheng(670 + oX,375 + oY);
			// 初始化李家村相关属性
			ljcImage = GameUtil.GetImageForName("李家村/0");
			ljcX = -250 + oX;
			ljcY = -250 + oY;
			// 初始化阿旺嫂相关属性---完成1
			aws = new AWangShen(360 + 235, 340 + 270);
			/*
			 * awsX = 360 + oX; awsY = 340 + oY; awsIndex = 0; awsImages =
			 * GameUtil.GetImagesForNameAndNumber("阿旺婶", 17);
			 */
			// 初始化李家村数据地图---完成11
			ljcDataMap = (BufferedImage) GameUtil.GetImageForName("李家村/RedMap");
			// 初始化李家村市场数据地图
			ljcscDataMap = (BufferedImage) GameUtil
					.GetImageForName("李家村市场/RedMap");
			// 将阿旺嫂画到ljcDataMap上
			for (int i = aws.x; i <= aws.x + aws.imageWidth; i++)
			{
				for (int j = aws.y; j <= aws.y + aws.imageHeight; j++)
				{
					// 画圆形
					if (GameUtil.hasHuaYuanOfPoint(aws.x, aws.y, i, j,
							aws.imageWidth, aws.imageHeight))
					{
						ljcDataMap.setRGB(i, j, -521461);
					}
				}
			}

			// 将wcs画到ljcDataMap上
			for (int i = wcs.x; i <= wcs.x + wcs.imageWidth; i++)
			{
				for (int j = wcs.y; j <= wcs.y + wcs.imageHeight; j++)
				{
					// 画圆形
					if (GameUtil.hasHuaYuanOfPoint(wcs.x, wcs.y, i, j,
							wcs.imageWidth, wcs.imageHeight))
					{
						ljcDataMap.setRGB(i, j, -521461);
					}
				}
			}

			// 将azwj画到ljcDataMap上
			for (int i = azwj.x; i <= azwj.y + azwj.imageWidth; i++)
			{
				for (int j = azwj.y; j <= azwj.y + azwj.imageHeight; j++)
				{
					// 画圆形
					if (GameUtil.hasHuaYuanOfPoint(azwj.x, azwj.y, i, j,
							azwj.imageWidth, azwj.imageHeight))
					{
						ljcDataMap.setRGB(i, j, -521461);
					}
				}
			}

			// 将ts画到ljcDataMap上
			for (int i = ts.x; i <= ts.x + ts.imageWidth; i++)
			{
				for (int j = ts.y; j <= ts.y + ts.imageHeight; j++)
				{

					// 画圆形
					if (GameUtil.hasHuaYuanOfPoint(ts.x, ts.y, i, j,
							ts.imageWidth, ts.imageHeight))
					{
						ljcDataMap.setRGB(i, j, -521461);
					}
				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	// 绘画方法
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		// 1.绘画游戏程序的静态界面
		// 绘画方法优化：
		// 先将李家村以及所有角色绘画到缓冲区域
		// 在将缓冲区域中的所有内容一次性画到画板
		// 创建缓冲区域
		BufferedImage bImage = new BufferedImage(1024, 768,
				BufferedImage.TYPE_INT_ARGB);
		// 创建缓冲区域画笔
		Graphics bG = bImage.getGraphics();
		// ----10----场景切换
		if (mapType == 1)
		{
			// 1.将李家村等图片的内容绘画到 缓冲区域
			// 补充：更新ljcX或者ljcY的值（受李逍遥运动的影响）
			ljcX = (1025 - 60) / 2 - xiaoyx;
			ljcY = (768 - 108) / 2 - xiaoyy;
			// 考虑：李家村地图边界问题
			if (ljcX >= 0)
			{
				ljcX = 0;
			} else if (ljcX <= this.getWidth() - ljcImage.getWidth(null))
			{
				ljcX = this.getWidth() - ljcImage.getWidth(null);

			}
			if (ljcY >= 0)
			{
				ljcY = 0;
			} else if (ljcY <= this.getHeight() - ljcImage.getHeight(null))
			{
				ljcY = this.getHeight() - ljcImage.getHeight(null);

			}
			bG.drawImage(ljcImage, ljcX, ljcY, null);
			// 将阿旺嫂图片的内容绘画到画板上---完成1
			bG.drawImage(aws.images.get(aws.imagesIndex % aws.images.size()),
					aws.x + ljcX, aws.y + ljcY, null);
			// 将阿朱喂鸡图片的内容绘画到画板上---完成2
			bG.drawImage(
					azwj.images.get(azwj.imagesIndex % azwj.images.size()),
					azwj.x + ljcX, azwj.y + ljcY, null);
			// 将旺财嫂图片的内容绘画到画板上---完成3
			bG.drawImage(wcs.images.get(wcs.imagesIndex % wcs.images.size()),
					wcs.x + ljcX, wcs.y + ljcY, null);
			// 将母鸡图片的内容绘画到画板上---完成4
			bG.drawImage(mjImage, mjX + ljcX, mjY + ljcY, null);
			// 将小鸡图片的内容绘画到画板上---完成5
			bG.drawImage(xjImage, xjX + ljcX, xjY + ljcY, null);
			// 将小小鸡图片的内容绘画到画板上---完成6
			bG.drawImage(xxjImage, xxjX + ljcX, xxjY + ljcY, null);
			// 将跳绳图片的内容绘画到画板上---完成7
			bG.drawImage(ts.images.get(ts.imagesIndex%ts.images.size()), ts.x + ljcX, ts.y + ljcY, null);

			// 将对话框画到画板上 --- 未完成9
			if (chatMS)
			{
				chatX = (this.getWidth() - chatImage.getWidth(null)) / 2;
				chatY = this.getHeight() - chatImage.getHeight(null);
				bG.drawImage(chatImage, chatX, chatY, null);
				bG.drawString(chatString, chatX + 20, chatY + 50);
			}
			// 将李逍遥图片的内容绘画到画板上---完成8
			// 考虑李逍遥边界问题
			if (xiaoyx <= 0)
			{
				xiaoyx = 0;
			} else if (xiaoyx >= this.getWidth() - xiaoyImage.getWidth(null)
					- ljcX)
			{
				xiaoyx = this.getWidth() - xiaoyImage.getWidth(null) - ljcX;
			}
			if (xiaoyy <= 0)
			{
				xiaoyy = 0;
			} else if (xiaoyy >= this.getHeight() - xiaoyImage.getHeight(null)
					- ljcY)
			{
				xiaoyy = this.getHeight() - xiaoyImage.getHeight(null) - ljcY;
			}
			bG.drawImage(xiaoyImage, xiaoyx + ljcX, xiaoyy + ljcY, null);
		} else
		{// -------李家村市场------
			// 根据场景绘图

			ljcDataMap = (BufferedImage) GameUtil.GetImageForName("李家村市场/RedMap");
			// 补充：更新ljcscX或者ljcscY的值（受李逍遥运动的影响）
			ljcscX = (1025 - 60) / 2 - xiaoyx;
			ljcscY = (768 - 108) / 2 - xiaoyy;
			// 考虑：李家村市场地图边界问题
			if (ljcscX >= 0)
			{
				ljcscX = 0;
			} else if (ljcscX <= this.getWidth() - ljcscImage.getWidth(null))
			{
				ljcscX = this.getWidth() - ljcscImage.getWidth(null);

			}
			if (ljcscY >= 0)
			{
				ljcscY = 0;
			} else if (ljcscY <= this.getHeight() - ljcscImage.getHeight(null))
			{
				ljcscY = this.getHeight() - ljcscImage.getHeight(null);

			}
			bG.drawImage(ljcscImage, ljcscX, ljcscY, null);
			// 考虑李逍遥边界问题
			if (xiaoyx <= 0)
			{
				xiaoyx = 0;
			} else if (xiaoyx >= this.getWidth() - xiaoyImage.getWidth(null)
					- ljcscX)
			{
				xiaoyx = this.getWidth() - xiaoyImage.getWidth(null) - ljcscX;
			}
			if (xiaoyy <= 0)
			{
				xiaoyy = 0;
			} else if (xiaoyy >= this.getHeight() - xiaoyImage.getHeight(null)
					- ljcscY)
			{
				xiaoyy = this.getHeight() - xiaoyImage.getHeight(null) - ljcscY;
			}
			bG.drawImage(xiaoyImage, xiaoyx + ljcscX, xiaoyy + ljcscY, null);
			if (a)// 初始化逍遥进图后的位置
			{
				xiaoyx = 10;
				xiaoyy = 700;
				a = false;
			}
			repaint();

		}
		// 2.将缓冲区域内容画到画板上
		g.drawImage(bImage, 0, 0, null);
		g.drawImage(ljcDataMap, ljcX, ljcY, null);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{

		int keyCode = e.getKeyCode();
		// 添加聊天功能---9完成
		// System.out.println("keyCode:"+keyCode); //空格32 回车10
		// 聊天控制
		if (chatMS)
		{// ---------聊天模式--------------
			// 此时是聊天模式，可以进行聊天模式切换+结束聊天
			// 使用空格按键实现聊天内容的切换和消失
			// 补充思考：聊天内容的自动换行功能
			// 1.当前字体下每行多少字
			if (keyCode == KeyEvent.VK_SPACE)
			{
				if (chatIndex >= chatStrings.length)
				{
					chatIndex = 0;
					chatMS = false;
				}
				chatString = chatStrings[chatIndex];
				chatIndex++;
			}
		} else
		{// --------非聊天模式-----------------
			if (keyCode == KeyEvent.VK_LEFT)
			{
				// 左
				xiaoyImage = xiaoyLs.get(xiaoyLIndex % xiaoyLs.size());
				xiaoyLIndex++;
				xiaoyx -= speed;
				// 方向
				xiaoyDir = KeyEvent.VK_LEFT;

				// 实现李逍遥运动过程中障碍物无法通过的功能 ---未完成11
				// if(逍遥左下角点在李家村数据地图上的颜色==红色)
				if (ljcDataMap.getRGB(xiaoyx,
						xiaoyy + xiaoyImage.getHeight(null) - 15) == ljcDataMap
						.getRGB(10, 10))
				{
					// 此时已经进入障碍物区 需要回退
					xiaoyx += speed;
				}

				repaint();
			} else if (keyCode == KeyEvent.VK_UP)
			{
				// 上
				xiaoyImage = xiaoySs.get(xiaoySIndex % xiaoySs.size());
				xiaoySIndex++;
				xiaoyy -= speed;
				xiaoyDir = KeyEvent.VK_UP;
				// 实现李逍遥运动过程中障碍物无法通过的功能 ---未完成11
				// if(逍遥 最低边中间的点 点在李家村数据地图上的颜色==红色)
				if (ljcDataMap.getRGB(xiaoyx + xiaoyImage.getWidth(null) / 2,
						xiaoyy + xiaoyImage.getHeight(null) - 15) == -521461)
				{
					// 此时已经进入障碍物区 需要回退
					xiaoyy += speed;
				}
				repaint();
			} else if (keyCode == KeyEvent.VK_RIGHT)
			{
				// 右
				xiaoyImage = xiaoyRs.get(xiaoyRIndex % xiaoyRs.size());
				xiaoyRIndex++;
				xiaoyx += speed;
				xiaoyDir = KeyEvent.VK_RIGHT;
				// 实现李逍遥运动过程中障碍物无法通过的功能 ---未完成11
				// if(逍遥左下角点在李家村数据地图上的颜色==红色)
				if (ljcDataMap.getRGB(xiaoyx + xiaoyImage.getWidth(null),
						xiaoyy + xiaoyImage.getHeight(null) - 15) == -521461)
				{
					// 此时已经进入障碍物区 需要回退
					xiaoyx -= speed;
				}
				repaint();
			} else if (keyCode == KeyEvent.VK_DOWN)
			{
				// 下
				xiaoyImage = xiaoyXs.get(xiaoyXIndex % xiaoyXs.size());
				xiaoyXIndex++;
				xiaoyy += speed;
				xiaoyDir = KeyEvent.VK_DOWN;
				// 实现李逍遥运动过程中障碍物无法通过的功能 ---未完成11
				// if(逍遥左下角点在李家村数据地图上的颜色==红色)
				if (ljcDataMap.getRGB(xiaoyx + xiaoyImage.getWidth(null) / 2,
						xiaoyy + xiaoyImage.getHeight(null) - 15) == -521461)
				{
					// 此时已经进入障碍物区 需要回退
					xiaoyy -= speed;
				}
				repaint();
			} else if (keyCode == KeyEvent.VK_SPACE)
			{ // 按空格 打开或关闭 对话框
				// 实现聊天功能开启和关闭
				// 1.方向问题 2.距离问题
				if (xiaoyDir == KeyEvent.VK_LEFT)
				{
					// 距离
					int x = xiaoyx;
					int y = xiaoyy;

					int x2 = aws.x + aws.imageWidth;// 阿旺嫂 右下角坐标
					int y2 = aws.y + aws.imageHeight - 100;

					int x1 = x2 - 30;// 阿旺嫂 右下角坐标
					int y1 = y2 - 30;

					if (x >= x1 && x <= x2 && y >= y1 && y <= y2)
					{
						chatMS = true;
						repaint();
					}
				}
			} else if (keyCode == KeyEvent.VK_ENTER)
			{// 在非聊天模式下 在指定位置按下回车键 进行场景切换
				// 切换场景 --- 未完成 10
				if (xiaoyx >= 150 && xiaoyx <= 170 && xiaoyy >= 695 // X:160,Y:705
						&& xiaoyy <= 715) // 判断是否到达指定位置
				{
					mapType = 2;
				}
			}
		}
		// System.out.println("李家村坐标(X:" + ljcX + ",Y:" + ljcY + ")");
		System.out.println("李逍遥坐标(X:" + xiaoyx + ",Y:" + xiaoyy + ")");
		System.out.println("阿旺嫂坐标(X:" + aws.x + ",Y:" + aws.y + ")");
	}

	@Override
	public void keyReleased(KeyEvent e)
	{

	}

	@Override
	public void run()
	{
		// 动起来
		while (true)
		{
			// 阿旺嫂运动---完成1
			aws.imagesIndex++;
			// 将阿朱喂鸡图片的内容绘画到画板上---完成2
			azwj.imagesIndex++;
			// 将旺财嫂图片的内容绘画到画板上---完成3
			wcs.imagesIndex++;
			// 将母鸡图片的内容绘画到画板上---完成4
			mjImage = mjImages.get(mjIndex % mjImages.size());
			mjIndex++;
			// 将小鸡图片的内容绘画到画板上---完成5
			xjImage = xjImages.get(xjIndex % xjImages.size());
			xjIndex++;
			// 将小小鸡图片的内容绘画到画板上---完成6
			xxjImage = xxjImages.get(xxjIndex % xxjImages.size());
			xxjIndex++;
			// 将跳绳图片的内容绘画到画板上---完成7
			ts.imagesIndex++;
			repaint();
			try
			{
				Thread.sleep(200);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

	}

}
