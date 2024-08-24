package org.mx.common.impl;

import org.mx.common.MinorVersion;
import org.mx.common.TwoByte;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/4 15:20
 */
public class MinorVersionImpl implements MinorVersion {
  private final TwoByte twoByte;

  public MinorVersionImpl() {
    twoByte = new TwoByteImpl();
  }

  @Override
  public void read(InputStream inputStream) throws IOException {
    inputStream.read(twoByte.getValue());
  }

}
