package org.mx.common.impl;

import org.mx.common.FourByte;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author FizzPu
 * @since 2024/1/3 20:16
 */
public class FourByteImpl implements FourByte {
  private final byte[] value = new byte[4];

  public FourByteImpl() {
  }

  public FourByteImpl(byte[] value) {
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
    int a = Byte.toUnsignedInt(value[2]) * 256 + Byte.toUnsignedInt(value[3]);
    int b = Byte.toUnsignedInt(value[1]) * 256 + a;
    return Byte.toUnsignedInt(value[0]) * 256 + b;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FourByteImpl fourByte = (FourByteImpl) o;
    return Arrays.equals(value, fourByte.value);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(value);
  }
}
