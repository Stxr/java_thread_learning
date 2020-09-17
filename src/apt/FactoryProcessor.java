package apt;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class FactoryProcessor extends AbstractProcessor {
  private Types typeUtils;
  // 打印错误信息
  private Messager messager;
  // 用来编写新文件
  private Filer filer;
  // 处理java Elements文件
  private Elements elementUtils;
  private Map<String, FactoryGroupedClasses> factoryClasses = new LinkedHashMap<>();

  @Override
  public synchronized void init(ProcessingEnvironment processingEnv) {
    typeUtils = processingEnv.getTypeUtils();
    messager = processingEnv.getMessager();
    filer = processingEnv.getFiler();
    elementUtils = processingEnv.getElementUtils();
  }

  @Override
  public Set<String> getSupportedAnnotationTypes() {
    LinkedHashSet<String> annotations = new LinkedHashSet<>();
    annotations.add(Factory.class.getCanonicalName());
    return annotations;
  }

  @Override
  public SourceVersion getSupportedSourceVersion() {
    return SourceVersion.latestSupported();
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    for (Element element : roundEnv.getElementsAnnotatedWith(Factory.class)) {
      TypeElement typeElement = (TypeElement) element;
      FactoryAnnotatedClass factoryAnnotatedClass = new FactoryAnnotatedClass(typeElement);
      FactoryGroupedClasses factoryGroupedClasses = factoryClasses.get(factoryAnnotatedClass.getAnnotatedClassElement());
      if (factoryGroupedClasses == null) {
        String qualifiedGroupName = factoryAnnotatedClass.getCanonicalName();
        factoryGroupedClasses = new FactoryGroupedClasses(qualifiedGroupName);
        factoryClasses.put(qualifiedGroupName, factoryGroupedClasses);
      }
      factoryGroupedClasses.add(factoryAnnotatedClass);

    }
    for (FactoryGroupedClasses factoryClass : factoryClasses.values()) {
      try {
        factoryClass.generateCode(elementUtils, filer);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    factoryClasses.clear();
    return true;
  }
}
