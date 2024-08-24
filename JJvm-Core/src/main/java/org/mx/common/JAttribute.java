package org.mx.common;

/**
 * @author FizzPu
 * @since 2024/1/7 00:09
 */
public interface JAttribute extends Readable {
  TwoByte getAttributeNameIndex();

  FourByte getAttributeLength();

  OneByte[] getData();

  AttributeType getAttributeType();

  boolean isCodeAttribute();
}
