package proxy;

public class TrainProxy implements IAmount {
  private IAmount train;
  private int handlingCost = 5;

  public TrainProxy(IAmount train) {
    this.train = train;
  }

  public int sell() {
    System.out.println("我是静态代理商，买票收取5元手续费");
    return handlingCost + train.sell();
  }

  @Override
  public double refund() {
    System.out.println("我是静态代理商，退票收取5元手续费");
    return train.refund() - handlingCost;
  }
}
