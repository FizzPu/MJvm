package org.mx.common.impl;

import org.mx.common.JInterfaces;
import org.mx.common.TwoByte;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/4 20:18
 */
public class InterfacesCollection implements JInterfaces {
  private final TwoByte[] classIndexList;

  public InterfacesCollection(TwoByte length) {
    classIndexList = new TwoByteImpl[length.toUnsignedInt()];
    for (int i = 0; i < length.toUnsignedInt(); i++) {
      classIndexList[i] = new TwoByteImpl();
    }
  }

  @Override
  public void read(InputStream inputStream) throws IOException {
    for (TwoByte twoByte : classIndexList) {
      twoByte.read(inputStream);
    }

  }
}
