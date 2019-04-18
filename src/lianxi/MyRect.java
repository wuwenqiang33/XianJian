package lianxi;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * ��400x600 �Ĵ��ڵ����·���һ��ľ�壬����ݼ������������˶�
 * @author Administrator
 *
 */
public class MyRect extends Frame
{

	public static void main(String[] args)
	{
		//1.�����������ʵ����������������
		MyRect myRect = new MyRect();
		myRect.setSize(400, 600);
		myRect.setLocationRelativeTo(null);
		//3.�����������ʵ���������봰�ڶ�����й���
		MyRectPanle myRectPanle = new MyRectPanle();
		myRect.add(myRectPanle);
		//�������̽ӿڵ���Ч��
		myRect.addKeyListener(myRectPanle);
		myRectPanle.addKeyListener(myRectPanle);
		myRect.show();

	}

}
//2.��д�����࣬��ɻ滭����
//4.ʵ�ּ��̽ӿ�(KeyListener)����ӽӿ��еķ���
//5.��д�����еľ��巽��(ʵ��ľ����˶�Ч��)
class MyRectPanle extends Panel implements KeyListener{
	int x = 40;
	int y =550;
	@Override
	public void paint(Graphics g)
	{
		g.fillRect(x, y, 100, 10);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		//ʵ��ľ������������Ұ��������ƶ����˶�Ч��
		//��һ��֪���û����µİ������ĸ�
		//�ڶ������ݰ������в�ͬЧ���Ĳ���(����37����39���߲���)
		int keyCode = e.getKeyCode();
		if(keyCode==37){
			//����
			x-=5;
			if(x<0)
				x=0;
		}else if(keyCode == 39){
			//����
			x+=5;
			if(x>400-100)
				x=400-100;
		}
		
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		
	}
	
}