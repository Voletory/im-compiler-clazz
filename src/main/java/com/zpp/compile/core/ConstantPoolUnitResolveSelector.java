package com.zpp.compile.core;

/**
 * @author steven.zhu 2020/4/9 12:22.
 * @类描述：
 */
public abstract class ConstantPoolUnitResolveSelector {

    public ConstantPoolUnitResolveSelector() {
        init();
    }

    public abstract void init();

    public ConstantPoolUnitResolve selector(Integer tag) {
        return doSelector(tag);
    }

    public abstract ConstantPoolUnitResolve doSelector(Integer tag);
}
