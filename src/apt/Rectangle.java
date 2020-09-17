package apt;

@Factory(type = IShape.class, id = "Rectangle")
public class Rectangle implements IShape {
  @Override
  public void draw() {
    System.out.println("Draw a Rectangle");
  }
}
