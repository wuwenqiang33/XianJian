package test;

import java.net.URL;

import com.tarena.day01.MyGame;

public class Test
{

	@org.junit.Test
	public void test()
	{
		
		
		URL url = MyGame.class.getResource("xiaoyR0.png");
		System.out.println(url);
	}

}
