package org.mx.common.impl;

import org.mx.common.ConstantString;
import org.mx.common.TwoByte;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/6 21:49
 */
public class ConstantStringImpl implements ConstantString {
  private final TwoByte strIndex = new TwoByteImpl();
  @Override
  public void read(InputStream inputStream) throws IOException {
    strIndex.read(inputStream);
  }
}
