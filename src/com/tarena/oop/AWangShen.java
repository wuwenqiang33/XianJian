package com.tarena.oop;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
/**
 * 本类表示游戏程序中所有阿旺嫂的类
 * 
 * @author Administrator
 */
public class AWangShen extends GameRole
{
	// 定义阿旺婶属性(特有的)
	public List<Image> images;
	public String[] toLxyMessages;

	// 构造方法，初始化本类的属性(共有的属性+特有的属性)
	public AWangShen()
	{
	}

	public AWangShen(int x, int y)
	{
		super.x = x;
		super.y = y;
		super.imagesIndex = 0;
		super.imageWidth = 68;
		super.imageHeight = 92;
		images = GameUtil.GetImagesForNameAndNumber("阿旺婶", 17);
		toLxyMessages = new String[]
		{ "逍遥：你好阿旺嫂！", "逍遥：听说这里有蛇妖出没，你知道她在哪了吗？", "阿旺嫂：好像前村有个山洞，你可以去那里看看。" };
	}

}
