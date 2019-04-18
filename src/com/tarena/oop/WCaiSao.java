package com.tarena.oop;

import java.awt.Image;
import java.util.List;

public class WCaiSao extends GameRole
{
	// 定义旺财嫂属性(特有的)
	public List<Image> images;
	public String[] toLxyMessages;
	public WCaiSao()
	{
	}
	public WCaiSao(int x,int y)
	{
		super.x = x;
		super.y = y;
		super.imagesIndex = 0;
		super.imageWidth = 68;
		super.imageHeight = 92;
		images = GameUtil.GetImagesForNameAndNumber("旺财嫂", 14);
		toLxyMessages = new String[]
		{ "逍遥：你好阿旺嫂！", "逍遥：听说这里有蛇妖出没，你知道她在哪了吗？", "阿旺嫂：好像前村有个山洞，你可以去那里看看。" };
	}

}
