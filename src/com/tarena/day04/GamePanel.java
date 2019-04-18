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

	// �ϰ��﹦�� ---δ���11
	// ������Ҵ����ݵ�ͼ���������
	BufferedImage ljcDataMap;
	BufferedImage ljcscDataMap;
	// �л����� ������Ҵ��г��������---δ���10
	private int mapType;
	private Image ljcscImage;
	int ljcscX;
	int ljcscY;
	boolean a = true;
	// �������칦������ --- δ��� 9 ����ɰ���ɩ
	private Image chatImage;
	private String chatString;
	private String[] chatStrings;
	private int chatX;
	private int chatY;
	private boolean chatMS;
	private int chatIndex;
	//
	int xiaoyDir;
	// ����ԭʼ����
	private int oX;
	private int oY;
	// ��Ҵ��������
	private Image ljcImage;
	private int ljcX;
	private int ljcY;
	// ����ɩ������� ---���1
	AWangShen aws;
	// ����ι��������� ---���2
	AZhuWeiJi azwj;
	// ����ɩ������� ---���3
	WCaiSao wcs;
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
	private TiaoSheng ts;
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

	public GamePanel()
	{
		try
		{
			// �л����� ��ʼ��---δ��� 10
			mapType = 1;
			ljcscX = -200;
			ljcscY = -200;
			ljcscImage = GameUtil.GetImageForName("��Ҵ��г�/0");
			// ��ʼ�����칦������ ---δ��� 9 ����ɰ���ɩ�Ի�
			chatImage = GameUtil.GetImageForName("�Ի���/0");
			chatString = "��ð�������";
			chatMS = false;
			chatStrings = new String[5];
			chatIndex = 0;
			chatStrings[0] = "��ң����ð���ɩ��";
			chatStrings[1] = "��ң����˵������������û����֪������������";
			chatStrings[2] = "����ɩ������ǰ���и�ɽ���������ȥ���￴����";
			chatStrings[3] = "����ɩ��������ɽ�������˷�ס��,��Ҫȥ�������ý�����";
			chatStrings[4] = "��ң���õģ��ټ�����ɩ��";
			// ����
			oX = 235;
			oY = 270;
			// ��ʼ����ң�������---���8
			xiaoyx = 755;
			xiaoyy = 610;
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
			azwj = new AZhuWeiJi(210 + oX, 200 + oY);
			// ��ʼ����ɩ�������3
			wcs = new WCaiSao(830, 500);
			// ��ʼĸ���������4
			mjX = 240 + oX;
			mjY = 300 + oY;
			mjIndex = 0;
			mjImages = GameUtil.GetImagesForNameAndNumber("ĸ��", 6);
			// ��ʼС���������5
			xjX = 260 + oX;
			xjY = 290 + oY;
			xjIndex = 0;
			xjImages = GameUtil.GetImagesForNameAndNumber("С��", 2);
			// ��ʼСС���������6
			xxjX = 270 + oX;
			xxjY = 280 + oY;
			xxjIndex = 0;
			xxjImages = GameUtil.GetImagesForNameAndNumber("СС��", 2);
			// ��ʼ�����������7 670 + oX,375 + oY
			ts = new TiaoSheng(670 + oX,375 + oY);
			// ��ʼ����Ҵ��������
			ljcImage = GameUtil.GetImageForName("��Ҵ�/0");
			ljcX = -250 + oX;
			ljcY = -250 + oY;
			// ��ʼ������ɩ�������---���1
			aws = new AWangShen(360 + 235, 340 + 270);
			/*
			 * awsX = 360 + oX; awsY = 340 + oY; awsIndex = 0; awsImages =
			 * GameUtil.GetImagesForNameAndNumber("������", 17);
			 */
			// ��ʼ����Ҵ����ݵ�ͼ---���11
			ljcDataMap = (BufferedImage) GameUtil.GetImageForName("��Ҵ�/RedMap");
			// ��ʼ����Ҵ��г����ݵ�ͼ
			ljcscDataMap = (BufferedImage) GameUtil
					.GetImageForName("��Ҵ��г�/RedMap");
			// ������ɩ����ljcDataMap��
			for (int i = aws.x; i <= aws.x + aws.imageWidth; i++)
			{
				for (int j = aws.y; j <= aws.y + aws.imageHeight; j++)
				{
					// ��Բ��
					if (GameUtil.hasHuaYuanOfPoint(aws.x, aws.y, i, j,
							aws.imageWidth, aws.imageHeight))
					{
						ljcDataMap.setRGB(i, j, -521461);
					}
				}
			}

			// ��wcs����ljcDataMap��
			for (int i = wcs.x; i <= wcs.x + wcs.imageWidth; i++)
			{
				for (int j = wcs.y; j <= wcs.y + wcs.imageHeight; j++)
				{
					// ��Բ��
					if (GameUtil.hasHuaYuanOfPoint(wcs.x, wcs.y, i, j,
							wcs.imageWidth, wcs.imageHeight))
					{
						ljcDataMap.setRGB(i, j, -521461);
					}
				}
			}

			// ��azwj����ljcDataMap��
			for (int i = azwj.x; i <= azwj.y + azwj.imageWidth; i++)
			{
				for (int j = azwj.y; j <= azwj.y + azwj.imageHeight; j++)
				{
					// ��Բ��
					if (GameUtil.hasHuaYuanOfPoint(azwj.x, azwj.y, i, j,
							azwj.imageWidth, azwj.imageHeight))
					{
						ljcDataMap.setRGB(i, j, -521461);
					}
				}
			}

			// ��ts����ljcDataMap��
			for (int i = ts.x; i <= ts.x + ts.imageWidth; i++)
			{
				for (int j = ts.y; j <= ts.y + ts.imageHeight; j++)
				{

					// ��Բ��
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
		// ----10----�����л�
		if (mapType == 1)
		{
			// 1.����Ҵ��ͼƬ�����ݻ滭�� ��������
			// ���䣺����ljcX����ljcY��ֵ��������ң�˶���Ӱ�죩
			ljcX = (1025 - 60) / 2 - xiaoyx;
			ljcY = (768 - 108) / 2 - xiaoyy;
			// ���ǣ���Ҵ��ͼ�߽�����
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
			// ������ɩͼƬ�����ݻ滭��������---���1
			bG.drawImage(aws.images.get(aws.imagesIndex % aws.images.size()),
					aws.x + ljcX, aws.y + ljcY, null);
			// ������ι��ͼƬ�����ݻ滭��������---���2
			bG.drawImage(
					azwj.images.get(azwj.imagesIndex % azwj.images.size()),
					azwj.x + ljcX, azwj.y + ljcY, null);
			// ������ɩͼƬ�����ݻ滭��������---���3
			bG.drawImage(wcs.images.get(wcs.imagesIndex % wcs.images.size()),
					wcs.x + ljcX, wcs.y + ljcY, null);
			// ��ĸ��ͼƬ�����ݻ滭��������---���4
			bG.drawImage(mjImage, mjX + ljcX, mjY + ljcY, null);
			// ��С��ͼƬ�����ݻ滭��������---���5
			bG.drawImage(xjImage, xjX + ljcX, xjY + ljcY, null);
			// ��СС��ͼƬ�����ݻ滭��������---���6
			bG.drawImage(xxjImage, xxjX + ljcX, xxjY + ljcY, null);
			// ������ͼƬ�����ݻ滭��������---���7
			bG.drawImage(ts.images.get(ts.imagesIndex%ts.images.size()), ts.x + ljcX, ts.y + ljcY, null);

			// ���Ի��򻭵������� --- δ���9
			if (chatMS)
			{
				chatX = (this.getWidth() - chatImage.getWidth(null)) / 2;
				chatY = this.getHeight() - chatImage.getHeight(null);
				bG.drawImage(chatImage, chatX, chatY, null);
				bG.drawString(chatString, chatX + 20, chatY + 50);
			}
			// ������ңͼƬ�����ݻ滭��������---���8
			// ��������ң�߽�����
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
		{// -------��Ҵ��г�------
			// ���ݳ�����ͼ

			ljcDataMap = (BufferedImage) GameUtil.GetImageForName("��Ҵ��г�/RedMap");
			// ���䣺����ljcscX����ljcscY��ֵ��������ң�˶���Ӱ�죩
			ljcscX = (1025 - 60) / 2 - xiaoyx;
			ljcscY = (768 - 108) / 2 - xiaoyy;
			// ���ǣ���Ҵ��г���ͼ�߽�����
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
			// ��������ң�߽�����
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
			if (a)// ��ʼ����ң��ͼ���λ��
			{
				xiaoyx = 10;
				xiaoyy = 700;
				a = false;
			}
			repaint();

		}
		// 2.�������������ݻ���������
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
		// ������칦��---9���
		// System.out.println("keyCode:"+keyCode); //�ո�32 �س�10
		// �������
		if (chatMS)
		{// ---------����ģʽ--------------
			// ��ʱ������ģʽ�����Խ�������ģʽ�л�+��������
			// ʹ�ÿո񰴼�ʵ���������ݵ��л�����ʧ
			// ����˼�����������ݵ��Զ����й���
			// 1.��ǰ������ÿ�ж�����
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
		{// --------������ģʽ-----------------
			if (keyCode == KeyEvent.VK_LEFT)
			{
				// ��
				xiaoyImage = xiaoyLs.get(xiaoyLIndex % xiaoyLs.size());
				xiaoyLIndex++;
				xiaoyx -= speed;
				// ����
				xiaoyDir = KeyEvent.VK_LEFT;

				// ʵ������ң�˶��������ϰ����޷�ͨ���Ĺ��� ---δ���11
				// if(��ң���½ǵ�����Ҵ����ݵ�ͼ�ϵ���ɫ==��ɫ)
				if (ljcDataMap.getRGB(xiaoyx,
						xiaoyy + xiaoyImage.getHeight(null) - 15) == ljcDataMap
						.getRGB(10, 10))
				{
					// ��ʱ�Ѿ������ϰ����� ��Ҫ����
					xiaoyx += speed;
				}

				repaint();
			} else if (keyCode == KeyEvent.VK_UP)
			{
				// ��
				xiaoyImage = xiaoySs.get(xiaoySIndex % xiaoySs.size());
				xiaoySIndex++;
				xiaoyy -= speed;
				xiaoyDir = KeyEvent.VK_UP;
				// ʵ������ң�˶��������ϰ����޷�ͨ���Ĺ��� ---δ���11
				// if(��ң ��ͱ��м�ĵ� ������Ҵ����ݵ�ͼ�ϵ���ɫ==��ɫ)
				if (ljcDataMap.getRGB(xiaoyx + xiaoyImage.getWidth(null) / 2,
						xiaoyy + xiaoyImage.getHeight(null) - 15) == -521461)
				{
					// ��ʱ�Ѿ������ϰ����� ��Ҫ����
					xiaoyy += speed;
				}
				repaint();
			} else if (keyCode == KeyEvent.VK_RIGHT)
			{
				// ��
				xiaoyImage = xiaoyRs.get(xiaoyRIndex % xiaoyRs.size());
				xiaoyRIndex++;
				xiaoyx += speed;
				xiaoyDir = KeyEvent.VK_RIGHT;
				// ʵ������ң�˶��������ϰ����޷�ͨ���Ĺ��� ---δ���11
				// if(��ң���½ǵ�����Ҵ����ݵ�ͼ�ϵ���ɫ==��ɫ)
				if (ljcDataMap.getRGB(xiaoyx + xiaoyImage.getWidth(null),
						xiaoyy + xiaoyImage.getHeight(null) - 15) == -521461)
				{
					// ��ʱ�Ѿ������ϰ����� ��Ҫ����
					xiaoyx -= speed;
				}
				repaint();
			} else if (keyCode == KeyEvent.VK_DOWN)
			{
				// ��
				xiaoyImage = xiaoyXs.get(xiaoyXIndex % xiaoyXs.size());
				xiaoyXIndex++;
				xiaoyy += speed;
				xiaoyDir = KeyEvent.VK_DOWN;
				// ʵ������ң�˶��������ϰ����޷�ͨ���Ĺ��� ---δ���11
				// if(��ң���½ǵ�����Ҵ����ݵ�ͼ�ϵ���ɫ==��ɫ)
				if (ljcDataMap.getRGB(xiaoyx + xiaoyImage.getWidth(null) / 2,
						xiaoyy + xiaoyImage.getHeight(null) - 15) == -521461)
				{
					// ��ʱ�Ѿ������ϰ����� ��Ҫ����
					xiaoyy -= speed;
				}
				repaint();
			} else if (keyCode == KeyEvent.VK_SPACE)
			{ // ���ո� �򿪻�ر� �Ի���
				// ʵ�����칦�ܿ����͹ر�
				// 1.�������� 2.��������
				if (xiaoyDir == KeyEvent.VK_LEFT)
				{
					// ����
					int x = xiaoyx;
					int y = xiaoyy;

					int x2 = aws.x + aws.imageWidth;// ����ɩ ���½�����
					int y2 = aws.y + aws.imageHeight - 100;

					int x1 = x2 - 30;// ����ɩ ���½�����
					int y1 = y2 - 30;

					if (x >= x1 && x <= x2 && y >= y1 && y <= y2)
					{
						chatMS = true;
						repaint();
					}
				}
			} else if (keyCode == KeyEvent.VK_ENTER)
			{// �ڷ�����ģʽ�� ��ָ��λ�ð��»س��� ���г����л�
				// �л����� --- δ��� 10
				if (xiaoyx >= 150 && xiaoyx <= 170 && xiaoyy >= 695 // X:160,Y:705
						&& xiaoyy <= 715) // �ж��Ƿ񵽴�ָ��λ��
				{
					mapType = 2;
				}
			}
		}
		// System.out.println("��Ҵ�����(X:" + ljcX + ",Y:" + ljcY + ")");
		System.out.println("����ң����(X:" + xiaoyx + ",Y:" + xiaoyy + ")");
		System.out.println("����ɩ����(X:" + aws.x + ",Y:" + aws.y + ")");
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
			aws.imagesIndex++;
			// ������ι��ͼƬ�����ݻ滭��������---���2
			azwj.imagesIndex++;
			// ������ɩͼƬ�����ݻ滭��������---���3
			wcs.imagesIndex++;
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
