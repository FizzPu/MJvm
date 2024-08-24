package org.mx.common.impl;

import org.mx.common.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author FizzPu
 * @since 2024/1/4 20:21
 */
public class JAttributesImpl implements JAttributes {
  private final JAttribute[] attributes;
  private JconstantPool constantPool;

  public JAttributesImpl(TwoByte twoByte) {
    attributes = new JAttributeImpl[twoByte.toUnsignedInt()];

    for (int i = 0; i < twoByte.toUnsignedInt(); i++) {
      JAttributeImpl jAttribute = new JAttributeImpl();
      jAttribute.setConstantPool(constantPool);
      attributes[i] = jAttribute;
    }
  }

  public void setConstantPool(JconstantPool jconstantPool) {
    this.constantPool = jconstantPool;
  }

  @Override
  public void read(InputStream inputStream) throws IOException {
    for (JAttribute attribute : attributes) {
      attribute.read(inputStream);
    }
  }

  @Override
  public Iterator<JAttribute> iterator() {
    return Arrays.stream(attributes).iterator();
  }

  @Override
  public void forEach(Consumer<? super JAttribute> action) {
    JAttributes.super.forEach(action);
  }

  @Override
  public Spliterator<JAttribute> spliterator() {
    return JAttributes.super.spliterator();
  }
}
