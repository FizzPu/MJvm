package org.mx.common.impl;

import org.mx.common.JFieldEntry;
import org.mx.common.JAttributes;
import org.mx.common.TwoByte;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/6 23:56
 */
public class JFieldEntryImpl implements JFieldEntry {
  private final TwoByte accessFlags = new TwoByteImpl();
  private final TwoByte nameIndex = new TwoByteImpl();
  private final TwoByte descriptorIndex = new TwoByteImpl();
  private JAttributes jattributes;

  @Override
  public void read(InputStream inputStream) throws IOException {
    accessFlags.read(inputStream);
    nameIndex.read(inputStream);
    descriptorIndex.read(inputStream);

    TwoByte attributesCount = new TwoByteImpl();
    attributesCount.read(inputStream);

    jattributes = new JAttributesImpl(attributesCount);
    jattributes.read(inputStream);
  }
}
