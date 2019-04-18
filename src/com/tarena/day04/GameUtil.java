package com.tarena.day04;

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
	public static Image GetImageForName(String name)
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
	
	public static int getDistance(int x1,int y1,int x2,int y2){
		int d = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
		
		return Math.abs(d);
	}
	//�������껭Բ�ж�
	public static boolean hasHuaYuanOfPoint(int x1,int y1,int x2,int y2,int imageWidth,int imageHeight){
		
		int X = x1+imageWidth/2;
		int Y = y1+ imageHeight/2;
		int d = (X-x2)*(X-x2) + (Y-y2)*(Y-y2);
		if(d<=(imageWidth/2)*imageWidth/2){
			return true;
		}
		return false;
		
		
		
		
	}
	
}
