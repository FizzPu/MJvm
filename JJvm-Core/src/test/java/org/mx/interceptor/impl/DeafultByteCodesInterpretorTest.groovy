package org.mx.interceptor.impl

import org.mx.common.JClass
import org.mx.common.JMethod
import org.mx.parse.impl.DefaultClassParser
import spock.lang.Specification

/**
 *
 * @author FizzPu
 * @since 2024/1/18 18:01
 */
class DeafultByteCodesInterpretorTest extends Specification {
    def "Interpret"() {
        given: "load class"
        def parser = new DefaultClassParser()
        JClass jClass = parser.loadClass(
                "ParseClass.class",
                "/Users/fizz/WorkSpace/Codes/CompanyCodes/sensorsdata/JvmBroaden/JJvm-Core/src/test/resources"
        )

        when: "intercept method"
        def interceptor = new DeafultByteCodesInterpretor();
        for (JMethod method : jClass.getJmethods()) {
            println (String.format("===================execute method start. [method = %s] =======================", method.getMethodName()))
            interceptor.interpret(method)
            println "===================execute method end ======================="
        }

        then: "end"
        println "end"
    }
}
