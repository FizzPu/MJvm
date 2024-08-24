package org.mx.common.impl;

import org.mx.common.JFieldEntry;
import org.mx.common.JFields;
import org.mx.common.TwoByte;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/4 20:19
 */
public class JFieldsImpl implements JFields {
  private final JFieldEntry[] jFieldEntries;

  public JFieldsImpl(TwoByte length) {
    jFieldEntries = new JFieldEntryImpl[length.toUnsignedInt()];

    for (int i = 0; i < length.toUnsignedInt(); i++) {
      jFieldEntries[i] = new JFieldEntryImpl();
    }
  }

  @Override
  public void read(InputStream inputStream) throws IOException {
    for (JFieldEntry jFieldEntry : jFieldEntries) {
      jFieldEntry.read(inputStream);
    }
  }
}
