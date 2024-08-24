package org.mx.common;

/**
 * @author FizzPu
 * @since 2024/1/3 20:02
 */
public interface JconstantPool extends Readable {
    ConstantPoolEntry at(TwoByte nameIndex);
}
