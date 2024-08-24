package org.mx.common.impl;

import org.mx.common.OneByte;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @author FizzPu
 * @since 2024/1/3 20:16
 */
public class OneByteImpl implements OneByte {
  private byte value;

  public OneByteImpl() {
    value = 0;
  }

  public OneByteImpl(byte value) {
    this.value = value;
  }

  @Override
  public byte getValue() {
    return value;
  }

  @Override
  public void read(InputStream inputStream) throws IOException {
    byte[] bytes = new byte[1];
    inputStream.read(bytes);
    value = bytes[0];
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OneByteImpl oneByte = (OneByteImpl) o;
    return value == oneByte.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
