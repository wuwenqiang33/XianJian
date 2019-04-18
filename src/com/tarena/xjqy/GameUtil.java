package com.tarena.xjqy;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class GameUtil
{
	
	
	/**
	 * 
	 * ͨ��ͼƬ����name��ȡһ��Image ���� "�ز�/"+name+".png"
	 * 
	 * @param name
	 * @param args
	 * @return
	 */
	public static Image GstImageForName(String name)
	{
		Image image = null;
		try
		{
			image = ImageIO.read(new File("�ز�/" + name + ".png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return image;

	}

	/**
	 * ͨ��ͼƬ���ڵ��ļ�������ͼƬ���� ��ȡһ��ͼƬ ����
	 * 
	 * @param name
	 * @param num
	 * @return
	 */
	public static List<Image> GetImagesForNameAndNumber(String name, int num)
	{
		Image image = null;
		List<Image> images = null;
		try
		{
			if (num > 0)
			{
				images = new ArrayList<Image>();
				for (int i = 0; i < num; i++)
				{
					image = ImageIO.read(new File("�ز�/" + name + "/" + i
							+ ".png"));
					images.add(image);
				}
				return images;

			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return null;
	}
}
