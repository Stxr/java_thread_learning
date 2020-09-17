package apt;
@Factory(type = IShape.class, id = "Triangle")
public class Triangle implements IShape {
  @Override
  public void draw() {
    System.out.println("Draw a triangle");
  }
}
