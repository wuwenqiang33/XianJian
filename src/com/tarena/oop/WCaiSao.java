package com.tarena.oop;

import java.awt.Image;
import java.util.List;

public class WCaiSao extends GameRole
{
	// ��������ɩ����(���е�)
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
		images = GameUtil.GetImagesForNameAndNumber("����ɩ", 14);
		toLxyMessages = new String[]
		{ "��ң����ð���ɩ��", "��ң����˵������������û����֪������������", "����ɩ������ǰ���и�ɽ���������ȥ���￴����" };
	}

}
