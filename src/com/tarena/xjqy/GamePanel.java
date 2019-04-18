package com.tarena.xjqy;

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

/**
 * 
 * @author Administrator Runnable,KeyListener
 */
public class GamePanel extends JPanel implements Runnable, KeyListener
{
	// 切换场景：---未完成10
	private int cjContrIndex;
	private Image cj2Image;
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
	List<Image> awsImages;
	private Image awsImage;
	private int awsX;
	private int awsY;
	private int awsIndex;
	// 阿朱喂鸡相关属性 ---完成2
	private List<Image> azwjImages;
	private Image azwjImage;
	private int azwjX;
	private int azwjY;
	private int azwjIndex;
	// 旺财嫂相关属性 ---完成3
	private List<Image> wcsImages;
	private Image wcsImage;
	private int wcsX;
	private int wcsY;
	private int wcsIndex;
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
	private List<Image> tsImages;
	private Image tsImage;
	private int tsX;
	private int tsY;
	private int tsIndex;
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
	private int flag = 0;

	public GamePanel()
	{
		try
		{
			// 切换场景 初始化---未完成 10
			cjContrIndex = 1;
			cj2Image = GameUtil.GstImageForName("李家村市场/0");
			// 初始化聊天功能属性 ---未完成 9 已完成阿旺嫂对话
			chatImage = GameUtil.GstImageForName("对话框/0");
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
			azwjX = 210 + oX;
			azwjY = 200 + oY;
			azwjIndex = 0;
			azwjImages = GameUtil.GetImagesForNameAndNumber("阿朱喂鸡", 6);
			// 初始旺财嫂相关属性3
			wcsX = 600 + oX;
			wcsY = 235 + oY;
			wcsIndex = 0;
			wcsImages = GameUtil.GetImagesForNameAndNumber("旺财嫂", 14);
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
			// 初始跳绳相关属性7
			tsX = 670 + oX;
			tsY = 375 + oY;
			tsIndex = 0;
			tsImages = GameUtil.GetImagesForNameAndNumber("跳绳", 4);
			// 初始化李家村相关属性
			ljcImage = GameUtil.GstImageForName("李家村/0");
			ljcX = -250 + oX;
			ljcY = -250 + oY;
			// 初始化阿旺嫂相关属性---完成1
			awsX = 360 + oX;
			awsY = 340 + oY;
			awsIndex = 0;
			awsImages = GameUtil.GetImagesForNameAndNumber("阿旺婶", 17);
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
		g.drawImage(ljcImage, ljcX, ljcY, null);
		// 将阿旺嫂图片的内容绘画到画板上---完成1
		bG.drawImage(awsImage, awsX + ljcX, awsY + ljcY, null);
		// 将阿朱喂鸡图片的内容绘画到画板上---完成2
		bG.drawImage(azwjImage, azwjX + ljcX, azwjY + ljcY, null);
		// 将旺财嫂图片的内容绘画到画板上---完成3
		bG.drawImage(wcsImage, wcsX + ljcX, wcsY + ljcY, null);
		// 将母鸡图片的内容绘画到画板上---完成4
		bG.drawImage(mjImage, mjX + ljcX, mjY + ljcY, null);
		// 将小鸡图片的内容绘画到画板上---完成5
		bG.drawImage(xjImage, xjX + ljcX, xjY + ljcY, null);
		// 将小小鸡图片的内容绘画到画板上---完成6
		bG.drawImage(xxjImage, xxjX + ljcX, xxjY + ljcY, null);
		// 将跳绳图片的内容绘画到画板上---完成7
		bG.drawImage(tsImage, tsX + ljcX, tsY + ljcY, null);

		// 将对话框画到画板上 --- 未完成9
		if (chatMS)
		{
			chatX = (this.getWidth() - chatImage.getWidth(null)) / 2;
			chatY = this.getHeight() - chatImage.getHeight(null);
			bG.drawImage(chatImage, chatX, chatY, null);
			bG.drawString(chatString, chatX + 20, chatY + 50);
		}

		// 根据场景绘图
		if (cjContrIndex == 1)
		{
			// 2.将缓冲区域内容画到画板上
			g.drawImage(bImage, 0, 0, null);
		}
		// 切换场景 --- 未完成 10
		// X:160,Y:705
		if (xiaoyx >= 150 && xiaoyx <= 170 && xiaoyy >= 695 && xiaoyy <= 715)
		{
			cjContrIndex = 2;
		}
		if (cjContrIndex == 2)
		{
			ljcImage = cj2Image;
			if (a)
			{
				xiaoyx = 10;
				xiaoyy = 700;
				a = false;
			}
			repaint();
		}

		// 将李逍遥图片的内容绘画到画板上---完成8
		// 考虑李逍遥边界问题
		if (xiaoyx <= 0)
		{
			xiaoyx = 0;
		} else if (xiaoyx >= this.getWidth() - xiaoyImage.getWidth(null) - ljcX)
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
		g.drawImage(xiaoyImage, xiaoyx + ljcX, xiaoyy + ljcY, null);
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
		{
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
		{
			if (keyCode == KeyEvent.VK_LEFT)
			{
				// 左
				xiaoyImage = xiaoyLs.get(xiaoyLIndex % xiaoyLs.size());
				xiaoyLIndex++;
				xiaoyx -= speed;
				xiaoyDir = KeyEvent.VK_LEFT;
			} else if (keyCode == KeyEvent.VK_UP)
			{
				// 上
				xiaoyImage = xiaoySs.get(xiaoySIndex % xiaoySs.size());
				xiaoySIndex++;
				xiaoyy -= speed;
				xiaoyDir = KeyEvent.VK_UP;
			} else if (keyCode == KeyEvent.VK_RIGHT)
			{
				// 右
				xiaoyImage = xiaoyRs.get(xiaoyRIndex % xiaoyRs.size());
				xiaoyRIndex++;
				xiaoyx += speed;
				xiaoyDir = KeyEvent.VK_RIGHT;
			} else if (keyCode == KeyEvent.VK_DOWN)
			{
				// 下
				xiaoyImage = xiaoyXs.get(xiaoyXIndex % xiaoyXs.size());
				xiaoyXIndex++;
				xiaoyy += speed;
				xiaoyDir = KeyEvent.VK_DOWN;
			}
			// 按空格 打开或关闭 对话框
			if (keyCode == KeyEvent.VK_SPACE)
			{
				// 实现聊天功能开启和关闭
				// 1.方向问题 2.距离问题
				if (xiaoyDir == KeyEvent.VK_LEFT)
				{
					// 距离
					int x = xiaoyx;
					int y = xiaoyy;
					int x2 = awsX + awsImage.getWidth(null);
					int y2 = awsY + awsImage.getHeight(null) - 100;
					int x1 = x2 - 30;
					int y1 = y2 - 30;
					System.out.println("x1:" + x1 + "," + y1 + "\nx:" + x + ","
							+ y + "\nx2:" + x2 + "," + y2);
					if (x >= x1 && x <= x2 && y >= y1 && y <= y2)
					{
						chatMS = true;
						repaint();
					}
				}
			}
		}
		repaint();
		// System.out.println("李家村坐标(X:" + ljcX + ",Y:" + ljcY + ")");
		System.out.println("李逍遥坐标(X:" + xiaoyx + ",Y:" + xiaoyy + ")");
		System.out.println("阿旺嫂坐标(X:" + awsX + ",Y:" + awsY + ")");
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
			awsImage = awsImages.get(awsIndex % awsImages.size());
			awsIndex++;
			// 将阿朱喂鸡图片的内容绘画到画板上---完成2
			azwjImage = azwjImages.get(azwjIndex % azwjImages.size());
			azwjIndex++;
			// 将旺财嫂图片的内容绘画到画板上---完成3
			wcsImage = wcsImages.get(wcsIndex % wcsImages.size());
			wcsIndex++;
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
			tsImage = tsImages.get(tsIndex % tsImages.size());
			tsIndex++;
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
