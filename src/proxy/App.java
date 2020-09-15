package proxy;

import handler.Looper;

public class App {
  public static void main(String[] args) {
    IAmount train = new Train();
    System.out.println("原始价格为:" + train.sell());
    System.out.println("退票价格为:" + train.refund());

    TrainProxy trainProxy = new TrainProxy(train);
    System.out.println("最终价格为：" + trainProxy.sell());
    System.out.println("退票价格为：" + trainProxy.refund());
    DynamicProxy dynamicProxy = new DynamicProxy(train);
    IAmount amount = dynamicProxy.proxy();
    System.out.println("最终价格为：" + amount.sell());
    System.out.println("退票价格为：" + amount.refund());


  }
}
