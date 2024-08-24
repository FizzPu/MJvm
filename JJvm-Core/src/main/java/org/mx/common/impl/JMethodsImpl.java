package org.mx.common.impl;

import org.mx.common.JMethods;
import org.mx.common.JMethod;
import org.mx.common.JconstantPool;
import org.mx.common.TwoByte;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author FizzPu
 * @since 2024/1/4 20:20
 */
public class JMethodsImpl implements JMethods {
  private final JMethod[] methods;
  private JconstantPool constantPool;

  public JMethodsImpl(TwoByte twoByte) {
    methods = new JMethodImpl[twoByte.toUnsignedInt()];

    for (int i = 0; i < twoByte.toUnsignedInt(); i++) {
     methods[i] = new JMethodImpl();
    }
  }

  public void setConstantPool(JconstantPool constantPool) {
    this.constantPool = constantPool;
  }

  @Override
  public void read(InputStream inputStream) throws IOException {
    for (JMethod method : methods) {
      if (method instanceof JMethodImpl) {
        ((JMethodImpl) method).setConstantPool(constantPool);
      }
      method.read(inputStream);
    }
  }

  @Override
  public Iterator<JMethod> iterator() {
    return Arrays.stream(methods).iterator();
  }
}
