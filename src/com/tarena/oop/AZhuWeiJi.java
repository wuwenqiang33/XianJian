package com.tarena.oop;

import java.awt.Image;
import java.util.List;

public class AZhuWeiJi extends GameRole
{

	// ���尢��ι������(���е�)
	public List<Image> images;
	public String[] toLxyMessages;

	// ���췽������ʼ�����������(���е�����+���е�����)
	public AZhuWeiJi()
	{
	}

	public AZhuWeiJi(int x, int y)
	{
		super.x = x;
		super.y = y;
		super.imagesIndex = 0;
		super.imageWidth = 64;
		super.imageHeight = 104;
		images = GameUtil.GetImagesForNameAndNumber("����ι��", 6);
		toLxyMessages = new String[]
		{ "��ң����ð���ɩ��", "��ң����˵������������û����֪������������", "����ɩ������ǰ���и�ɽ���������ȥ���￴����" };
	}



}
