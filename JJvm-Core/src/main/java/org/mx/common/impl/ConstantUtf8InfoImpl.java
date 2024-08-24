package org.mx.common.impl;

import org.mx.common.ConstantUtf8Info;
import org.mx.common.TwoByte;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/6 21:05
 */
public class ConstantUtf8InfoImpl implements ConstantUtf8Info {
  private byte[] chars;

  @Override
  public void read(InputStream inputStream) throws IOException {
    TwoByte length = new TwoByteImpl();
    inputStream.read(length.getValue());

    chars = new byte[length.toUnsignedInt()];
    inputStream.read(chars);
  }

  @Override
  public byte[] getChars() {
    return chars;
  }
}
