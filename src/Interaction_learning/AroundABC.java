package Interaction_learning;

public class AroundABC extends Thread {
    private String msg;
    private AroundABC next;

    public AroundABC(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {

            synchronized (this) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第" + (++i )+ "次：" + this.msg);

                synchronized (this.next) {
                    this.next.notify();//唤醒下一个对象上的线程
                }
            }
        }
    }

    public static void main(String[] args) {
        AroundABC A = new AroundABC("A");
        AroundABC B = new AroundABC("B");
        AroundABC C = new AroundABC("C");
        A.next = B;
        B.next = C;
        C.next = A;

        A.start();
        B.start();
        C.start();

        try {
            Thread.sleep(100);//让其他线程得到调用
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (A) {//唤醒A线程

            A.notify();//唤醒正在此对象上等待的单个线程,在A对象上等待的只有一个线程

        }

    }
}
