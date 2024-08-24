# MJvm
This is a mini jvm to undenstand java better and it can run sample java code. 

### 生成class数据结构
```java
public class JClassImpl implements JClass {
private final FourByte magicNumber;
private final TwoByte minorVersion;
private final TwoByte majorVersion;

private final TwoByte constantPoolCount;
private JconstantPool jconstantPool;

private final TwoByte accessFlag;

private final TwoByte thisClass;
private final TwoByte superClass;

private final TwoByte interfacesCount;
private JInterfaces interfaces;

private final TwoByte fieldsCount;
private JFields jfields;

private final TwoByte methodsCount;
private JMethods jmethods;

private final TwoByte attributesCount;
private JAttributes jattributes;
}

```

### 解析method指令
```java
===================execute method start. [method = <init>] =======================
line 0: aload_0
line 1: invokespecial 0  1
line 2: return
===================execute method end =======================
===================execute method start. [method = add] =======================
line 0: iload_1
line 1: iload_2
line 2: iadd
line 3: istore_3
line 4: iload_3
line 5: ireturn
===================execute method end =======================
===================execute method start. [method = inc] =======================
line 0: iload_1
line 1: iconst_1
line 2: iadd
line 3: istore_2
line 4: new 0  2
line 5: dup
line 6: invokespecial 0  1
line 7: astore_3
line 8: aload_3
line 9: invokevirtual 0  3
line 10: areturn
===================execute method end =======================
===================execute method start. [method = testJump] =======================
line 0: iload_0
line 1: iload_1
line 2: if_icmple 0  5
line 3: iconst_1
line 4: ireturn
line 5: iconst_0
line 6: ireturn
===================execute method end =======================
===================execute method start. [method = main] =======================
line 0: iconst_1
line 1: istore_0
line 2: iconst_2
line 3: istore_1
line 4: iload_0
line 5: iload_1
line 6: iadd
line 7: istore_2
line 8: new 0  4
line 9: dup
line 10: invokespecial 0  5
line 11: astore_3
line 12: return
===================execute method end =======================
end
```
...待续
### 创建运行时环境
### 解释执行jvm执行