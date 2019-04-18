package com.tarena.day02;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GameUtilTest
{

	@Test
	public void testGstImageForName()
	{
		//ËØ²Ä/"+name+".png
		//ËØ²Ä/ÀîåĞÒ£ÓÒ/0.png
		Image image = GameUtil.GstImageForName("ÀîåĞÒ£ÓÒ/0");
		System.out.println(image);
		
	}

	@Test
	public void testGetImagesForNameAndNumber()
	{
		List<Image> images = GameUtil.GetImagesForNameAndNumber("ÀîåĞÒ£ÓÒ", 8);
		System.out.println(images.size());
	}

}
