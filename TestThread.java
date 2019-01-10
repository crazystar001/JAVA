package a;

public class TestThread {
	public static void main(String[] args) 
	{	
		Thread t = new MyThread(); //创建线程
		t.start();//启动线程
	}
}

//线程类
	class MyThread extends Thread
	{
		public void run()     //线程代码 
		{
			for (int i=0;i<5;i++)
			{
				System.out.println("SubThread:"+i);
			}
		}
		
	}
	