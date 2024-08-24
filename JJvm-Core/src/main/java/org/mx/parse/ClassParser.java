package org.mx.parse;

import org.mx.common.JClass;

import java.util.List;

/**
 * @author FizzPu
 * @since 2024/1/3 19:49
 */
public interface ClassParser {
    JClass loadClass(String className, String classPath);

    String getClassLocation(String className, String classPath);
}
