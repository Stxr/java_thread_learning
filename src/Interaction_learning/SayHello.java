package Interaction_learning;

public class SayHello extends Thread {
    private final Message lock;

    public SayHello(Message lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                if (!lock.isSayHello()) {
                    System.out.println("--->hello!!  " + lock.increase(1));

                    lock.setSayHello(true);
                    lock.notify();
                }
            }
        }

    }
}
