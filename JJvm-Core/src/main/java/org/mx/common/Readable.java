package org.mx.common;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/4 12:17
 */
public interface Readable {
  void read(InputStream inputStream) throws IOException;
}
