package apt;

@Factory(type = IShape.class, id = "Circle")
public class Circle implements IShape {
  @Override
  public void draw() {
    System.out.println("Draw a circle");
  }
}
