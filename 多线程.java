package a;

//主类和线程类分开写
public class 多线程 {//主类用于执行程序，不扩展Thread类 
	public static void main(String[] args){
		Thread t = new MyThread();//创建线程对象
       	t. start();//启动线程t，它会自动调用run方法
    }
}
class MyThread extends Thread {//线程类，必须扩展Thread类 
	public void run() {//线程对象的可执行代码
		for(int i=0; i<5; i++) {
			System.out.println("SubThread: " + i);
		}
	}
}
