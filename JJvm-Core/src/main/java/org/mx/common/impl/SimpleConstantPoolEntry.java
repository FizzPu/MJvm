package org.mx.common.impl;

import org.mx.common.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/6 18:58
 */
public class SimpleConstantPoolEntry implements ConstantPoolEntry {
  private final OneByte tag;
  private Object info;

  public SimpleConstantPoolEntry() {
    tag = new OneByteImpl();
  }

  @Override
  public void read(InputStream inputStream) throws IOException {
    tag.read(inputStream);
    switch (tag.getValue()) {
      case 0x01: {
        ConstantUtf8Info constantUtf8Info = new ConstantUtf8InfoImpl();
        constantUtf8Info.read(inputStream);
        info = constantUtf8Info;
        break;
      }
      case 0x03: {
        ConstantInteger constantInteger = new ConstantIntegerImpl();
        constantInteger.read(inputStream);
        info = constantInteger;
        break;
      }
      case 0x04: {
        ConstantFloat constantFloat = new ConstantFloatImpl();
        constantFloat.read(inputStream);
        info = constantFloat;
        break;
      }
      case 0x05: {
        ConstantLongImpl constantLong = new ConstantLongImpl();
        constantLong.read(inputStream);
        info = constantLong;
        break;
      }
      case 0x06: {
        ConstantDouble constantDouble = new ConstantDoubleImpl();
        constantDouble.read(inputStream);
        info = constantDouble;
        break;
      }
      case 0x07: {
        ConstantClass constantClass = new ConstantClassImpl();
        constantClass.read(inputStream);
        info = constantClass;
        break;
      }
      case 0x08: {
        ConstantString constantString = new ConstantStringImpl();
        constantString.read(inputStream);
        info = constantString;
        break;
      }
      case 0x09: {
        ConstantFieldRef constantFieldRef = new ConstantFieldRefImpl();
        constantFieldRef.read(inputStream);
        info = constantFieldRef;
        break;

      }
      case 0x0A: {
        ConstantMethodRef constantMethodRef = new ConstantMethodRefImpl();
        constantMethodRef.read(inputStream);
        info = constantMethodRef;
        break;
      }
      case 0x0B: {
        ConstantInterfaceMethodRef constantInterfaceMethodRef = new ConstantInterfaceMethodRefImpl();
        constantInterfaceMethodRef.read(inputStream);
        info = constantInterfaceMethodRef;
        break;
      }
      case 0x0C: {
        ConstantNameAndType constantNameAndType = new ConstantNameAndTypeImpl();
        constantNameAndType.read(inputStream);
        info = constantNameAndType;
        break;
      }
      case 0x0F: {
        ConstantMethodHandle constantMethodHandle = new ConstantMethodHandleImpl();
        constantMethodHandle.read(inputStream);
        info = constantMethodHandle;
        break;
      }
      case 0x10: {
        ConstantMethodType constantMethodType = new ConstantMethodTypeImpl();
        constantMethodType.read(inputStream);
        info = constantMethodType;
      }
      case 0x12: {
        ConstantInvokeDynamic constantInvokeDynamic = new ConstantInvokeDynamicImpl();
        constantInvokeDynamic.read(inputStream);
        info = constantInvokeDynamic;
        break;
      }
      default: {
        throw new IllegalArgumentException("vm error.");
      }
    }
  }

  @Override
  public Object getInfo() {
    return info;
  }

  @Override
  public String toString() {
    return "SimpleConstantPoolEntry{" +
            "tag=" + tag.getValue() +
            ", info=" + info +
            '}';
  }
}
