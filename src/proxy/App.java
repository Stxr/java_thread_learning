package proxy;

public class App {
    public static void main(String[] args) {
        IAmount train = new Train();
        System.out.println(train.sell());

        TrainProxy trainProxy = new TrainProxy(train);
        System.out.println(trainProxy.sell());

        DynamicProxy dynamicProxy = new DynamicProxy(train);
        IAmount amount = dynamicProxy.proxy();
        System.out.println(amount.sell());

    }
}
