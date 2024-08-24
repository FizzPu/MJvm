package org.mx.common.impl;

import org.mx.common.ConstantClass;
import org.mx.common.TwoByte;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/6 21:46
 */
public class ConstantClassImpl implements ConstantClass {
  private final TwoByte twoByte = new TwoByteImpl();
  
  @Override
  public void read(InputStream inputStream) throws IOException {
    twoByte.read(inputStream);
  }
}
