package org.mx.common.impl;

import org.mx.common.ConstantLong;
import org.mx.common.FourByte;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/6 21:38
 */
public class ConstantLongImpl implements ConstantLong {
  private final FourByte highBytes = new FourByteImpl();
  private final FourByte lowBytes = new FourByteImpl();

  @Override
  public void read(InputStream inputStream) throws IOException {
    highBytes.read(inputStream);
    lowBytes.read(inputStream);
  }

}
