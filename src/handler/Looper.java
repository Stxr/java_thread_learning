package handler;

public class Looper {
  private MessageQueue queue = new MessageQueue();


  public void addTask(Message msg) {
    queue.add(msg);
  }

  void loop() {
    while (true) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      Message message = queue.getFirst();
      if (message == null) {
        return;
      }
      message.callback.run();
    }
  }
}
