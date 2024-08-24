#!/usr/bin/env groovy
/**
 *
 * @author FizzPu
 * @since 2024/1/10 20:52
 */

def str = "{0x00,  1,      \"nop\",          \tjvm_interp_nop},\n" +
        "        {0x01,  1,      \"aconst_null\",          jvm_interp_aconst_null},\n" +
        "        {0x02,  1,      \"iconst_m1\",            jvm_interp_iconst_m1},\n" +
        "        {0x03,  1,      \"iconst_0\",             jvm_interp_iconst_0},\n" +
        "        {0x04,  1,      \"iconst_1\",             jvm_interp_iconst_1},\n" +
        "        {0x05,  1,      \"iconst_2\",             jvm_interp_iconst_2},\n" +
        "        {0x06,  1,      \"iconst_3\",             jvm_interp_iconst_3},\n" +
        "        {0x07,  1,      \"iconst_4\",             jvm_interp_iconst_4},\n" +
        "        {0x08,  1,      \"iconst_5\",             jvm_interp_iconst_5},\n" +
        "        {0x09,  1,      \"lconst_0\",             jvm_interp_lconst_0},\n" +
        "        {0x0a,  1,      \"lconst_1\",             jvm_interp_lconst_1},\n" +
        "        {0x0b,  1,      \"fconst_0\",             jvm_interp_fconst_0},\n" +
        "        {0x0c,  1,      \"fconst_1\",             jvm_interp_fconst_1},\n" +
        "        {0x0d,  1,      \"fconst_2\",             jvm_interp_fconst_2},\n" +
        "        {0x0e,  1,      \"dconst_0\",             jvm_interp_dconst_0},\n" +
        "        {0x0f,  1,      \"dconst_1\",             jvm_interp_dconst_1},\n" +
        "        {0x10,  2,      \"bipush\",               jvm_interp_bipush},\n" +
        "        {0x11,  3,      \"sipush\",               jvm_interp_sipush},\n" +
        "        {0x12,  2,      \"ldc\",          \tjvm_interp_ldc},\n" +
        "        {0x13,  3,      \"ldc_w\",                jvm_interp_ldc_w},\n" +
        "        {0x14,  3,      \"ldc2_w\",               jvm_interp_ldc2_w},\n" +
        "        {0x15,  2,      \"iload\",                jvm_interp_iload},\n" +
        "        {0x16,  2,      \"lload\",                jvm_interp_lload},\n" +
        "        {0x17,  2,      \"fload\",                jvm_interp_fload},\n" +
        "        {0x18,  2,      \"dload\",                jvm_interp_dload},\n" +
        "        {0x19,  2,      \"aload\",                jvm_interp_aload},\n" +
        "        {0x1a,  1,      \"iload_0\",              jvm_interp_iload_0},\n" +
        "        {0x1b,  1,      \"iload_1\",              jvm_interp_iload_1},\n" +
        "        {0x1c,  1,      \"iload_2\",              jvm_interp_iload_2},\n" +
        "        {0x1d,  1,      \"iload_3\",              jvm_interp_iload_3},\n" +
        "        {0x1e,  1,      \"lload_0\",              jvm_interp_lload_0},\n" +
        "        {0x1f,  1,      \"lload_1\",              jvm_interp_lload_1},\n" +
        "        {0x20,  1,      \"lload_2\",              jvm_interp_lload_2},\n" +
        "        {0x21,  1,      \"lload_3\",              jvm_interp_lload_3},\n" +
        "        {0x22,  1,      \"fload_0\",              jvm_interp_fload_0},\n" +
        "        {0x23,  1,      \"fload_1\",              jvm_interp_fload_1},\n" +
        "        {0x24,  1,      \"fload_2\",              jvm_interp_fload_2},\n" +
        "        {0x25,  1,      \"fload_3\",              jvm_interp_fload_3},\n" +
        "        {0x26,  1,      \"dload_0\",              jvm_interp_dload_0},\n" +
        "        {0x27,  1,      \"dload_1\",              jvm_interp_dload_1},\n" +
        "        {0x28,  1,      \"dload_2\",              jvm_interp_dload_2},\n" +
        "        {0x29,  1,      \"dload_3\",              jvm_interp_dload_3},\n" +
        "        {0x2a,  1,      \"aload_0\",              jvm_interp_aload_0},\n" +
        "        {0x2b,  1,      \"aload_1\",              jvm_interp_aload_1},\n" +
        "        {0x2c,  1,      \"aload_2\",              jvm_interp_aload_2},\n" +
        "        {0x2d,  1,      \"aload_3\",              jvm_interp_aload_3},\n" +
        "        {0x2e,  1,      \"iaload\",               jvm_interp_iaload},\n" +
        "        {0x2f,  1,      \"laload\",               jvm_interp_laload},\n" +
        "        {0x30,  1,      \"faload\",               jvm_interp_faload},\n" +
        "        {0x31,  1,      \"daload\",               jvm_interp_daload},\n" +
        "        {0x32,  1,      \"aaload\",               jvm_interp_aaload},\n" +
        "        {0x33,  1,      \"baload\",               jvm_interp_baload},\n" +
        "        {0x34,  1,      \"caload\",               jvm_interp_caload},\n" +
        "        {0x35,  1,      \"saload\",               jvm_interp_saload},\n" +
        "        {0x36,  2,      \"istore\",               jvm_interp_istore},\n" +
        "        {0x37,  2,      \"lstore\",               jvm_interp_lstore},\n" +
        "        {0x38,  2,      \"fstore\",               jvm_interp_fstore},\n" +
        "        {0x39,  2,      \"dstore\",               jvm_interp_dstore},\n" +
        "        {0x3a,  2,      \"astore\",               jvm_interp_astore},\n" +
        "        {0x3b,  1,      \"istore_0\",             jvm_interp_istore_0},\n" +
        "        {0x3c,  1,      \"istore_1\",             jvm_interp_istore_1},\n" +
        "        {0x3d,  1,      \"istore_2\",             jvm_interp_istore_2},\n" +
        "        {0x3e,  1,      \"istore_3\",             jvm_interp_istore_3},\n" +
        "        {0x3f,  1,      \"lstore_0\",             jvm_interp_lstore_0},\n" +
        "        {0x40,  1,      \"lstore_1\",             jvm_interp_lstore_1},\n" +
        "        {0x41,  1,      \"lstore_2\",             jvm_interp_lstore_2},\n" +
        "        {0x42,  1,      \"lstore_3\",             jvm_interp_lstore_3},\n" +
        "        {0x43,  1,      \"fstore_0\",             jvm_interp_fstore_0},\n" +
        "        {0x44,  1,      \"fstore_1\",             jvm_interp_fstore_1},\n" +
        "        {0x45,  1,      \"fstore_2\",             jvm_interp_fstore_2},\n" +
        "        {0x46,  1,      \"fstore_3\",             jvm_interp_fstore_3},\n" +
        "        {0x47,  1,      \"dstore_0\",             jvm_interp_dstore_0},\n" +
        "        {0x48,  1,      \"dstore_1\",             jvm_interp_dstore_1},\n" +
        "        {0x49,  1,      \"dstore_2\",             jvm_interp_dstore_2},\n" +
        "        {0x4a,  1,      \"dstore_3\",             jvm_interp_dstore_3},\n" +
        "        {0x4b,  1,      \"astore_0\",             jvm_interp_astore_0},\n" +
        "        {0x4c,  1,      \"astore_1\",             jvm_interp_astore_1},\n" +
        "        {0x4d,  1,      \"astore_2\",             jvm_interp_astore_2},\n" +
        "        {0x4e,  1,      \"astore_3\",             jvm_interp_astore_3},\n" +
        "        {0x4f,  1,      \"iastore\",              jvm_interp_iastore},\n" +
        "        {0x50,  1,      \"lastore\",              jvm_interp_lastore},\n" +
        "        {0x51,  1,      \"fastore\",              jvm_interp_fastore},\n" +
        "        {0x52,  1,      \"dastore\",              jvm_interp_dastore},\n" +
        "        {0x53,  1,      \"aastore\",              jvm_interp_aastore},\n" +
        "        {0x54,  1,      \"bastore\",              jvm_interp_bastore},\n" +
        "        {0x55,  1,      \"castore\",              jvm_interp_castore},\n" +
        "        {0x56,  1,      \"sastore\",              jvm_interp_sastore},\n" +
        "        {0x57,  1,      \"pop\",          \tjvm_interp_pop},\n" +
        "        {0x58,  1,      \"pop2\",         \tjvm_interp_pop2},\n" +
        "        {0x59,  1,      \"dup\",          \tjvm_interp_dup},\n" +
        "        {0x5a,  1,      \"dup_x1\",               jvm_interp_dup_x1},\n" +
        "        {0x5b,  1,      \"dup_x2\",               jvm_interp_dup_x2},\n" +
        "        {0x5c,  1,      \"dup2\",         \tjvm_interp_dup2},\n" +
        "        {0x5d,  1,      \"dup2_x1\",              jvm_interp_dup2_x1},\n" +
        "        {0x5e,  1,      \"dup2_x2\",              jvm_interp_dup2_x2},\n" +
        "        {0x5f,  1,      \"swap\",         \tjvm_interp_swap},\n" +
        "        {0x60,  1,      \"iadd\",         \tjvm_interp_iadd},\n" +
        "        {0x61,  1,      \"ladd\",         \tjvm_interp_ladd},\n" +
        "        {0x62,  1,      \"fadd\",         \tjvm_interp_fadd},\n" +
        "        {0x63,  1,      \"dadd\",         \tjvm_interp_dadd},\n" +
        "        {0x64,  1,      \"isub\",         \tjvm_interp_isub},\n" +
        "        {0x65,  1,      \"lsub\",         \tjvm_interp_lsub},\n" +
        "        {0x66,  1,      \"fsub\",         \tjvm_interp_fsub},\n" +
        "        {0x67,  1,      \"dsub\",         \tjvm_interp_dsub},\n" +
        "        {0x68,  1,      \"imul\",         \tjvm_interp_imul},\n" +
        "        {0x69,  1,      \"lmul\",         \tjvm_interp_lmul},\n" +
        "        {0x6a,  1,      \"fmul\",         \tjvm_interp_fmul},\n" +
        "        {0x6b,  1,      \"dmul\",         \tjvm_interp_dmul},\n" +
        "        {0x6c,  1,      \"idiv\",         \tjvm_interp_idiv},\n" +
        "        {0x6d,  1,      \"ldiv\",         \tjvm_interp_ldiv},\n" +
        "        {0x6e,  1,      \"fdiv\",         \tjvm_interp_fdiv},\n" +
        "        {0x6f,  1,      \"ddiv\",         \tjvm_interp_ddiv},\n" +
        "        {0x70,  1,      \"irem\",         \tjvm_interp_irem},\n" +
        "        {0x71,  1,      \"lrem\",         \tjvm_interp_lrem},\n" +
        "        {0x72,  1,      \"frem\",         \tjvm_interp_frem},\n" +
        "        {0x73,  1,      \"drem\",         \tjvm_interp_drem},\n" +
        "        {0x74,  1,      \"ineg\",         \tjvm_interp_ineg},\n" +
        "        {0x75,  1,      \"lneg\",         \tjvm_interp_lneg},\n" +
        "        {0x76,  1,      \"fneg\",        \t \tjvm_interp_fneg},\n" +
        "        {0x77,  1,      \"dneg\",         \tjvm_interp_dneg},\n" +
        "        {0x78,  1,      \"ishl\",         \tjvm_interp_ishl},\n" +
        "        {0x79,  1,      \"lshl\",         \tjvm_interp_lshl},\n" +
        "        {0x7a,  1,      \"ishr\",         \tjvm_interp_ishr},\n" +
        "        {0x7b,  1,      \"lshr\",         \tjvm_interp_lshr},\n" +
        "        {0x7c,  1,      \"iushr\",                jvm_interp_iushr},\n" +
        "        {0x7d,  1,      \"lushr\",                jvm_interp_lushr},\n" +
        "        {0x7e,  1,      \"iand\",         \tjvm_interp_iand},\n" +
        "        {0x7f,  1,      \"land\",         \tjvm_interp_land},\n" +
        "        {0x80,  1,      \"ior\",          \tjvm_interp_ior},\n" +
        "        {0x81,  1,      \"lor\",          \tjvm_interp_lor},\n" +
        "        {0x82,  1,      \"ixor\",         \tjvm_interp_ixor},\n" +
        "        {0x83,  1,      \"lxor\",         \tjvm_interp_lxor},\n" +
        "        {0x84,  3,      \"iinc\",         \tjvm_interp_iinc},\n" +
        "        {0x85,  1,      \"i2l\",          \tjvm_interp_i2l},\n" +
        "        {0x86,  1,      \"i2f\",          \tjvm_interp_i2f},\n" +
        "        {0x87,  1,      \"i2d\",          \tjvm_interp_i2d},\n" +
        "        {0x88,  1,      \"l2i\",          \tjvm_interp_l2i},\n" +
        "        {0x89,  1,      \"l2f\",          \tjvm_interp_l2f},\n" +
        "        {0x8a,  1,      \"l2d\",          \tjvm_interp_l2d},\n" +
        "        {0x8b,  1,      \"f2i\",          \tjvm_interp_f2i},\n" +
        "        {0x8c,  1,      \"f2l\",          \tjvm_interp_f2l},\n" +
        "        {0x8d,  1,      \"f2d\",          \tjvm_interp_f2d},\n" +
        "        {0x8e,  1,      \"d2i\",          \tjvm_interp_d2i},\n" +
        "        {0x8f,  1,      \"d2l\",          \tjvm_interp_d2l},\n" +
        "        {0x90,  1,      \"d2f\",          \tjvm_interp_d2f},\n" +
        "        {0x91,  1,      \"i2b\",          \tjvm_interp_i2b},\n" +
        "        {0x92,  1,      \"i2c\",          \tjvm_interp_i2c},\n" +
        "        {0x93,  1,      \"i2s\",          \tjvm_interp_i2s},\n" +
        "        {0x94,  1,      \"lcmp\",         \tjvm_interp_lcmp},\n" +
        "        {0x95,  1,      \"fcmpl\",                jvm_interp_fcmpl},\n" +
        "        {0x96,  1,      \"fcmpg\",                jvm_interp_fcmpg},\n" +
        "        {0x97,  1,      \"dcmpl\",                jvm_interp_dcmpl},\n" +
        "        {0x98,  1,      \"dcmpg\",                jvm_interp_dcmpg},\n" +
        "        {0x99,  3,      \"ifeq\",         \tjvm_interp_ifeq},\n" +
        "        {0x9a,  3,      \"ifne\",         \tjvm_interp_ifne},\n" +
        "        {0x9b,  3,      \"iflt\",         \tjvm_interp_iflt},\n" +
        "        {0x9c,  3,      \"ifge\",         \tjvm_interp_ifge},\n" +
        "        {0x9d,  3,      \"ifgt\",         \tjvm_interp_ifgt},\n" +
        "        {0x9e,  3,      \"ifle\",         \tjvm_interp_ifle},\n" +
        "        {0x9f,  3,      \"if_icmpeq\",            jvm_interp_if_icmpeq},\n" +
        "        {0xa0,  3,      \"if_icmpne\",            jvm_interp_if_icmpne},\n" +
        "        {0xa1,  3,      \"if_icmplt\",            jvm_interp_if_icmplt},\n" +
        "        {0xa2,  3,      \"if_icmpge\",            jvm_interp_if_icmpge},\n" +
        "        {0xa3,  3,      \"if_icmpgt\",            jvm_interp_if_icmpgt},\n" +
        "        {0xa4,  3,      \"if_icmple\",            jvm_interp_if_icmple},\n" +
        "        {0xa5,  1,      \"if_acmpeq\",            jvm_interp_if_acmpeq},\n" +
        "        {0xa6,  1,      \"if_acmpne\",            jvm_interp_if_acmpne},\n" +
        "        {0xa7,  3,      \"goto\",         \tjvm_interp_goto},\n" +
        "        {0xa8,  1,      \"jsr\",          \tjvm_interp_jsr},\n" +
        "        {0xa9,  1,      \"ret\",          \tjvm_interp_ret},\n" +
        "        {0xaa,  1,      \"tableswitch\",          jvm_interp_tableswitch},\n" +
        "        {0xab,  1,      \"lookupswitch\",         jvm_interp_lookupswitch},\n" +
        "        {0xac,  1,      \"ireturn\",              jvm_interp_ireturn},\n" +
        "        {0xad,  1,      \"lreturn\",              jvm_interp_lreturn},\n" +
        "        {0xae,  1,      \"freturn\",              jvm_interp_freturn},\n" +
        "        {0xaf,  1,      \"dreturn\",              jvm_interp_dreturn},\n" +
        "        {0xb0,  1,      \"areturn\",              jvm_interp_areturn},\n" +
        "        {0xb1,  1,      \"return\",               jvm_interp_return},\n" +
        "        {0xb2,  3,      \"getstatic\",            jvm_interp_getstatic},\n" +
        "        {0xb3,  3,      \"putstatic\",            jvm_interp_putstatic},\n" +
        "        {0xb4,  3,      \"getfield\",             jvm_interp_getfiled},\n" +
        "        {0xb5,  3,      \"putfield\",             jvm_interp_putfiled},\n" +
        "        {0xb6,  3,      \"invokevirtual\",        jvm_interp_invokevirtual},\n" +
        "        {0xb7,  3,      \"invokespecial\",        jvm_interp_invokespecial},\n" +
        "        {0xb8,  3,      \"invokestatic\",         jvm_interp_invokestatic},\n" +
        "        {0xb9,  5,      \"invokeinterface\",      jvm_interp_invokeinterface},\n" +
        "        {0xba,  3,      \"invokedynamic\",        jvm_interp_invokedynamic},\n" +
        "        {0xbb,  3,      \"new\",          \tjvm_interp_new},\n" +
        "        {0xbc,  2,      \"newarray\",             jvm_interp_newarray},\n" +
        "        {0xbd,  3,      \"anewarray\",            jvm_interp_anewarray},\n" +
        "        {0xbe,  1,      \"arraylength\",          jvm_interp_arraylength},\n" +
        "        {0xbf,  1,      \"athrow\",               jvm_interp_athrow},\n" +
        "        {0xc0,  3,      \"checkcast\",            jvm_interp_checkcast},\n" +
        "        {0xc1,  1,      \"instanceof\",           jvm_interp_instanceof},\n" +
        "        {0xc2,  1,      \"monitorenter\",         jvm_interp_monitorenter},\n" +
        "        {0xc3,  1,      \"monitorexit\",          jvm_interp_monitorexit},\n" +
        "        {0xc4,  1,      \"wide\",         \tjvm_interp_wide},\n" +
        "        {0xc5,  1,      \"multianewarray\",       jvm_interp_multianewarray},\n" +
        "        {0xc6,  3,      \"ifnull\",               jvm_interp_ifnull},\n" +
        "        {0xc7,  3,      \"ifnonnull\",            jvm_interp_ifnonnull},\n" +
        "        {0xc8,  1,      \"goto_w\",               jvm_interp_goto_w},\n" +
        "        {0xc9,  1,      \"jsr_w\",               \tjvm_interp_jsr_w},"

def ret = str.split("\n")
def i = 0
for (final ele in ret) {
    ele = ele.stripIndent()
    ele = ele.replace('{', "")
    ele = ele.replace('}', "")
    String[] split= ele.split(",")
    def name = split[2].stripIndent()
    def len = split[1].stripIndent()
    def op = split[0].stripIndent()
    def template =  "new JvmByteCode(${name}, new OneByteImpl((byte) ${len}), new OneByteImpl((byte) ${op}), new InterpretorFunc() {}),"
    def codeDescriptions = "${len}, "

    print codeDescriptions
    i++;
    if (i % 10 == 0) {
        print "\n"
    }

}