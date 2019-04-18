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

public class ShaoLeiGame extends MouseAdapter// 主类
{
	// 定义游戏属性
	private JFrame gameFrame;// 窗体
	private int[][] date;// 数据二维数组
	private JButton[][] button;// 按键二维数组
	private JButton startButton;// 开始按钮
	private Label l;// 标签
	private int row;// 行数
	private int col;// 列数
	private int mineNamber;// 扫雷数
	private int mineCount;// 当前被找出雷的数量
	private boolean isOver;// 游戏是否结束
	private Color yuanColor;
	private Color notMineColor;

	public ShaoLeiGame() // 构造方法
	{
		// 初始化属性
		row = 15;// 15行15列
		col = 15;
		gameFrame = new JFrame("扫雷v1.0");// 创建窗口对象
		date = new int[row][col];// 定义数组数据
		button = new JButton[row][col];// 定义按钮数组数据
		startButton = new JButton("开始");// 创建开始按钮
		l = new Label("welcome to mine");// 初始化标签
//		mineNamber = row * col / 15;// 雷的数量是总格子数的1/7
		mineNamber = 5;
		yuanColor = new Color(200, 214, 228);
		notMineColor = new Color(238, 238, 238);

	}

	public void init() // 初始化方法
	{
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		// 布局
		north.setLayout(new FlowLayout());
		center.setLayout(new FlowLayout());
		// 雷区采用GridLayout布局
		south.setLayout(new GridLayout(row, col, 4, 4));
		// 分别添加面板
		gameFrame.setLayout(new BorderLayout());
		gameFrame.add(north, BorderLayout.NORTH);
		gameFrame.add(center, BorderLayout.CENTER);
		gameFrame.add(south, BorderLayout.SOUTH);
		// 添加标签
		north.add(l);
		// 开始按钮监听器
		startButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// 重新初始化数据
				for (int i = 0; i < row; i++)
				{
					for (int j = 0; j < col; j++)
					{
						// 按钮的名字记录这按钮的行数和列数
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
				l.setText("再来一局");
			}
		});
		center.add(startButton);
		// 初始化按钮信息
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				button[i][j] = new JButton(" ");
				// 按钮的名字记录这按钮的行数和列数
				button[i][j].setName(i + ":" + j);
				button[i][j].setBackground(yuanColor);
				button[i][j].addMouseListener(this);
				south.add(button[i][j]);
			}
		}
		// 开始随机布局
		hasMine();
		mineCount = 0;

	}

	@Override
	public void mousePressed(MouseEvent e)// 重写点击鼠标监听按钮
	{
		JButton jb = (JButton) e.getSource();
		if (e.getButton() == MouseEvent.BUTTON1)// 左击
		{
			if (jb.getText().equals("M"))// 被标记不能被右击变色
			{
			} else
			{
				mousePerss(jb);
			}

		} else if (e.getButton() == MouseEvent.BUTTON3)// 右击
		{

			l.setText("雷数量：" + (mineNamber - mineCount));
			if (jb.getBackground() == yuanColor)// 只有原色时才能被标记
			{
				if (jb.getText().equals("M"))// 判断是否被标记M
				{
					jb.setText("");
				} else
				{
					// 添加标记之前先判断是否还有标记可用
					if (mineCount < mineNamber)
					{
						jb.setText("M");// 添加是雷标记
					} else
					{
						l.setText("标记已用完！");
					}
				}
			}
			// 判断雷是否都被找出 都找出就结束游戏 获得胜利

		}
	}

	public void start()// 开始
	{
		gameFrame.setSize(800, 600);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setVisible(true);

	}

	public void hasMine()// 随机部雷方法
	{
		// 随机雷的位置
		for (int i = 0; i < mineNamber; i++)
		{
			date[(int) (Math.random() * row)][(int) (Math.random() * col)] = -1;
		}
		// 确定每个格子周围的雷的数量
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
						{// 考虑格子在边上的问题

							if (date[i + n][j + m] == -1)
							{
								sum++;
							}
						}
					}
				}
				date[i][j] = sum;// 记录ij周围的雷的数量
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
		if (date[i1][j1] == -1)// 点击的是雷
		{
			jb.setBackground(Color.YELLOW);
			gameOver(true);// 游戏结束

		} else
		{
			jb.setBackground(notMineColor);
			jb.setText(date[i1][j1] + "");// 显示周围的雷数
			// 如果周围没有雷就打开周围的按钮
			if (date[i1][j1] == 0)
			{
				System.out.println("周围没有雷");
				// 周围的按钮
				for (int n = -1; n <= 1; n++)
				{
					for (int m = -1; m <= 1; m++)
					{
						// 处理边界按钮
						if (i1 + n >= 0 && i1 + n < row && j1 + m >= 0
								&& j1 + m < col)
						{
							// 判断按钮是否被标记
							System.out.println("--" + (i1 + n) + "--"
									+ (j1 + m));
							if (button[i1 + n][j1 + m].getText().equals(" "))
							{
								// 自动点击按钮
								System.out.println("自动打开按钮");
								mousePerss(button[i1 + n][j1 + m]);
							}

						}
					}
				}

			}
		}
		gameOver(false);

	}

	private void gameOver(boolean over)// 游戏结束
	{
		if (over)
		{// 游戏结束 把所有的雷都显示出来 改变标签
			for (int i = 0; i < row; i++)
			{
				for (int j = 0; j < col; j++)
				{
					if (date[i][j] == -1)
					{// 点到雷了
						button[i][j].setBackground(Color.RED);
					}
					// 结束后取消对按钮的监听 -- 不能再点击按钮
					button[i][j].removeMouseListener(this);
				}
			}
			l.setText("你输了 —_—  点击开始来了一局吧");
			return;
		}
		// 胜利
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if(button[i][j].getName().equals("M")&&date[i][j]==-1){
					mineCount++;
					System.out.println("mineCount:"+mineCount);
					if(mineCount+1 == mineNamber){
						button[i][j].removeMouseListener(this);
						l.setText("胜利！！！");
					}
				}

			}
		}

	}

	public static void main(String[] args)// 主方法
	{
		ShaoLeiGame game = new ShaoLeiGame();
		game.init();
		game.start();
	}

}
