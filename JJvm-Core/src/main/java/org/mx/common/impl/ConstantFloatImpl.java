package org.mx.common.impl;

import org.mx.common.ConstantFloat;
import org.mx.common.FourByte;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/6 21:41
 */
public class ConstantFloatImpl implements ConstantFloat {
  private final FourByte fourByte = new FourByteImpl();

  @Override
  public void read(InputStream inputStream) throws IOException {
    fourByte.read(inputStream);
  }
}
