package classloader;

import handler.Looper;
import proxy.Train;

public class App {
  public static void main(String[] args) {
    // AppClassLoader
    System.out.println(Looper.class.getClassLoader());
    // ExtClassLoader
    System.out.println(Looper.class.getClassLoader().getParent());
    // BootstrapClassLoader
    System.out.println(String.class.getClassLoader());
    try {
      Class<?> aClass = Looper.class.getClassLoader().loadClass("proxy.Train");
      Train t = (Train) aClass.newInstance();
      System.out.println("class loader:" + t.sell());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    }
  }
}
