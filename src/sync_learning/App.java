package sync_learning;

/**
 * 线程之间同步学习
 */
public class App {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        int bankInitMoney = 5000;
        int handMoney = 10000000;
        Bank bank = new Bank(bankInitMoney);
        WithDrawMan withDrawMan = new WithDrawMan(bank,"withDrawMan");
        WithDrawMan withDrawMan1 = new WithDrawMan(bank,"withDrawMan1");
        SaveMan saveMan = new SaveMan(bank, 5000000);
        SaveMan saveMan1 = new SaveMan(bank, 5000000);
        saveMan.start();
        saveMan1.start();
        withDrawMan.start();
        withDrawMan1.start();
        checkMoney(bankInitMoney, handMoney, bank, withDrawMan, withDrawMan1, saveMan, saveMan1);
    }

    private static void checkMoney(int bankInitMoney, int handMoney, Bank bank, WithDrawMan withDrawMan, WithDrawMan withDrawMan1, SaveMan saveMan, SaveMan saveMan1) {
        new Thread(() -> {
            while (true) {
//                try {
//                    Thread.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (bank) {
                    int dynamicMoney = withDrawMan.getHandMoney() + withDrawMan1.getHandMoney() + bank.getMoney() + saveMan.getHandMoney() + saveMan1.getHandMoney();
                    if (dynamicMoney != bankInitMoney + handMoney) {
                        System.out.println("init money:" + (bankInitMoney + handMoney) + " now total:" + dynamicMoney);
                        System.out.println("银行卡有:" + bank.getMoney() + " 手上有:" + saveMan.getHandMoney());
                        withDrawMan.stop();
                        saveMan.stop();
                        return;
                    } else {
//                        System.out.println("total:" + dynamicMoney);
                    }
                }
            }
        }).start();
    }
}
