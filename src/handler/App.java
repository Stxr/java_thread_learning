package handler;

/**
 * 自己实现的简单的handler
 * 功能：
 * Looper #loop负责不断的去读取任务
 * MessageQueue 负责管理任务
 * handler #post方法负责向MessageQueue中插入任务
 * ThreadLocal 保存每个线程的变量
 */
public class App {
  public static void main(String[] args) {
    Looper looper = new Looper();

    Message message = new Message();
    message.callback = () -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + " task1");

    };
    new Thread(() -> {
      Looper looper1 = new Looper();
      Message message1 = new Message();
      message1.callback = () -> {
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " task2");
      };
      looper.addTask(message1);
      looper1.addTask(message1);
      looper1.loop();
    }).start();

    looper.addTask(message);
    looper.addTask(message);
    looper.addTask(message);
    looper.loop();


  }
}
