package com.tarena.day04;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GameUtilTest
{

	@Test
	public void testGstImageForName()
	{
		//�ز�/"+name+".png
		//�ز�/����ң��/0.png
		Image image = GameUtil.GetImageForName("����ң��/0");
		System.out.println(image);
		
	}

	@Test
	public void testGetImagesForNameAndNumber()
	{
		List<Image> images = GameUtil.GetImagesForNameAndNumber("����ң��", 8);
		System.out.println(images.size());
	}

}
