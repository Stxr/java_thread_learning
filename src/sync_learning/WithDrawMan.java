package sync_learning;

public class WithDrawMan extends Thread {
    private final Bank bank;
    private int handMoney;

    public WithDrawMan(Bank bank,String name) {
        this.bank = bank;
        setName(name);
    }

    @Override
    public void run() {
        while (true) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (bank) {
                boolean isSuccess = bank.withDraw(10);
                if (isSuccess) {
                    handMoney += 10;
                    System.out.println(Thread.currentThread().getName()+"取钱成功,银行卡现在有:" + bank.getMoney() + " 手上还有：" + handMoney);
                } else {
                    System.out.println(Thread.currentThread().getName()+"取钱失败,银行卡现在有:" + bank.getMoney() + " 手上还有：" + handMoney);
                }
            }

        }
    }

    synchronized public int getHandMoney() {
        return handMoney;
    }
}
