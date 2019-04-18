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
	 * 通过图片名称name获取一个Image 对象 "素材/"+name+".png"
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
			image = ImageIO.read(new File("素材/" + name + ".png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return image;

	}

	/**
	 * 通过图片所在的文件夹名和图片数量 获取一组图片 集合
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
					image = ImageIO.read(new File("素材/" + name + "/" + i
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
