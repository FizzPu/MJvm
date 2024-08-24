package org.mx.interceptor.impl;

import org.mx.common.CodeAttribute;
import org.mx.common.JAttribute;
import org.mx.common.JMethod;
import org.mx.common.OneByte;
import org.mx.interceptor.ByteCodeInfo;
import org.mx.interceptor.ByteCodesInterpretor;

/**
 * @author FizzPu
 * @since 2024/1/7 00:53
 */
public class DeafultByteCodesInterpretor implements ByteCodesInterpretor {
  private final ByteCodeInfo byteCodeInfo = new ByteCodeInfo();

  @Override
  public void interpret(JMethod method) {
    CodeAttribute jAttribute = method.getCodeAttribute();
    OneByte[] bytes = jAttribute.getCodes();
    int index = 0;
    int line = 0;
    while (index < bytes.length) {
      byte code = bytes[index].getValue();
      System.out.print("line " + line++ + ": ");
      System.out.print(byteCodeInfo.getCodeDes(code));

      int opLen = byteCodeInfo.getCodeLen(code);
      for (int i = 0; i < opLen - 1; i++) {
        System.out.print(" ");
        System.out.print(bytes[index + i + 1].getValue());
        System.out.print(" ");
      }
      System.out.println();

      index = index + byteCodeInfo.getCodeLen(code);
    }
  }
}
