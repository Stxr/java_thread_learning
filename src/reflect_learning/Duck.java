package reflect_learning;

public class Duck {
  private int footCount = 2;

  public void say() {
    System.out.println("ga ga ga...");
  }

  private void fly() {
    footCount = 1;
    System.out.println("fly skill");
  }

  @Override
  public String toString() {
    return "Duck{" +
      "footCount=" + footCount +
      '}';
  }
}
