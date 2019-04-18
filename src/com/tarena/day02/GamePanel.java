package com.tarena.day02;

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
	// 定义原始坐标
	private int x;
	private int y;
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
			// 初始化原始坐标
			x = 0;
			y = 0;
			// 初始李逍遥相关属性---完成8
			xiaoyx = 515;
			xiaoyy = 390;
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
			azwjX = 210+x;
			azwjY = 200+y;
			azwjIndex = 0;
			azwjImages = GameUtil.GetImagesForNameAndNumber("阿朱喂鸡", 6);
			// 初始旺财嫂相关属性3
			wcsX = 600+x;
			wcsY = 235+y;
			wcsIndex = 0;
			wcsImages = GameUtil.GetImagesForNameAndNumber("旺财嫂", 14);
			// 初始母鸡相关属性4
			mjX = 240+x;
			mjY = 300+y;
			mjIndex = 0;
			mjImages = GameUtil.GetImagesForNameAndNumber("母鸡", 6);
			// 初始小鸡相关属性5
			xjX = 260+x;
			xjY = 290+y;
			xjIndex = 0;
			xjImages = GameUtil.GetImagesForNameAndNumber("小鸡", 2);
			// 初始小小鸡相关属性6
			xxjX = 270+x;
			xxjY = 280+y;
			xxjIndex = 0;
			xxjImages = GameUtil.GetImagesForNameAndNumber("小小鸡", 2);
			// 初始跳绳相关属性7
			tsX = 670+x;
			tsY = 375+y;
			tsIndex = 0;
			tsImages = GameUtil.GetImagesForNameAndNumber("跳绳", 4);
			// 初始化李家村相关属性
			ljcImage = GameUtil.GstImageForName("李家村/0");
			ljcX = -250+x;
			ljcY = -250+y;
			// 初始化阿旺嫂相关属性---完成1
			awsX = 360+x;
			awsY = 340+y;
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
		bG.drawImage(ljcImage, ljcX, ljcY, null);
		// 将阿旺嫂图片的内容绘画到画板上---完成1
		bG.drawImage(awsImage, awsX, awsY, null);
		// 将阿朱喂鸡图片的内容绘画到画板上---完成2
		bG.drawImage(azwjImage, azwjX, azwjY, null);
		// 将旺财嫂图片的内容绘画到画板上---完成3
		bG.drawImage(wcsImage, wcsX, wcsY, null);
		// 将母鸡图片的内容绘画到画板上---完成4
		bG.drawImage(mjImage, mjX, mjY, null);
		// 将小鸡图片的内容绘画到画板上---完成5
		bG.drawImage(xjImage, xjX, xjY, null);
		// 将小小鸡图片的内容绘画到画板上---完成6
		bG.drawImage(xxjImage, xxjX, xxjY, null);
		// 将跳绳图片的内容绘画到画板上---完成7
		bG.drawImage(tsImage, tsX, tsY, null);
		// 将李逍遥图片的内容绘画到画板上---完成8
		bG.drawImage(xiaoyImage, xiaoyx, xiaoyy, null);

		// 2.将缓冲区域内容画到画板上
		g.drawImage(bImage, 0, 0, null);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{

		int keyCode = e.getKeyCode();

		if (keyCode == 37)
		{
			// 左
			xiaoyImage = xiaoyLs.get(xiaoyLIndex % xiaoyLs.size());
			xiaoyLIndex++;
			if (ljcX >= 0 || (xiaoyx != 515))
			{
				xiaoyx -= speed;
				if (xiaoyx <= 0)
				{
					xiaoyx = 0;
				}
			} else
			{
				// 地图动
				ljcX += speed;
				awsX += speed;
				azwjX += speed;
				xjX += speed;
				xxjX += speed;
				mjX += speed;
				wcsX += speed;
				tsX += speed;
//				x += speed;

			}
		} else if (keyCode == 38)
		{
			// 上
			xiaoyImage = xiaoySs.get(xiaoySIndex % xiaoySs.size());
			xiaoySIndex++;

			if (ljcY >= 0 || xiaoyy != 315)
			{
				xiaoyy -= speed;
				if (xiaoyy <= 0)
				{
					xiaoyy = 0;
				}
			} else
			{
				ljcY += speed;
				awsY += speed;
				azwjY += speed;
				xjY += speed;
				xxjY += speed;
				mjY += speed;
				wcsY += speed;
				tsY += speed;
//				y+=speed;
			}
		} else if (keyCode == 39)
		{
			// 右
			xiaoyImage = xiaoyRs.get(xiaoyRIndex % xiaoyRs.size());
			xiaoyRIndex++;
			if (ljcX <= -880 || (xiaoyx != 515))
			{
				xiaoyx += speed;
				if (xiaoyx >= 960)
				{
					xiaoyx = 960;
				}
			} else
			{
				ljcX -= speed;
				awsX -= speed;
				azwjX -= speed;
				xjX -= speed;
				xxjX -= speed;
				mjX -= speed;
				wcsX -= speed;
				tsX -= speed;
			}
		} else if (keyCode == 40)
		{
			// 下
			xiaoyImage = xiaoyXs.get(xiaoyXIndex % xiaoyXs.size());
			xiaoyXIndex++;

			if (ljcY <= -710 || xiaoyy != 315)
			{
				xiaoyy += speed;
				if (xiaoyy >= 630)
				{
					xiaoyy = 630;
				}
			} else
			{
				ljcY -= speed;
				awsY -= speed;
				azwjY -= speed;
				xjY -= speed;
				xxjY -= speed;
				mjY -= speed;
				wcsY -= speed;
				tsY -= speed;
			}
		}
		repaint();
		System.out.println("李家村坐标(X:" + ljcX + ",Y:" + ljcY + ")");
		System.out.println("李逍遥坐标(X:" + xiaoyx + ",Y:" + xiaoyy + ")");
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
