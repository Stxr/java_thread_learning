package Interaction_learning;

public class Relay extends Thread {
    private Object next;
    private Message message;

    public Relay(Message message) {
        this.message = message;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (this) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " count:" + message.increase(1));
                synchronized (next) {
                    next.notify();
                }

            }
        }
    }


}
