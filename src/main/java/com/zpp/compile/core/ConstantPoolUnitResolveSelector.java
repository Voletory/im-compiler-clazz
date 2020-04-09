package com.zpp.compile.core;

import java.util.HashMap;
import java.util.Map;

/**
 * @author steven.zhu 2020/4/9 12:22.
 * @类描述：
 */
public class ConstantPoolUnitResolveSelector {

    private Map<Integer, ConstantPoolUnitResolve> ConstantPoolResolveHold = new HashMap<>();

    public ConstantPoolUnitResolve selector(Integer tag) {
        return ConstantPoolResolveHold.get(tag);
    }
}
