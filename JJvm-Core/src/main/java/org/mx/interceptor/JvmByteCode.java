package org.mx.interceptor;

import org.mx.common.impl.OneByteImpl;
import org.mx.common.InterpretorFunc;
import org.mx.common.OneByte;

/**
 * @author FizzPu
 * @since 2024/1/10 20:09
 */
public class JvmByteCode implements ByteCode {
    private String desc;
    private OneByte length;
    private OneByte operator;
    private OneByte[] operands;
    private InterpretorFunc interpretorFunc;

    public JvmByteCode(String desc, OneByte length, OneByte operator, InterpretorFunc interpretorFunc) {
        this.desc = desc;
        this.length = length;
        this.operator = operator;
        this.interpretorFunc = interpretorFunc;
    }

    private static JvmByteCode[] byteCodes = {
            new JvmByteCode("nop", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x00), new InterpretorFunc() {}),
            new JvmByteCode("aconst_null", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x01), new InterpretorFunc() {}),
            new JvmByteCode("iconst_m1", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x02), new InterpretorFunc() {}),
            new JvmByteCode("iconst_0", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x03), new InterpretorFunc() {}),
            new JvmByteCode("iconst_1", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x04), new InterpretorFunc() {}),
            new JvmByteCode("iconst_2", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x05), new InterpretorFunc() {}),
            new JvmByteCode("iconst_3", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x06), new InterpretorFunc() {}),
            new JvmByteCode("iconst_4", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x07), new InterpretorFunc() {}),
            new JvmByteCode("iconst_5", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x08), new InterpretorFunc() {}),
            new JvmByteCode("lconst_0", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x09), new InterpretorFunc() {}),
            new JvmByteCode("lconst_1", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x0a), new InterpretorFunc() {}),
            new JvmByteCode("fconst_0", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x0b), new InterpretorFunc() {}),
            new JvmByteCode("fconst_1", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x0c), new InterpretorFunc() {}),
            new JvmByteCode("fconst_2", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x0d), new InterpretorFunc() {}),
            new JvmByteCode("dconst_0", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x0e), new InterpretorFunc() {}),
            new JvmByteCode("dconst_1", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x0f), new InterpretorFunc() {}),
            new JvmByteCode("bipush", new OneByteImpl((byte) 2), new OneByteImpl((byte) 0x10), new InterpretorFunc() {}),
            new JvmByteCode("sipush", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0x11), new InterpretorFunc() {}),
            new JvmByteCode("ldc", new OneByteImpl((byte) 2), new OneByteImpl((byte) 0x12), new InterpretorFunc() {}),
            new JvmByteCode("ldc_w", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0x13), new InterpretorFunc() {}),
            new JvmByteCode("ldc2_w", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0x14), new InterpretorFunc() {}),
            new JvmByteCode("iload", new OneByteImpl((byte) 2), new OneByteImpl((byte) 0x15), new InterpretorFunc() {}),
            new JvmByteCode("lload", new OneByteImpl((byte) 2), new OneByteImpl((byte) 0x16), new InterpretorFunc() {}),
            new JvmByteCode("fload", new OneByteImpl((byte) 2), new OneByteImpl((byte) 0x17), new InterpretorFunc() {}),
            new JvmByteCode("dload", new OneByteImpl((byte) 2), new OneByteImpl((byte) 0x18), new InterpretorFunc() {}),
            new JvmByteCode("aload", new OneByteImpl((byte) 2), new OneByteImpl((byte) 0x19), new InterpretorFunc() {}),
            new JvmByteCode("iload_0", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x1a), new InterpretorFunc() {}),
            new JvmByteCode("iload_1", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x1b), new InterpretorFunc() {}),
            new JvmByteCode("iload_2", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x1c), new InterpretorFunc() {}),
            new JvmByteCode("iload_3", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x1d), new InterpretorFunc() {}),
            new JvmByteCode("lload_0", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x1e), new InterpretorFunc() {}),
            new JvmByteCode("lload_1", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x1f), new InterpretorFunc() {}),
            new JvmByteCode("lload_2", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x20), new InterpretorFunc() {}),
            new JvmByteCode("lload_3", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x21), new InterpretorFunc() {}),
            new JvmByteCode("fload_0", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x22), new InterpretorFunc() {}),
            new JvmByteCode("fload_1", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x23), new InterpretorFunc() {}),
            new JvmByteCode("fload_2", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x24), new InterpretorFunc() {}),
            new JvmByteCode("fload_3", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x25), new InterpretorFunc() {}),
            new JvmByteCode("dload_0", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x26), new InterpretorFunc() {}),
            new JvmByteCode("dload_1", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x27), new InterpretorFunc() {}),
            new JvmByteCode("dload_2", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x28), new InterpretorFunc() {}),
            new JvmByteCode("dload_3", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x29), new InterpretorFunc() {}),
            new JvmByteCode("aload_0", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x2a), new InterpretorFunc() {}),
            new JvmByteCode("aload_1", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x2b), new InterpretorFunc() {}),
            new JvmByteCode("aload_2", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x2c), new InterpretorFunc() {}),
            new JvmByteCode("aload_3", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x2d), new InterpretorFunc() {}),
            new JvmByteCode("iaload", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x2e), new InterpretorFunc() {}),
            new JvmByteCode("laload", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x2f), new InterpretorFunc() {}),
            new JvmByteCode("faload", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x30), new InterpretorFunc() {}),
            new JvmByteCode("daload", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x31), new InterpretorFunc() {}),
            new JvmByteCode("aaload", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x32), new InterpretorFunc() {}),
            new JvmByteCode("baload", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x33), new InterpretorFunc() {}),
            new JvmByteCode("caload", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x34), new InterpretorFunc() {}),
            new JvmByteCode("saload", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x35), new InterpretorFunc() {}),
            new JvmByteCode("istore", new OneByteImpl((byte) 2), new OneByteImpl((byte) 0x36), new InterpretorFunc() {}),
            new JvmByteCode("lstore", new OneByteImpl((byte) 2), new OneByteImpl((byte) 0x37), new InterpretorFunc() {}),
            new JvmByteCode("fstore", new OneByteImpl((byte) 2), new OneByteImpl((byte) 0x38), new InterpretorFunc() {}),
            new JvmByteCode("dstore", new OneByteImpl((byte) 2), new OneByteImpl((byte) 0x39), new InterpretorFunc() {}),
            new JvmByteCode("astore", new OneByteImpl((byte) 2), new OneByteImpl((byte) 0x3a), new InterpretorFunc() {}),
            new JvmByteCode("istore_0", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x3b), new InterpretorFunc() {}),
            new JvmByteCode("istore_1", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x3c), new InterpretorFunc() {}),
            new JvmByteCode("istore_2", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x3d), new InterpretorFunc() {}),
            new JvmByteCode("istore_3", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x3e), new InterpretorFunc() {}),
            new JvmByteCode("lstore_0", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x3f), new InterpretorFunc() {}),
            new JvmByteCode("lstore_1", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x40), new InterpretorFunc() {}),
            new JvmByteCode("lstore_2", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x41), new InterpretorFunc() {}),
            new JvmByteCode("lstore_3", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x42), new InterpretorFunc() {}),
            new JvmByteCode("fstore_0", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x43), new InterpretorFunc() {}),
            new JvmByteCode("fstore_1", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x44), new InterpretorFunc() {}),
            new JvmByteCode("fstore_2", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x45), new InterpretorFunc() {}),
            new JvmByteCode("fstore_3", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x46), new InterpretorFunc() {}),
            new JvmByteCode("dstore_0", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x47), new InterpretorFunc() {}),
            new JvmByteCode("dstore_1", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x48), new InterpretorFunc() {}),
            new JvmByteCode("dstore_2", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x49), new InterpretorFunc() {}),
            new JvmByteCode("dstore_3", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x4a), new InterpretorFunc() {}),
            new JvmByteCode("astore_0", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x4b), new InterpretorFunc() {}),
            new JvmByteCode("astore_1", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x4c), new InterpretorFunc() {}),
            new JvmByteCode("astore_2", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x4d), new InterpretorFunc() {}),
            new JvmByteCode("astore_3", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x4e), new InterpretorFunc() {}),
            new JvmByteCode("iastore", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x4f), new InterpretorFunc() {}),
            new JvmByteCode("lastore", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x50), new InterpretorFunc() {}),
            new JvmByteCode("fastore", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x51), new InterpretorFunc() {}),
            new JvmByteCode("dastore", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x52), new InterpretorFunc() {}),
            new JvmByteCode("aastore", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x53), new InterpretorFunc() {}),
            new JvmByteCode("bastore", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x54), new InterpretorFunc() {}),
            new JvmByteCode("castore", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x55), new InterpretorFunc() {}),
            new JvmByteCode("sastore", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x56), new InterpretorFunc() {}),
            new JvmByteCode("pop", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x57), new InterpretorFunc() {}),
            new JvmByteCode("pop2", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x58), new InterpretorFunc() {}),
            new JvmByteCode("dup", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x59), new InterpretorFunc() {}),
            new JvmByteCode("dup_x1", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x5a), new InterpretorFunc() {}),
            new JvmByteCode("dup_x2", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x5b), new InterpretorFunc() {}),
            new JvmByteCode("dup2", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x5c), new InterpretorFunc() {}),
            new JvmByteCode("dup2_x1", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x5d), new InterpretorFunc() {}),
            new JvmByteCode("dup2_x2", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x5e), new InterpretorFunc() {}),
            new JvmByteCode("swap", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x5f), new InterpretorFunc() {}),
            new JvmByteCode("iadd", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x60), new InterpretorFunc() {}),
            new JvmByteCode("ladd", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x61), new InterpretorFunc() {}),
            new JvmByteCode("fadd", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x62), new InterpretorFunc() {}),
            new JvmByteCode("dadd", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x63), new InterpretorFunc() {}),
            new JvmByteCode("isub", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x64), new InterpretorFunc() {}),
            new JvmByteCode("lsub", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x65), new InterpretorFunc() {}),
            new JvmByteCode("fsub", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x66), new InterpretorFunc() {}),
            new JvmByteCode("dsub", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x67), new InterpretorFunc() {}),
            new JvmByteCode("imul", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x68), new InterpretorFunc() {}),
            new JvmByteCode("lmul", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x69), new InterpretorFunc() {}),
            new JvmByteCode("fmul", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x6a), new InterpretorFunc() {}),
            new JvmByteCode("dmul", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x6b), new InterpretorFunc() {}),
            new JvmByteCode("idiv", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x6c), new InterpretorFunc() {}),
            new JvmByteCode("ldiv", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x6d), new InterpretorFunc() {}),
            new JvmByteCode("fdiv", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x6e), new InterpretorFunc() {}),
            new JvmByteCode("ddiv", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x6f), new InterpretorFunc() {}),
            new JvmByteCode("irem", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x70), new InterpretorFunc() {}),
            new JvmByteCode("lrem", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x71), new InterpretorFunc() {}),
            new JvmByteCode("frem", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x72), new InterpretorFunc() {}),
            new JvmByteCode("drem", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x73), new InterpretorFunc() {}),
            new JvmByteCode("ineg", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x74), new InterpretorFunc() {}),
            new JvmByteCode("lneg", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x75), new InterpretorFunc() {}),
            new JvmByteCode("fneg", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x76), new InterpretorFunc() {}),
            new JvmByteCode("dneg", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x77), new InterpretorFunc() {}),
            new JvmByteCode("ishl", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x78), new InterpretorFunc() {}),
            new JvmByteCode("lshl", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x79), new InterpretorFunc() {}),
            new JvmByteCode("ishr", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x7a), new InterpretorFunc() {}),
            new JvmByteCode("lshr", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x7b), new InterpretorFunc() {}),
            new JvmByteCode("iushr", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x7c), new InterpretorFunc() {}),
            new JvmByteCode("lushr", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x7d), new InterpretorFunc() {}),
            new JvmByteCode("iand", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x7e), new InterpretorFunc() {}),
            new JvmByteCode("land", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x7f), new InterpretorFunc() {}),
            new JvmByteCode("ior", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x80), new InterpretorFunc() {}),
            new JvmByteCode("lor", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x81), new InterpretorFunc() {}),
            new JvmByteCode("ixor", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x82), new InterpretorFunc() {}),
            new JvmByteCode("lxor", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x83), new InterpretorFunc() {}),
            new JvmByteCode("iinc", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0x84), new InterpretorFunc() {}),
            new JvmByteCode("i2l", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x85), new InterpretorFunc() {}),
            new JvmByteCode("i2f", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x86), new InterpretorFunc() {}),
            new JvmByteCode("i2d", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x87), new InterpretorFunc() {}),
            new JvmByteCode("l2i", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x88), new InterpretorFunc() {}),
            new JvmByteCode("l2f", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x89), new InterpretorFunc() {}),
            new JvmByteCode("l2d", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x8a), new InterpretorFunc() {}),
            new JvmByteCode("f2i", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x8b), new InterpretorFunc() {}),
            new JvmByteCode("f2l", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x8c), new InterpretorFunc() {}),
            new JvmByteCode("f2d", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x8d), new InterpretorFunc() {}),
            new JvmByteCode("d2i", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x8e), new InterpretorFunc() {}),
            new JvmByteCode("d2l", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x8f), new InterpretorFunc() {}),
            new JvmByteCode("d2f", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x90), new InterpretorFunc() {}),
            new JvmByteCode("i2b", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x91), new InterpretorFunc() {}),
            new JvmByteCode("i2c", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x92), new InterpretorFunc() {}),
            new JvmByteCode("i2s", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x93), new InterpretorFunc() {}),
            new JvmByteCode("lcmp", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x94), new InterpretorFunc() {}),
            new JvmByteCode("fcmpl", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x95), new InterpretorFunc() {}),
            new JvmByteCode("fcmpg", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x96), new InterpretorFunc() {}),
            new JvmByteCode("dcmpl", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x97), new InterpretorFunc() {}),
            new JvmByteCode("dcmpg", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0x98), new InterpretorFunc() {}),
            new JvmByteCode("ifeq", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0x99), new InterpretorFunc() {}),
            new JvmByteCode("ifne", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0x9a), new InterpretorFunc() {}),
            new JvmByteCode("iflt", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0x9b), new InterpretorFunc() {}),
            new JvmByteCode("ifge", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0x9c), new InterpretorFunc() {}),
            new JvmByteCode("ifgt", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0x9d), new InterpretorFunc() {}),
            new JvmByteCode("ifle", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0x9e), new InterpretorFunc() {}),
            new JvmByteCode("if_icmpeq", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0x9f), new InterpretorFunc() {}),
            new JvmByteCode("if_icmpne", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xa0), new InterpretorFunc() {}),
            new JvmByteCode("if_icmplt", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xa1), new InterpretorFunc() {}),
            new JvmByteCode("if_icmpge", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xa2), new InterpretorFunc() {}),
            new JvmByteCode("if_icmpgt", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xa3), new InterpretorFunc() {}),
            new JvmByteCode("if_icmple", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xa4), new InterpretorFunc() {}),
            new JvmByteCode("if_acmpeq", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xa5), new InterpretorFunc() {}),
            new JvmByteCode("if_acmpne", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xa6), new InterpretorFunc() {}),
            new JvmByteCode("goto", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xa7), new InterpretorFunc() {}),
            new JvmByteCode("jsr", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xa8), new InterpretorFunc() {}),
            new JvmByteCode("ret", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xa9), new InterpretorFunc() {}),
            new JvmByteCode("tableswitch", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xaa), new InterpretorFunc() {}),
            new JvmByteCode("lookupswitch", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xab), new InterpretorFunc() {}),
            new JvmByteCode("ireturn", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xac), new InterpretorFunc() {}),
            new JvmByteCode("lreturn", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xad), new InterpretorFunc() {}),
            new JvmByteCode("freturn", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xae), new InterpretorFunc() {}),
            new JvmByteCode("dreturn", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xaf), new InterpretorFunc() {}),
            new JvmByteCode("areturn", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xb0), new InterpretorFunc() {}),
            new JvmByteCode("return", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xb1), new InterpretorFunc() {}),
            new JvmByteCode("getstatic", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xb2), new InterpretorFunc() {}),
            new JvmByteCode("putstatic", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xb3), new InterpretorFunc() {}),
            new JvmByteCode("getfield", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xb4), new InterpretorFunc() {}),
            new JvmByteCode("putfield", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xb5), new InterpretorFunc() {}),
            new JvmByteCode("invokevirtual", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xb6), new InterpretorFunc() {}),
            new JvmByteCode("invokespecial", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xb7), new InterpretorFunc() {}),
            new JvmByteCode("invokestatic", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xb8), new InterpretorFunc() {}),
            new JvmByteCode("invokeinterface", new OneByteImpl((byte) 5), new OneByteImpl((byte) 0xb9), new InterpretorFunc() {}),
            new JvmByteCode("invokedynamic", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xba), new InterpretorFunc() {}),
            new JvmByteCode("new", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xbb), new InterpretorFunc() {}),
            new JvmByteCode("newarray", new OneByteImpl((byte) 2), new OneByteImpl((byte) 0xbc), new InterpretorFunc() {}),
            new JvmByteCode("anewarray", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xbd), new InterpretorFunc() {}),
            new JvmByteCode("arraylength", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xbe), new InterpretorFunc() {}),
            new JvmByteCode("athrow", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xbf), new InterpretorFunc() {}),
            new JvmByteCode("checkcast", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xc0), new InterpretorFunc() {}),
            new JvmByteCode("instanceof", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xc1), new InterpretorFunc() {}),
            new JvmByteCode("monitorenter", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xc2), new InterpretorFunc() {}),
            new JvmByteCode("monitorexit", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xc3), new InterpretorFunc() {}),
            new JvmByteCode("wide", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xc4), new InterpretorFunc() {}),
            new JvmByteCode("multianewarray", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xc5), new InterpretorFunc() {}),
            new JvmByteCode("ifnull", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xc6), new InterpretorFunc() {}),
            new JvmByteCode("ifnonnull", new OneByteImpl((byte) 3), new OneByteImpl((byte) 0xc7), new InterpretorFunc() {}),
            new JvmByteCode("goto_w", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xc8), new InterpretorFunc() {}),
            new JvmByteCode("jsr_w", new OneByteImpl((byte) 1), new OneByteImpl((byte) 0xc9), new InterpretorFunc() {}),
    };

    public static JvmByteCode instance(OneByte operator) {
        return null;
    }

}
