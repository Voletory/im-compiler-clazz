package com.zpp.compile.core.constantpool;

import com.zpp.compile.core.ConstantPoolUnit;

/**
 * @author steven.zhu 2020/4/11 12:18.
 * @类描述：
 */
public abstract class ConstantPoolMultiUnit<T> extends ConstantPoolUnit<T> {

    public ConstantPoolMultiUnit(Integer tag, String constantPoolType, String description) {
        super(tag, constantPoolType, description);
    }
}
