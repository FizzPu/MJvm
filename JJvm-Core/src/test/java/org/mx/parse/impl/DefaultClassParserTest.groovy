package org.mx.parse.impl

import org.mx.common.JClass
import org.mx.common.impl.FourByteImpl
import org.mx.common.impl.TwoByteImpl
import spock.lang.Specification

/**
 *
 * @author FizzPu
 * @since 2024/1/4 14:00
 */
class DefaultClassParserTest extends Specification {
  def parser = new DefaultClassParser()

  def "LoadClass"() {
    given:

    when:
    JClass jClass = parser.loadClass(
      "ParseClass.class",
      "/Users/fizz/WorkSpace/Codes/CompanyCodes/sensorsdata/JvmBroaden/JJvm-Core/src/test/resources"
    )

    then:
    jClass.getMaicNumber() == new FourByteImpl(new byte[]{0xca, 0xfe, 0xba, 0xbe})
    jClass.getMinorVersion() == new TwoByteImpl(new byte[]{0x00, 0x00})
    jClass.getMajorVersion() == new TwoByteImpl(new byte[]{0x00, 0x34})
    jClass.getConstantPoolCount() == new TwoByteImpl(new byte[]{0x00, 0x1b})

  }

  def "GetClassLocation"() {
  }
}
