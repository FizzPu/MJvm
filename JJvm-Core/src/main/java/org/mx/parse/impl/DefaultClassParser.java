package org.mx.parse.impl;

import org.mx.common.*;
import org.mx.common.impl.*;
import org.mx.parse.ClassParser;

import java.io.*;
import java.util.Objects;

/**
 * @author FizzPu
 * @since 2024/1/4 10:38
 */
public class DefaultClassParser implements ClassParser {
  @Override
  public JClass loadClass(String className, String classPath) {
    String path = getClassLocation(className, classPath);
    File classFile = new File(path);
    if (!classFile.exists()) {
      throw new IllegalArgumentException("class " + classFile + " not found");
    }

    JClass jClass = new JClassImpl();
    try (FileInputStream fileInputStream = new FileInputStream(classFile)) {
      jClass.getMaicNumber().read(fileInputStream);
      jClass.getMinorVersion().read(fileInputStream);
      jClass.getMajorVersion().read(fileInputStream);
      jClass.getConstantPoolCount().read(fileInputStream);

      JconstantPool constantPool = new SimpleConstantPool(jClass.getConstantPoolCount());
      constantPool.read(fileInputStream);
      jClass.setConstantPool(constantPool);

      jClass.getAccessFlag().read(fileInputStream);
      jClass.getThisClass().read(fileInputStream);
      jClass.getSuperClass().read(fileInputStream);

      jClass.getInterfacesCount().read(fileInputStream);
      JInterfaces interfaces = new InterfacesCollection(jClass.getInterfacesCount());
      interfaces.read(fileInputStream);

      jClass.getFieldsCount().read(fileInputStream);
      JFields jFields = new JFieldsImpl(jClass.getFieldsCount());
      jFields.read(fileInputStream);
      jClass.setJFields(jFields);

      jClass.getMethodsCount().read(fileInputStream);
      JMethodsImpl jMethods = new JMethodsImpl(jClass.getMethodsCount());
      jMethods.setConstantPool(constantPool);
      jMethods.read(fileInputStream);
      jClass.setJMethods(jMethods);

      jClass.getAttributesCount().read(fileInputStream);
      JAttributesImpl jAttributes = new JAttributesImpl(jClass.getAttributesCount());

      jAttributes.read(fileInputStream);
      jClass.setJAttributes(jAttributes);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    // ignore
    return jClass;
  }

  @Override
  public String getClassLocation(String className, String classPath) {
    Objects.requireNonNull(className);
    Objects.requireNonNull(classPath);

    return String.format("%s/%s", classPath, className);
  }

}
