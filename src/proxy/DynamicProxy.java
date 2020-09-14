package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    IAmount target;

    public DynamicProxy(IAmount target) {
        this.target = target;
    }

    public <T> T proxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("我是动态代理商，需要收取6元手续费");
            return (int) method.invoke(target, args) + 6;
        });
    }
}
