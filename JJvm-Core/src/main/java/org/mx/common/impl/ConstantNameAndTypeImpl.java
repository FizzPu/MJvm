package org.mx.common.impl;

import org.mx.common.ConstantNameAndType;
import org.mx.common.TwoByte;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/6 21:52
 */
public class ConstantNameAndTypeImpl implements ConstantNameAndType {
  private final TwoByte nameIndex = new TwoByteImpl();
  private final TwoByte descriptorIndex = new TwoByteImpl();

  @Override
  public void read(InputStream inputStream) throws IOException {
    nameIndex.read(inputStream);
    descriptorIndex.read(inputStream);
  }
}
