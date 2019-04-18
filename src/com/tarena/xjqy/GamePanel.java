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
	// �л�������---δ���10
	private int cjContrIndex;
	private Image cj2Image;
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
			// �л����� ��ʼ��---δ��� 10
			cjContrIndex = 1;
			cj2Image = GameUtil.GstImageForName("��Ҵ��г�/0");
			// ��ʼ�����칦������ ---δ��� 9 ����ɰ���ɩ�Ի�
			chatImage = GameUtil.GstImageForName("�Ի���/0");
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
			azwjX = 210 + oX;
			azwjY = 200 + oY;
			azwjIndex = 0;
			azwjImages = GameUtil.GetImagesForNameAndNumber("����ι��", 6);
			// ��ʼ����ɩ�������3
			wcsX = 600 + oX;
			wcsY = 235 + oY;
			wcsIndex = 0;
			wcsImages = GameUtil.GetImagesForNameAndNumber("����ɩ", 14);
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
			// ��ʼ�����������7
			tsX = 670 + oX;
			tsY = 375 + oY;
			tsIndex = 0;
			tsImages = GameUtil.GetImagesForNameAndNumber("����", 4);
			// ��ʼ����Ҵ��������
			ljcImage = GameUtil.GstImageForName("��Ҵ�/0");
			ljcX = -250 + oX;
			ljcY = -250 + oY;
			// ��ʼ������ɩ�������---���1
			awsX = 360 + oX;
			awsY = 340 + oY;
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
		g.drawImage(ljcImage, ljcX, ljcY, null);
		// ������ɩͼƬ�����ݻ滭��������---���1
		bG.drawImage(awsImage, awsX + ljcX, awsY + ljcY, null);
		// ������ι��ͼƬ�����ݻ滭��������---���2
		bG.drawImage(azwjImage, azwjX + ljcX, azwjY + ljcY, null);
		// ������ɩͼƬ�����ݻ滭��������---���3
		bG.drawImage(wcsImage, wcsX + ljcX, wcsY + ljcY, null);
		// ��ĸ��ͼƬ�����ݻ滭��������---���4
		bG.drawImage(mjImage, mjX + ljcX, mjY + ljcY, null);
		// ��С��ͼƬ�����ݻ滭��������---���5
		bG.drawImage(xjImage, xjX + ljcX, xjY + ljcY, null);
		// ��СС��ͼƬ�����ݻ滭��������---���6
		bG.drawImage(xxjImage, xxjX + ljcX, xxjY + ljcY, null);
		// ������ͼƬ�����ݻ滭��������---���7
		bG.drawImage(tsImage, tsX + ljcX, tsY + ljcY, null);

		// ���Ի��򻭵������� --- δ���9
		if (chatMS)
		{
			chatX = (this.getWidth() - chatImage.getWidth(null)) / 2;
			chatY = this.getHeight() - chatImage.getHeight(null);
			bG.drawImage(chatImage, chatX, chatY, null);
			bG.drawString(chatString, chatX + 20, chatY + 50);
		}

		// ���ݳ�����ͼ
		if (cjContrIndex == 1)
		{
			// 2.�������������ݻ���������
			g.drawImage(bImage, 0, 0, null);
		}
		// �л����� --- δ��� 10
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

		// ������ңͼƬ�����ݻ滭��������---���8
		// ��������ң�߽�����
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
		// ������칦��---9���
		// System.out.println("keyCode:"+keyCode); //�ո�32 �س�10
		// �������
		if (chatMS)
		{
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
		{
			if (keyCode == KeyEvent.VK_LEFT)
			{
				// ��
				xiaoyImage = xiaoyLs.get(xiaoyLIndex % xiaoyLs.size());
				xiaoyLIndex++;
				xiaoyx -= speed;
				xiaoyDir = KeyEvent.VK_LEFT;
			} else if (keyCode == KeyEvent.VK_UP)
			{
				// ��
				xiaoyImage = xiaoySs.get(xiaoySIndex % xiaoySs.size());
				xiaoySIndex++;
				xiaoyy -= speed;
				xiaoyDir = KeyEvent.VK_UP;
			} else if (keyCode == KeyEvent.VK_RIGHT)
			{
				// ��
				xiaoyImage = xiaoyRs.get(xiaoyRIndex % xiaoyRs.size());
				xiaoyRIndex++;
				xiaoyx += speed;
				xiaoyDir = KeyEvent.VK_RIGHT;
			} else if (keyCode == KeyEvent.VK_DOWN)
			{
				// ��
				xiaoyImage = xiaoyXs.get(xiaoyXIndex % xiaoyXs.size());
				xiaoyXIndex++;
				xiaoyy += speed;
				xiaoyDir = KeyEvent.VK_DOWN;
			}
			// ���ո� �򿪻�ر� �Ի���
			if (keyCode == KeyEvent.VK_SPACE)
			{
				// ʵ�����칦�ܿ����͹ر�
				// 1.�������� 2.��������
				if (xiaoyDir == KeyEvent.VK_LEFT)
				{
					// ����
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
		// System.out.println("��Ҵ�����(X:" + ljcX + ",Y:" + ljcY + ")");
		System.out.println("����ң����(X:" + xiaoyx + ",Y:" + xiaoyy + ")");
		System.out.println("����ɩ����(X:" + awsX + ",Y:" + awsY + ")");
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
