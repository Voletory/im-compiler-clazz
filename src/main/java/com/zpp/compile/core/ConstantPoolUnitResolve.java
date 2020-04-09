package com.zpp.compile.core;

import com.zpp.compile.ClassPathReader;

/**
 * @author steven.zhu 2020/4/9 12:23.
 * @类描述：
 */
public interface ConstantPoolUnitResolve {
    ConstantPoolUnit decode(ClassPathReader classPathReader);
}
