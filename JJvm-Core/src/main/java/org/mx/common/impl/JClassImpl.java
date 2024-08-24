package org.mx.common.impl;

import org.mx.common.*;

/**
 * @author FizzPu
 * @since 2024/1/4 11:23
 */
public class JClassImpl implements JClass {
  private final FourByte magicNumber;
  private final TwoByte minorVersion;
  private final TwoByte majorVersion;

  private final TwoByte constantPoolCount;
  private JconstantPool jconstantPool;

  private final TwoByte accessFlag;

  private final TwoByte thisClass;
  private final TwoByte superClass;

  private final TwoByte interfacesCount;
  private JInterfaces interfaces;

  private final TwoByte fieldsCount;
  private JFields jfields;

  private final TwoByte methodsCount;
  private JMethods jmethods;

  private final TwoByte attributesCount;
  private JAttributes jattributes;

  public JClassImpl() {
    magicNumber = new FourByteImpl();
    minorVersion = new TwoByteImpl();
    majorVersion = new TwoByteImpl();

    constantPoolCount = new TwoByteImpl();
    jconstantPool = new SimpleConstantPool(constantPoolCount);

    accessFlag = new TwoByteImpl();
    thisClass = new TwoByteImpl();
    superClass = new TwoByteImpl();

    interfacesCount = new TwoByteImpl();
    interfaces = new InterfacesCollection(interfacesCount);

    fieldsCount = new TwoByteImpl();
    jfields = new JFieldsImpl(fieldsCount);

    methodsCount = new TwoByteImpl();
    jmethods = new JMethodsImpl(methodsCount);

    attributesCount = new TwoByteImpl();
    jattributes = new JAttributesImpl(attributesCount);
  }

  @Override
  public FourByte getMaicNumber() {
    return magicNumber;
  }

  @Override
  public TwoByte getMinorVersion() {
    return minorVersion;
  }

  @Override
  public TwoByte getMajorVersion() {
    return majorVersion;
  }

  @Override
  public TwoByte getConstantPoolCount() {
    return constantPoolCount;
  }

  @Override
  public JconstantPool getConstantPool() {
    return jconstantPool;
  }

  @Override
  public void setConstantPool(JconstantPool jconstantPool) {
    this.jconstantPool = jconstantPool;
  }

  @Override
  public TwoByte getAccessFlag() {
    return accessFlag;
  }

  @Override
  public TwoByte getThisClass() {
    return thisClass;
  }

  @Override
  public TwoByte getSuperClass() {
    return superClass;
  }

  @Override
  public TwoByte getInterfacesCount() {
    return interfacesCount;
  }

  @Override
  public JInterfaces getJinterfaces() {
    return interfaces;
  }

  @Override
  public void setJInterfaces(JInterfaces jInterfaces) {
    interfaces = jInterfaces;
  }

  @Override
  public TwoByte getFieldsCount() {
    return fieldsCount;
  }

  @Override
  public JFields getJfields() {
    return jfields;
  }

  @Override
  public void setJFields(JFields jfields) {
    this.jfields = jfields;
  }

  @Override
  public TwoByte getMethodsCount() {
    return methodsCount;
  }

  @Override
  public JMethods getJmethods() {
    return jmethods;
  }

  @Override
  public void setJMethods(JMethods jmethods) {
    this.jmethods = jmethods;
  }

  @Override
  public TwoByte getAttributesCount() {
    return attributesCount;
  }

  @Override
  public JAttributes getJattributes() {
    return jattributes;
  }

  @Override
  public void setJAttributes(JAttributes jattributes) {
    this.jattributes = jattributes;
  }
}
