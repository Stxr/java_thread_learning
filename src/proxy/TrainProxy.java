package proxy;

public class TrainProxy implements IAmount {
    private IAmount train;
    private int handlingCost = 5;

    public TrainProxy(IAmount train) {
        this.train = train;
    }

    public int sell() {
        System.out.println("我是静态代理商，需要收取5元手续费");
        return handlingCost + train.sell();
    }
}
