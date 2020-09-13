package sync_learning;

public class SaveMan extends Thread {
    private Bank bank;
    private int handMoney;
    private int saveMoneyOnce = 12;

    public SaveMan(Bank bank, int handMoney) {
        this.bank = bank;
        this.handMoney = handMoney;
        setName("sync_learning.SaveMan");
    }

    @Override
    public void run() {
        while (handMoney > 0) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (bank) {
                int saveMoney = saveMoneyOnce;
                if (handMoney < saveMoneyOnce) {
                    saveMoney = handMoney;
                }
                bank.save(saveMoney);
                this.handMoney -= saveMoney;
                System.out.println("存钱成功，银行卡现在有：" + bank.getMoney() + "  手上还剩:" + handMoney);
            }
        }
        System.out.println("存钱完成。" + "  手上还剩:" + handMoney + "银行卡现在有：" + bank.getMoney());
    }

    synchronized public int getHandMoney() {
        return handMoney;
    }
}
