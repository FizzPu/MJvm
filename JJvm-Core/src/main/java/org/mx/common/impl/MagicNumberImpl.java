package org.mx.common.impl;

import org.mx.common.FourByte;
import org.mx.common.MagicNumber;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/4 12:14
 */
public class MagicNumberImpl implements MagicNumber {
  private final FourByte fourByte;

  public MagicNumberImpl() {
    this.fourByte = new FourByteImpl();
  }

  @Override
  public void read(InputStream inputStream) throws IOException {
    inputStream.read(fourByte.getValue());
  }

}
