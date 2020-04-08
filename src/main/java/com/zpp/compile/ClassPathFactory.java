package com.zpp.compile;

import com.zpp.compile.ClassPathReader;

import java.io.IOException;

/**
 * @author steven.zhu 2020/4/1 12:38.
 * @类描述：
 */
public class ClassPathFactory {
    private ClassPathReader classPathReader;

    public ClassPathFactory(ClassPathReader classPathReader) throws IOException {
        this.classPathReader = classPathReader;
        classPathReader.imCompile();
    }
}
