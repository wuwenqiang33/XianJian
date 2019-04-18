package lianxi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.BrokenBarrierException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShaoLeiGame extends MouseAdapter// ����
{
	// ������Ϸ����
	private JFrame gameFrame;// ����
	private int[][] date;// ���ݶ�ά����
	private JButton[][] button;// ������ά����
	private JButton startButton;// ��ʼ��ť
	private Label l;// ��ǩ
	private int row;// ����
	private int col;// ����
	private int mineNamber;// ɨ����
	private int mineCount;// ��ǰ���ҳ��׵�����
	private boolean isOver;// ��Ϸ�Ƿ����
	private Color yuanColor;
	private Color notMineColor;

	public ShaoLeiGame() // ���췽��
	{
		// ��ʼ������
		row = 15;// 15��15��
		col = 15;
		gameFrame = new JFrame("ɨ��v1.0");// �������ڶ���
		date = new int[row][col];// ������������
		button = new JButton[row][col];// ���尴ť��������
		startButton = new JButton("��ʼ");// ������ʼ��ť
		l = new Label("welcome to mine");// ��ʼ����ǩ
//		mineNamber = row * col / 15;// �׵��������ܸ�������1/7
		mineNamber = 5;
		yuanColor = new Color(200, 214, 228);
		notMineColor = new Color(238, 238, 238);

	}

	public void init() // ��ʼ������
	{
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		// ����
		north.setLayout(new FlowLayout());
		center.setLayout(new FlowLayout());
		// ��������GridLayout����
		south.setLayout(new GridLayout(row, col, 4, 4));
		// �ֱ�������
		gameFrame.setLayout(new BorderLayout());
		gameFrame.add(north, BorderLayout.NORTH);
		gameFrame.add(center, BorderLayout.CENTER);
		gameFrame.add(south, BorderLayout.SOUTH);
		// ��ӱ�ǩ
		north.add(l);
		// ��ʼ��ť������
		startButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// ���³�ʼ������
				for (int i = 0; i < row; i++)
				{
					for (int j = 0; j < col; j++)
					{
						// ��ť�����ּ�¼�ⰴť������������
						button[i][j].setText(" ");
						button[i][j].setName(i + ":" + j);
						button[i][j].setBackground(yuanColor);
						button[i][j].addMouseListener(ShaoLeiGame.this);
						date[i][j] = 0;
					}
				}
				mineCount = 0;
				hasMine();
				isOver = false;
				l.setText("����һ��");
			}
		});
		center.add(startButton);
		// ��ʼ����ť��Ϣ
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				button[i][j] = new JButton(" ");
				// ��ť�����ּ�¼�ⰴť������������
				button[i][j].setName(i + ":" + j);
				button[i][j].setBackground(yuanColor);
				button[i][j].addMouseListener(this);
				south.add(button[i][j]);
			}
		}
		// ��ʼ�������
		hasMine();
		mineCount = 0;

	}

	@Override
	public void mousePressed(MouseEvent e)// ��д�����������ť
	{
		JButton jb = (JButton) e.getSource();
		if (e.getButton() == MouseEvent.BUTTON1)// ���
		{
			if (jb.getText().equals("M"))// ����ǲ��ܱ��һ���ɫ
			{
			} else
			{
				mousePerss(jb);
			}

		} else if (e.getButton() == MouseEvent.BUTTON3)// �һ�
		{

			l.setText("��������" + (mineNamber - mineCount));
			if (jb.getBackground() == yuanColor)// ֻ��ԭɫʱ���ܱ����
			{
				if (jb.getText().equals("M"))// �ж��Ƿ񱻱��M
				{
					jb.setText("");
				} else
				{
					// ��ӱ��֮ǰ���ж��Ƿ��б�ǿ���
					if (mineCount < mineNamber)
					{
						jb.setText("M");// ������ױ��
					} else
					{
						l.setText("��������꣡");
					}
				}
			}
			// �ж����Ƿ񶼱��ҳ� ���ҳ��ͽ�����Ϸ ���ʤ��

		}
	}

	public void start()// ��ʼ
	{
		gameFrame.setSize(800, 600);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setVisible(true);

	}

	public void hasMine()// ������׷���
	{
		// ����׵�λ��
		for (int i = 0; i < mineNamber; i++)
		{
			date[(int) (Math.random() * row)][(int) (Math.random() * col)] = -1;
		}
		// ȷ��ÿ��������Χ���׵�����
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if (date[i][j] == -1)
				{
					continue;
				}
				int sum = 0;
				for (int n = -1; n <= 1; n++)
				{
					for (int m = -1; m <= 1; m++)
					{
						if (i + n >= 0 && i + n < row && j + m >= 0
								&& j + m < col)
						{// ���Ǹ����ڱ��ϵ�����

							if (date[i + n][j + m] == -1)
							{
								sum++;
							}
						}
					}
				}
				date[i][j] = sum;// ��¼ij��Χ���׵�����
			}

		}

	}

	public void mousePerss(JButton jb)
	{

		String name = jb.getName();
		int getindex = name.indexOf(":");
		int i1 = Integer.valueOf(name.substring(0, getindex));
		int j1 = Integer.valueOf(name.substring(getindex + 1));
		System.out.println(name);
		System.out.println(i1 + "," + j1 + "date=" + date[i1][j1]);
		if (date[i1][j1] == -1)// ���������
		{
			jb.setBackground(Color.YELLOW);
			gameOver(true);// ��Ϸ����

		} else
		{
			jb.setBackground(notMineColor);
			jb.setText(date[i1][j1] + "");// ��ʾ��Χ������
			// �����Χû���׾ʹ���Χ�İ�ť
			if (date[i1][j1] == 0)
			{
				System.out.println("��Χû����");
				// ��Χ�İ�ť
				for (int n = -1; n <= 1; n++)
				{
					for (int m = -1; m <= 1; m++)
					{
						// ����߽簴ť
						if (i1 + n >= 0 && i1 + n < row && j1 + m >= 0
								&& j1 + m < col)
						{
							// �жϰ�ť�Ƿ񱻱��
							System.out.println("--" + (i1 + n) + "--"
									+ (j1 + m));
							if (button[i1 + n][j1 + m].getText().equals(" "))
							{
								// �Զ������ť
								System.out.println("�Զ��򿪰�ť");
								mousePerss(button[i1 + n][j1 + m]);
							}

						}
					}
				}

			}
		}
		gameOver(false);

	}

	private void gameOver(boolean over)// ��Ϸ����
	{
		if (over)
		{// ��Ϸ���� �����е��׶���ʾ���� �ı��ǩ
			for (int i = 0; i < row; i++)
			{
				for (int j = 0; j < col; j++)
				{
					if (date[i][j] == -1)
					{// �㵽����
						button[i][j].setBackground(Color.RED);
					}
					// ������ȡ���԰�ť�ļ��� -- �����ٵ����ť
					button[i][j].removeMouseListener(this);
				}
			}
			l.setText("������ ��_��  �����ʼ����һ�ְ�");
			return;
		}
		// ʤ��
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if(button[i][j].getName().equals("M")&&date[i][j]==-1){
					mineCount++;
					System.out.println("mineCount:"+mineCount);
					if(mineCount+1 == mineNamber){
						button[i][j].removeMouseListener(this);
						l.setText("ʤ��������");
					}
				}

			}
		}

	}

	public static void main(String[] args)// ������
	{
		ShaoLeiGame game = new ShaoLeiGame();
		game.init();
		game.start();
	}

}
