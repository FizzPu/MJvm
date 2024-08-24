package org.mx.common.impl;

import org.mx.common.ConstantMethodType;
import org.mx.common.TwoByte;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/6 21:53
 */
public class ConstantMethodTypeImpl implements ConstantMethodType {
  private final TwoByte descriptorIndex = new TwoByteImpl();

  @Override
  public void read(InputStream inputStream) throws IOException {
    descriptorIndex.read(inputStream);
  }
}
