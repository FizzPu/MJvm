package org.mx.common.impl;

import org.mx.common.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FizzPu
 * @since 2024/1/7 00:06
 */
public class JMethodImpl implements JMethod {
    private JconstantPool constantPool;
    private final TwoByte accessFlags = new TwoByteImpl();
    private final TwoByte nameIndex = new TwoByteImpl();
    private final TwoByte descriptorIndex = new TwoByteImpl();

    public void setConstantPool(JconstantPool constantPool) {
        this.constantPool = constantPool;
    }

    private JAttributes jAttributes;

    private CodeAttribute codeAttribute;

    @Override
    public String getMethodName() {
        return new String(((ConstantUtf8Info) (constantPool.at(nameIndex).getInfo())).getChars());
    }

    @Override
    public void read(InputStream inputStream) throws IOException {
        accessFlags.read(inputStream);
        nameIndex.read(inputStream);
        descriptorIndex.read(inputStream);

        TwoByte twoByte = new TwoByteImpl();
        twoByte.read(inputStream);

        jAttributes = new JAttributesImpl(twoByte);
        jAttributes.read(inputStream);

        parseCodeAttribute();
    }

    private void parseCodeAttribute() {
        for (JAttribute jAttribute : jAttributes) {
            if (jAttribute instanceof JAttributeImpl) {
                ((JAttributeImpl) jAttribute).setConstantPool(constantPool);
            }
            if (jAttribute.isCodeAttribute()) {
                codeAttribute = new CodeAttributeImpl(
                        jAttribute.getAttributeLength(), jAttribute.getAttributeNameIndex(), jAttribute.getData()
                );
                break;
            }
        }
    }

    @Override
    public CodeAttribute getCodeAttribute() {
        return codeAttribute;
    }
}
