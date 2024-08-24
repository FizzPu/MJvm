package org.mx.common.impl;

import org.mx.common.ConstantInvokeDynamic;
import org.mx.common.TwoByte;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/6 21:54
 */
public class ConstantInvokeDynamicImpl implements ConstantInvokeDynamic {
  private final TwoByte bootstrapMethodAttrIndex = new TwoByteImpl();
  private final TwoByte nameAndTypeIndex = new TwoByteImpl();
  @Override
  public void read(InputStream inputStream) throws IOException {
    bootstrapMethodAttrIndex.read(inputStream);
    nameAndTypeIndex.read(inputStream);
  }
}
