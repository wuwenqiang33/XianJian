package lianxi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MLDemo
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		MLDemoPanel panel = new MLDemoPanel();
		frame.addMouseListener(panel);
		panel.addMouseListener(panel);
		frame.add(panel);
		frame.setVisible(true);
	}

}

class MLDemoPanel extends JPanel implements MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int flag = 1;

	@Override
	public void paint(Graphics g)
	{
		this.setBackground(Color.GRAY);
		super.paint(g);
		if (flag == 1)
		{
			g.setColor(Color.WHITE);
			g.drawLine(50, 100, 50, 50);
			g.drawLine(50, 50, 200, 50);
			g.setColor(Color.BLACK);
			g.drawLine(200, 50, 200, 100);
			g.drawLine(200, 100, 50, 100);
		} else if (flag == 2)
		{
			g.setColor(Color.BLACK);
			g.drawLine(50, 100, 50, 50);
			g.drawLine(50, 50, 200, 50);
			g.setColor(Color.WHITE);
			g.drawLine(200, 50, 200, 100);
			g.drawLine(200, 100, 50, 100);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if(e.getButton()==MouseEvent.BUTTON3){
			int x = e.getX();
			int y = e.getY();
			if (x >= 50 && x <= 200 && y >= 50 && y <= 100)
			{
				flag = 2;
				repaint();
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		flag = 1;
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{

	}

	@Override
	public void mouseExited(MouseEvent e)
	{

	}

}