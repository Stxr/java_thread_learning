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
      Object invoke = method.invoke(target, args);
      if (invoke instanceof Integer) {
        System.out.println("我是动态代理商，买票收取6元手续费");
        return (int) invoke + 6;
      } else if (invoke instanceof Double) {
        System.out.println("我是动态代理商，卖票收取6元手续费");
        return (double) invoke - 6;
      }
      return null;
    });
  }
}
