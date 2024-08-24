package org.mx.common;

/**
 * @author FizzPu
 * @since 2024/1/3 20:10
 */
public interface JMethod extends Readable {
    String getMethodName();

    CodeAttribute getCodeAttribute();
}
