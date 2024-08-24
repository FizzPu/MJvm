package org.mx.common.impl;

import org.mx.common.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * @author FizzPu
 * @since 2024/1/18 19:58
 */
public class CodeAttributeImpl implements CodeAttribute {
    // 表示CodeAttribute占用多少个字节，不包含attributeLength 和 attributeNameIndex 6个字节
    private FourByte attributeLength;
    private TwoByte attributeNameIndex;

    // 最大栈深度
    private TwoByte maxStack;
    // 局部变量表中的局部变量的个数
    private TwoByte maxLocals;

    // code_length 项给出了当前方法的 code[]数组的字节数
    private FourByte codeLength;
    // code[]数组给出了实现当前方法的 Java 虚拟机字节码
    private OneByte[] codes;

    // exception_table_length 项的值给出了 exception_table[]数组的成员个数量
    private TwoByte exceptionTableLength;
    // exception_table[]数组的每个成员表示 code[]数组中的一个异常处理器
    ExceptionTable[] exceptionTables;

    // 属性表的每个成员的值必须是 attribute 结构(§4.7)。一个 Code 属性可以有任意 数量的可选属性与之关联。
    private TwoByte extraAttributesCount;
    JAttributes extraAttributes;

    public CodeAttributeImpl(FourByte attributeLength, TwoByte attributeNameIndex, OneByte[] data) {
        this.attributeLength = attributeLength;
        this.attributeNameIndex = attributeNameIndex;
        this.maxStack = new TwoByteImpl();
        this.maxLocals = new TwoByteImpl();
        this.codeLength = new FourByteImpl();
        exceptionTableLength = new TwoByteImpl();
        extraAttributesCount = new TwoByteImpl();

        byte[] array = new byte[data.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = data[i].getValue();
        }
        InputStream inputStream = new ByteArrayInputStream(array);

        try {
            maxStack.read(inputStream);
            maxLocals.read(inputStream);
            codeLength.read(inputStream);
            codes = new OneByte[codeLength.toUnsignedInt()];
            for (int i = 0; i < codes.length; i++) {
               codes[i] = new OneByteImpl();
               codes[i].read(inputStream);
            }

            exceptionTableLength.read(inputStream);
            exceptionTables = new ExceptionTableImpl[exceptionTableLength.toUnsignedInt()];
            for (int i = 0; i < exceptionTables.length; i++) {
                exceptionTables[i] = new ExceptionTableImpl();
                exceptionTables[i].read(inputStream);
            }

            extraAttributesCount = new TwoByteImpl();
            extraAttributes = new JAttributesImpl(extraAttributesCount);
            extraAttributes.read(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OneByte[] getCodes() {
        return codes;
    }
}
