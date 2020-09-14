package proxy;

public class Train implements IAmount {
    private int amount = 100;

    public int sell() {
//        System.out.println("原始售价为:" + amount);
        return amount;
    }

}
