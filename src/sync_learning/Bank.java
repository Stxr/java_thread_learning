package sync_learning;

public class Bank {
    private volatile int money;

    public Bank(int money) {
        this.money = money;
    }

    synchronized boolean withDraw(int value) {
        int after = this.money - value;
        if (after >= 0) {
            this.money = after;
            return true;
        }
        return false;
    }

    synchronized boolean save(int newMoney) {
        assert money == 0;
        this.money += newMoney;
        return true;
    }


    synchronized public int getMoney() {
        return money;
    }


}
