package lianxi;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 在400x600 的窗口的左下方有一块木板，会根据键盘向左向右运动
 * @author Administrator
 *
 */
public class MyRect extends Frame
{

	public static void main(String[] args)
	{
		//1.创建窗口类的实例化对象，设置属性
		MyRect myRect = new MyRect();
		myRect.setSize(400, 600);
		myRect.setLocationRelativeTo(null);
		//3.创建画板类的实例化对象，与窗口对象进行关联
		MyRectPanle myRectPanle = new MyRectPanle();
		myRect.add(myRectPanle);
		//声明键盘接口的有效性
		myRect.addKeyListener(myRectPanle);
		myRectPanle.addKeyListener(myRectPanle);
		myRect.show();

	}

}
//2.编写画板类，完成绘画方法
//4.实现键盘接口(KeyListener)，添加接口中的方法
//5.编写方法中的具体方法(实现木板的运动效果)
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
		//实现木板根据向左向右按键进行移动的运动效果
		//第一，知道用户按下的按键是哪个
		//第二，根据按键进行不同效果的操作(向左37向右39或者不动)
		int keyCode = e.getKeyCode();
		if(keyCode==37){
			//向左
			x-=5;
			if(x<0)
				x=0;
		}else if(keyCode == 39){
			//向右
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