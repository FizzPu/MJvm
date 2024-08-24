package org.mx.common.impl;

import org.mx.common.TwoByte;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author FizzPu
 * @since 2024/1/3 20:16
 */
public class TwoByteImpl implements TwoByte {
  private final byte[] value = new byte[2];

  public TwoByteImpl() {
  }

  public TwoByteImpl(byte[] value) {
    Objects.requireNonNull(value);

    System.arraycopy(value, 0, this.value, 0, Math.min(value.length, this.value.length));
  }

  @Override
  public byte[] getValue() {
    return value;
  }

  @Override
  public void read(InputStream inputStream) throws IOException {
    inputStream.read(value);
  }

  @Override
  public int toUnsignedInt() {
    return value[1] + value[0] * 256;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TwoByteImpl twoByte = (TwoByteImpl) o;
    return Arrays.equals(value, twoByte.value);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(value);
  }
}
