package org.mx.common;

/**
 * @author FizzPu
 * @since 2024/1/3 19:49
 */
public interface JClass {
  FourByte getMaicNumber();

  TwoByte getMinorVersion();

  TwoByte getMajorVersion();

  TwoByte getConstantPoolCount();

  JconstantPool getConstantPool();

  void setConstantPool(JconstantPool jconstantPool);

  TwoByte getAccessFlag();

  // 类索引，this_class 的值必须是对 constant_pool 表中项目的一个有效索引值。
  TwoByte getThisClass();

  // 类索引，super_class 的值必须是对 constant_pool 表中项目的一个有效索引值。
  TwoByte getSuperClass();

  TwoByte getInterfacesCount();

  JInterfaces getJinterfaces();

  void setJInterfaces(JInterfaces jInterfaces);

  TwoByte getFieldsCount();

  JFields getJfields();

  void setJFields(JFields jfields);

  TwoByte getMethodsCount();

  JMethods getJmethods();

  void setJMethods(JMethods jmethods);

  //Class 文件结构中的 attributes 表的一般包括内部类、运行时注解等jvm规范包含的信息
  TwoByte getAttributesCount();

  JAttributes getJattributes();

  void setJAttributes(JAttributes jattributes);

}
