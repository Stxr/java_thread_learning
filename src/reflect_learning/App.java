package reflect_learning;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class App {
  public static void main(String[] args) {
    Duck duck = new Duck();
    duck.say();

    try {
      Class<?> customDuck = Class.forName("reflect_learning.Duck");
      Duck mutantDuck = (Duck) customDuck.newInstance();
      //  获取私有方法
      Method fly = customDuck.getDeclaredMethod("fly");
      fly.setAccessible(true);
      // 获取私有变量
      Field footCount = customDuck.getDeclaredField("footCount");
      footCount.setAccessible(true);

      mutantDuck.say();
      fly.invoke(mutantDuck);
      System.out.println(mutantDuck);
      // 更改私有变量
      footCount.set(mutantDuck, 3);
      System.out.println(mutantDuck);
      System.out.println(duck);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
