package com.zpp.compile.core;

import java.util.HashMap;
import java.util.Map;

/**
 * @author steven.zhu 2020/4/9 12:22.
 * @类描述：
 */
public abstract class ConstantPoolUnitResolveSelector {

    public abstract void init();

    public ConstantPoolUnitResolve selector(Integer tag) {
        return doSelector(tag);
    }

    public abstract ConstantPoolUnitResolve doSelector(Integer tag);
}
