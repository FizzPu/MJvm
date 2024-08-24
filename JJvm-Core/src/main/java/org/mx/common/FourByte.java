package org.mx.common;

/**
 * @author FizzPu
 * @since 2024/1/3 19:57
 */
public interface FourByte extends Jtype, Readable {
  byte[] getValue();

  int toUnsignedInt();
}
