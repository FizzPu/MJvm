package org.mx.common.impl;

import org.mx.common.ConstantMethodHandle;
import org.mx.common.OneByte;
import org.mx.common.TwoByte;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/6 21:53
 */
public class ConstantMethodHandleImpl implements ConstantMethodHandle {
  private final OneByte referenceKind = new OneByteImpl();
  private final TwoByte referenceIndex = new TwoByteImpl();

  @Override
  public void read(InputStream inputStream) throws IOException {
    referenceKind.read(inputStream);
    referenceIndex.read(inputStream);
  }
}
