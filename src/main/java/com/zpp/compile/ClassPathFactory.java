package com.zpp.compile;

import com.zpp.compile.ClassPathReader;

/**
 * @author steven.zhu 2020/4/1 12:38.
 * @类描述：
 */
public class ClassPathFactory {
    private ClassPathReader classPathReader;

    public ClassPathFactory(ClassPathReader classPathReader) {
        this.classPathReader = classPathReader;
        classPathReader.imCompile();
    }
}
