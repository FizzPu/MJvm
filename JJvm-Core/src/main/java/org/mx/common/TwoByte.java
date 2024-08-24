package org.mx.common;

/**
 * @author FizzPu
 * @since 2024/1/3 19:56
 */
public interface TwoByte extends Jtype, Readable {
  byte[] getValue();

  int toUnsignedInt();
}
