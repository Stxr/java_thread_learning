package Interaction_learning;

public class SayHi extends Thread {
    private final Message lock;

    public SayHi(Message lock) {
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
                while (!lock.isSayHello()){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("   <---Hi!!  "+ lock.increase(1));
                lock.setSayHello(false);
            }
        }

    }
}
