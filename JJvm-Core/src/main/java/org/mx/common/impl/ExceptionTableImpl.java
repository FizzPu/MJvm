package org.mx.common.impl;

import org.mx.common.ExceptionTable;
import org.mx.common.TwoByte;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/18 20:01
 */
public class ExceptionTableImpl implements ExceptionTable {
    // start_pc 和 end_pc 两项的值表明了异常处理器在 code[]数组中的有效范围
    private TwoByte startPc;
    private TwoByte endPj;
    private TwoByte handlerPc;
    private TwoByte catchType;

    @Override
    public void read(InputStream inputStream) throws IOException {

    }
}
