package handler;

import java.util.ArrayList;
import java.util.LinkedList;

public class MessageQueue {
  private final LinkedList<Message> queue = new LinkedList<>();

  public void add(Message msg) {
    queue.addLast(msg);
  }

  /**
   * get first element and remove it
   * if the list is empty return null
   * @return
   */
  public Message getFirst() {
    try {
      return queue.removeFirst();
    } catch (Exception e) {
      return null;
    }

  }

}
