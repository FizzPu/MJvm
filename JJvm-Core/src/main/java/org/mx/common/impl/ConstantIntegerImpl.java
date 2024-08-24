package org.mx.common.impl;

import org.mx.common.ConstantInteger;
import org.mx.common.FourByte;
import org.mx.common.TwoByte;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/6 21:36
 */
public class ConstantIntegerImpl implements ConstantInteger {
  private final FourByte fourByte = new FourByteImpl();

  @Override
  public void read(InputStream inputStream) throws IOException {
    fourByte.read(inputStream);
  }
}
