package com.tarena.oop;

import java.awt.Image;
import java.util.List;

public class TiaoSheng extends GameRole
{
	// ������������(���е�)
		public List<Image> images;
		public String[] toLxyMessages;

		// ���췽������ʼ�����������(���е�����+���е�����)
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
			images = GameUtil.GetImagesForNameAndNumber("����", 4);
			toLxyMessages = new String[]
			{ "��ң����ð���ɩ��", "��ң����˵������������û����֪������������", "����ɩ������ǰ���и�ɽ���������ȥ���￴����" };
		}


}
