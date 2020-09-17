package apt;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;

public class FactoryAnnotatedClass {
  private  String simpleName;
  private TypeElement annotatedClassElement;
  private String id;
  private  String canonicalName;

  public FactoryAnnotatedClass(TypeElement classElement) {
    annotatedClassElement = classElement;
    Factory annotation = classElement.getAnnotation(Factory.class);
    id = annotation.id();
    try {
      Class<?> clazz = annotation.type();
      canonicalName = clazz.getCanonicalName();
      simpleName = clazz.getSimpleName();
    } catch (MirroredTypeException mte) {

    }
  }

  public String getSimpleName() {
    return simpleName;
  }

  public TypeElement getAnnotatedClassElement() {
    return annotatedClassElement;
  }

  public String getId() {
    return id;
  }

  public String getCanonicalName() {
    return canonicalName;
  }
}
