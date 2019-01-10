package a;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class BlockingQueueTest {
 /**
 定义装苹果的篮子
  */
 public static class page{
  // 篮子，能够容纳3个苹果
  BlockingQueue<String> page = new ArrayBlockingQueue<String>(3);

  // 生产苹果，放入篮子
  public void produce() throws InterruptedException{
   // put方法放入一个苹果，若page满了，等到page有位置
   page.put("An source");
  }
  // 消费苹果，从篮子中取走
  public String consume() throws InterruptedException{
   // get方法取出一个苹果，若page为空，等到page有苹果为止
   String source = page.take();
   return source;
  }

  public int getsourceNumber(){
   return page.size();
  }

 }
 //　测试方法
 public static void testpage() {
  // 建立page
  final page page = new page();
  // 定义苹果生产者
  class Producer implements Runnable {
   public void run() {
    try {
     while (true) {
      // 生产苹果
      System.out.println("生产者准备生产苹果：" 
        + System.currentTimeMillis());
      page.produce();
      System.out.println("生产者生产苹果完毕：" 
        + System.currentTimeMillis());
      System.out.println("生产完后有苹果："+page.getsourceNumber()+"个");
      // 休眠300ms
      Thread.sleep(300);
     }
    } catch (InterruptedException ex) {
    }
   }
  }
  // 定义苹果消费者
  class Consumer implements Runnable {
   public void run() {
    try {
     while (true) {
      // 消费苹果
      System.out.println("准备取出资源：" 
        + System.currentTimeMillis());
      page.consume();
      System.out.println("资源取出完毕：" 
        + System.currentTimeMillis());
      System.out.println("现在Cache中有资源："+page.getsourceNumber()+"个");
      // 休眠1000ms
      Thread.sleep(1000);
     }
    } catch (InterruptedException ex) {
    }
   }
  }

  ExecutorService service = Executors.newCachedThreadPool();
  Producer producer = new Producer();
  Consumer consumer = new Consumer();
  service.submit(producer);
  service.submit(consumer);
  // 程序运行10s后，所有任务停止
  try {
   Thread.sleep(10000);
  } catch (InterruptedException e) {
  }
  service.shutdownNow();
 }
 public static void main(String[] args) {
  BlockingQueueTest.testpage();
 }
}