package com.tarena.oop;

import java.awt.Image;
import java.util.List;

public class TiaoSheng extends GameRole
{
	// 定义跳绳属性(特有的)
		public List<Image> images;
		public String[] toLxyMessages;

		// 构造方法，初始化本类的属性(共有的属性+特有的属性)
		public TiaoSheng()
		{
		}

		public TiaoSheng(int x, int y)
		{
			super.x = x;
			super.y = y;
			super.imagesIndex = 0;
			super.imageWidth = 136;
			super.imageHeight = 148;
			images = GameUtil.GetImagesForNameAndNumber("跳绳", 4);
			toLxyMessages = new String[]
			{ "逍遥：你好阿旺嫂！", "逍遥：听说这里有蛇妖出没，你知道她在哪了吗？", "阿旺嫂：好像前村有个山洞，你可以去那里看看。" };
		}


}
