package com.tarena.oop;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
/**
 * �����ʾ��Ϸ���������а���ɩ����
 * 
 * @author Administrator
 */
public class AWangShen extends GameRole
{
	// ���尢��������(���е�)
	public List<Image> images;
	public String[] toLxyMessages;

	// ���췽������ʼ�����������(���е�����+���е�����)
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
		images = GameUtil.GetImagesForNameAndNumber("������", 17);
		toLxyMessages = new String[]
		{ "��ң����ð���ɩ��", "��ң����˵������������û����֪������������", "����ɩ������ǰ���и�ɽ���������ȥ���￴����" };
	}

}
