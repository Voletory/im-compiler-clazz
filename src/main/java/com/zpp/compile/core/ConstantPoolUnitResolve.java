package com.zpp.compile.core;

import com.zpp.compile.ClassPathReader;

/**
 * @author steven.zhu 2020/4/9 12:23.
 * @类描述：
 */
public interface ConstantPoolUnitResolve<T> {

    ConstantPoolUnit getConstantUnit();

    default ConstantPoolUnit decode(ClassPathReader classPathReader,ConstantPoolResolve constantPoolResolve) {
        T constantValue = doDecode(classPathReader);
        ConstantPoolUnit constantUnit = getConstantUnit();
        constantUnit.setConstantPoolResolve(constantPoolResolve);
        constantUnit.fullValue(constantValue);
        return constantUnit;
    }

    T doDecode(ClassPathReader classPathReader);
}
