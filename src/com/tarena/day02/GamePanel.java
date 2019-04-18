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
	// ����ԭʼ����
	private int x;
	private int y;
	// ��Ҵ��������
	private Image ljcImage;
	private int ljcX;
	private int ljcY;
	// ����ɩ������� ---���1
	List<Image> awsImages;
	private Image awsImage;
	private int awsX;
	private int awsY;
	private int awsIndex;
	// ����ι��������� ---���2
	private List<Image> azwjImages;
	private Image azwjImage;
	private int azwjX;
	private int azwjY;
	private int azwjIndex;
	// ����ɩ������� ---���3
	private List<Image> wcsImages;
	private Image wcsImage;
	private int wcsX;
	private int wcsY;
	private int wcsIndex;
	// ĸ��������� ---���4
	private List<Image> mjImages;
	private Image mjImage;
	private int mjX;
	private int mjY;
	private int mjIndex;
	// С��������� ---���5
	private List<Image> xjImages;
	private Image xjImage;
	private int xjX;
	private int xjY;
	private int xjIndex;
	// СС��������� ---���6
	private List<Image> xxjImages;
	private Image xxjImage;
	private int xxjX;
	private int xxjY;
	private int xxjIndex;
	// ����������� ---���7
	private List<Image> tsImages;
	private Image tsImage;
	private int tsX;
	private int tsY;
	private int tsIndex;
	// ����ң�������---���8
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
	// ��ң�ٶȿ���

	private int speed = 5;
	private int flag = 0;

	public GamePanel()
	{
		try
		{
			// ��ʼ��ԭʼ����
			x = 0;
			y = 0;
			// ��ʼ����ң�������---���8
			xiaoyx = 515;
			xiaoyy = 390;
			xiaoyRIndex = 0;
			xiaoyLIndex = 0;
			xiaoySIndex = 0;
			xiaoyXIndex = 0;
			xiaoyImage = ImageIO.read(new File("�ز�/����ң��/0.png"));
			xiaoyRs = GameUtil.GetImagesForNameAndNumber("����ң��", 8);
			xiaoyLs = GameUtil.GetImagesForNameAndNumber("����ң��", 8);
			xiaoySs = GameUtil.GetImagesForNameAndNumber("����ң��", 8);
			xiaoyXs = GameUtil.GetImagesForNameAndNumber("����ң��", 8);
			// ��ʼ����ι���������2
			azwjX = 210+x;
			azwjY = 200+y;
			azwjIndex = 0;
			azwjImages = GameUtil.GetImagesForNameAndNumber("����ι��", 6);
			// ��ʼ����ɩ�������3
			wcsX = 600+x;
			wcsY = 235+y;
			wcsIndex = 0;
			wcsImages = GameUtil.GetImagesForNameAndNumber("����ɩ", 14);
			// ��ʼĸ���������4
			mjX = 240+x;
			mjY = 300+y;
			mjIndex = 0;
			mjImages = GameUtil.GetImagesForNameAndNumber("ĸ��", 6);
			// ��ʼС���������5
			xjX = 260+x;
			xjY = 290+y;
			xjIndex = 0;
			xjImages = GameUtil.GetImagesForNameAndNumber("С��", 2);
			// ��ʼСС���������6
			xxjX = 270+x;
			xxjY = 280+y;
			xxjIndex = 0;
			xxjImages = GameUtil.GetImagesForNameAndNumber("СС��", 2);
			// ��ʼ�����������7
			tsX = 670+x;
			tsY = 375+y;
			tsIndex = 0;
			tsImages = GameUtil.GetImagesForNameAndNumber("����", 4);
			// ��ʼ����Ҵ��������
			ljcImage = GameUtil.GstImageForName("��Ҵ�/0");
			ljcX = -250+x;
			ljcY = -250+y;
			// ��ʼ������ɩ�������---���1
			awsX = 360+x;
			awsY = 340+y;
			awsIndex = 0;
			awsImages = GameUtil.GetImagesForNameAndNumber("������", 17);
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	// �滭����
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		// 1.�滭��Ϸ����ľ�̬����
		// �滭�����Ż���
		// �Ƚ���Ҵ��Լ����н�ɫ�滭����������
		// �ڽ����������е���������һ���Ի�������
		// ������������
		BufferedImage bImage = new BufferedImage(1024, 768,
				BufferedImage.TYPE_INT_ARGB);
		// �����������򻭱�
		Graphics bG = bImage.getGraphics();
		// 1.����Ҵ��ͼƬ�����ݻ滭�� ��������
		bG.drawImage(ljcImage, ljcX, ljcY, null);
		// ������ɩͼƬ�����ݻ滭��������---���1
		bG.drawImage(awsImage, awsX, awsY, null);
		// ������ι��ͼƬ�����ݻ滭��������---���2
		bG.drawImage(azwjImage, azwjX, azwjY, null);
		// ������ɩͼƬ�����ݻ滭��������---���3
		bG.drawImage(wcsImage, wcsX, wcsY, null);
		// ��ĸ��ͼƬ�����ݻ滭��������---���4
		bG.drawImage(mjImage, mjX, mjY, null);
		// ��С��ͼƬ�����ݻ滭��������---���5
		bG.drawImage(xjImage, xjX, xjY, null);
		// ��СС��ͼƬ�����ݻ滭��������---���6
		bG.drawImage(xxjImage, xxjX, xxjY, null);
		// ������ͼƬ�����ݻ滭��������---���7
		bG.drawImage(tsImage, tsX, tsY, null);
		// ������ңͼƬ�����ݻ滭��������---���8
		bG.drawImage(xiaoyImage, xiaoyx, xiaoyy, null);

		// 2.�������������ݻ���������
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
			// ��
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
				// ��ͼ��
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
			// ��
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
			// ��
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
			// ��
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
		System.out.println("��Ҵ�����(X:" + ljcX + ",Y:" + ljcY + ")");
		System.out.println("����ң����(X:" + xiaoyx + ",Y:" + xiaoyy + ")");
	}

	@Override
	public void keyReleased(KeyEvent e)
	{

	}

	@Override
	public void run()
	{
		// ������
		while (true)
		{
			// ����ɩ�˶�---���1
			awsImage = awsImages.get(awsIndex % awsImages.size());
			awsIndex++;
			// ������ι��ͼƬ�����ݻ滭��������---���2
			azwjImage = azwjImages.get(azwjIndex % azwjImages.size());
			azwjIndex++;
			// ������ɩͼƬ�����ݻ滭��������---���3
			wcsImage = wcsImages.get(wcsIndex % wcsImages.size());
			wcsIndex++;
			// ��ĸ��ͼƬ�����ݻ滭��������---���4
			mjImage = mjImages.get(mjIndex % mjImages.size());
			mjIndex++;
			// ��С��ͼƬ�����ݻ滭��������---���5
			xjImage = xjImages.get(xjIndex % xjImages.size());
			xjIndex++;
			// ��СС��ͼƬ�����ݻ滭��������---���6
			xxjImage = xxjImages.get(xxjIndex % xxjImages.size());
			xxjIndex++;
			// ������ͼƬ�����ݻ滭��������---���7
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
