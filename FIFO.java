package a;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class FIFO{
	 //动态数组定义缓存与页面
	// 0号区域用于存储用户定义大小
	static ArrayList<Integer> page1=new ArrayList<Integer>();
	static ArrayList<Integer> cache1=new ArrayList<Integer>();
	static int temp=1;
	/*----------------------------------------------------------------初始化函数----------------------------------------------------------------------------------*/
     
	static void set_values() 
	{
		System.out.println("请输入页面的大小：");
		Scanner N = new Scanner(System.in);
		int max_pg = N.nextInt();

		/*创建页面*/
		page1.clear();
		page1.add(max_pg);  //放入最大页数
		System.out.println("max page is : "+page1.get(0));
	//	N.close();
		
		for (int i=1;i<=max_pg;i++)
		{
			page1.add(i);
		}
		
		/*创建缓存*/	
		cache1.clear();
		System.out.println("请输入cache大小 :");
	//	Scanner m = new Scanner(System.in);
		int max_cache=N.nextInt();
		cache1.add(max_cache);  //放入最大缓存数
		
		System.out.println("max page is : "+page1.get(0));
	}
	/*---------------------------------------------------------------清屏函数1-----------------------------------------------------------------------------------*/
	static void clearConsole1()
	{
		try 
		{
		String os=System.getProperty("os.name");
		if(os.contains("Windows"))
		{
			Runtime.getRuntime().exec("cls");
		}
		else
		{
			Runtime.getRuntime().exec("clear");
		}
		} catch (Exception exception) {
			// TODO: handle exception
		}
	}
	/*---------------------------------------------------------------清屏函数2-----------------------------------------------------------------------------------*/	
	 static void clearConsole2() throws AWTException {
		Robot r = new Robot();
		r.mousePress(InputEvent.BUTTON3_MASK); // 按下鼠标右键
		r.mouseRelease(InputEvent.BUTTON3_MASK); // 释放鼠标右键
		r.keyPress(KeyEvent.VK_CONTROL); // 按下Ctrl键
		r.keyPress(KeyEvent.VK_R); // 按下R键
		r.keyRelease(KeyEvent.VK_R); // 释放R键
		r.keyRelease(KeyEvent.VK_CONTROL); // 释放Ctrl键
		r.delay(100);

		} 
	/*---------------------------------------------------------------选择菜单-----------------------------------------------------------------------------------*/	
	
	 static int face() throws AWTException 
	 {
		 //clearConsole1();
		 clearConsole2();
		 System.out.println("请输入要执行的功能：");
		 System.out.println("----------------------");
		 System.out.println("1.申请页面");
		 System.out.println("2.输出当前占用页面");
		 System.out.println("3.输出当前占用缓存区个数");
		 System.out.println("4.重新初始化页面与缓存");
		 System.out.println("5..退出");
		 Scanner N=new Scanner(System.in);
		 int num=N.nextInt();
		// N.close();
		 return num;
	 }
/*-------------------------------------------------------------------------申请页面---------------------------------------------------------------------------*/
	static void offer()
	{
		System.out.println("当前最大页面数为："+page1.get(0));
		System.out.println("请输入所要请求的页面号：");
		Scanner N=new Scanner(System.in);
		int num=N.nextInt();
//		N.close();
		if(num>page1.get(0))
		{
			System.out.println("超出最大页面号，请重新输入");
			offer();
		}
			//判断内存是否满
		if(cache1.size()>cache1.get(0))
		{
			System.out.println("第"+(cache1.get(0)+1)+"号页面被释放");
			cache1.remove(temp);
			cache1.add(temp, num);  //第二轮元素从队首依次
			temp+=1;
			if(temp==cache1.get(0)+1)
				temp=0;//重新指向数组首部
		}
			else
		cache1.add(num);
	}
/*------------------------------------------------------------------------功能函数--------------------------------------------------------------------------*/
 static void Function() throws AWTException 
	{
		int num=face();
	switch (num)
	{
		case 1:
			offer();
			Function();
		case 2:
			System.out.println("当前占用页面为:"); 
			for (int i : cache1 )
				System.out.print(i);
			Function();
		case 3:
			System.out.println("当前使用缓存区占用个数:"+(cache1.size()-1));
			Function();
		case 4:
			set_values();
			Function();
		case 5:
			return;
		default: System.out.println("输入有误，请重新输入！");
			Function();
	}	
	}
 /*-----------------------------------------------------------------------主函数---------------------------------------------------------------------------*/
	public static void main(String[] args) throws AWTException {
		set_values();
		Function();
		
	}

}
