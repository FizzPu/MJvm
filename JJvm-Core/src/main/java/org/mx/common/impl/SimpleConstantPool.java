package org.mx.common.impl;

import org.mx.common.ConstantPoolEntry;
import org.mx.common.JconstantPool;
import org.mx.common.TwoByte;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/4 20:16
 */
public class SimpleConstantPool implements JconstantPool {
  private final ConstantPoolEntry[] constantPool;

  public SimpleConstantPool(TwoByte constantPoolLen) {
    this.constantPool = new ConstantPoolEntry[constantPoolLen.toUnsignedInt()];
    for (int i = 0; i < constantPool.length; i++) {
      constantPool[i] = new SimpleConstantPoolEntry();
    }
  }

  @Override
  public void read(InputStream inputStream) throws IOException {
    if (constantPool == null) {
      return;
    }

    // start from 1
    for (int i = 1; i < constantPool.length; i++) {
      constantPool[i].read(inputStream);
    }
  }

  @Override
  public ConstantPoolEntry at(TwoByte nameIndex) {
    return constantPool[nameIndex.toUnsignedInt()];
  }
}
