package org.mx.common.impl;

import org.mx.common.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/7 00:09
 */
public class JAttributeImpl implements JAttribute {
  private final TwoByte attributeNameIndex = new TwoByteImpl();
  private final FourByte attributeLength = new FourByteImpl();
  private OneByte[] info;

  private JconstantPool constantPool;
  private MethodAttributeType methodAttributeType;

  public void setConstantPool(JconstantPool constantPool) {
    this.constantPool = constantPool;
  }

  @Override
  public void read(InputStream inputStream) throws IOException {
    attributeNameIndex.read(inputStream);
    attributeLength.read(inputStream);

    byte[] bytes = new byte[attributeLength.toUnsignedInt()];
    inputStream.read(bytes);

    info = new OneByteImpl[attributeLength.toUnsignedInt()];
    for (int i = 0; i < info.length; i++) {
      info[i] = new OneByteImpl(bytes[i]);
    }

    onAttributeReadDone();
  }

  private void onAttributeReadDone() {

  }

  @Override
  public TwoByte getAttributeNameIndex() {
    return attributeNameIndex;
  }

  @Override
  public FourByte getAttributeLength() {
    return attributeLength;
  }

  @Override
  public OneByte[] getData() {
    return info;
  }

  @Override
  public AttributeType getAttributeType() {
    ConstantPoolEntry constantPoolEntry = constantPool.at(attributeNameIndex);
    if (!(constantPoolEntry.getInfo() instanceof ConstantUtf8Info)) {
      throw new IllegalArgumentException("illegal class file format");
    }
    ConstantUtf8Info name = (ConstantUtf8Info) constantPoolEntry.getInfo();
    if ("Code".equals(new String(name.getChars()))) {
      return MethodAttributeType.CODE_ATTRIBUTE;
    }
    return MethodAttributeType.UNKNOWN;
  }

  @Override
  public boolean isCodeAttribute() {
    return getAttributeType() == MethodAttributeType.CODE_ATTRIBUTE;
  }
}
