package com.zpp.compile;

import com.zpp.compile.core.ClassStruct;

/**
 * @author steven.zhu 2020/4/1 20:09.
 * @类描述： 解析接口
 */
public interface DecodeResolve {

    void decodeClazz(ClassPathReader classPathReader,ClassStruct classStruct);
}
