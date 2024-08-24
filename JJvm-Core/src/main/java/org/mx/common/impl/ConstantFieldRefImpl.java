package org.mx.common.impl;

import org.mx.common.ConstantFieldRef;
import org.mx.common.TwoByte;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/6 21:50
 */
public class ConstantFieldRefImpl implements ConstantFieldRef {
  private final TwoByte classIndex = new TwoByteImpl();
  private final TwoByte nameAndTypeIndex = new TwoByteImpl();

  @Override
  public void read(InputStream inputStream) throws IOException {
    classIndex.read(inputStream);
    nameAndTypeIndex.read(inputStream);
  }
}
