package com.zpp.compile.core;

import com.zpp.compile.core.constantpool.ConstantPoolType;
import com.zpp.compile.core.constantpool.resloves.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author steven.zhu 2020/4/9 17:53.
 * @类描述：
 */
public class DefaultConstantPoolUnitResolveSelector extends ConstantPoolUnitResolveSelector {

    private Map<Integer,ConstantPoolUnitResolve> constantPoolUnitResolveHolder = new HashMap<>();

    @Override
    public void init() {
        constantPoolUnitResolveHolder.put(ConstantPoolType.UTF_8_INFO,new UTF8ConstantPoolUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.INTEGER_INFO,new IntegerConstantPoolUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.FLOAT_INFO,new FloatConstantPoolUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.LONG_INFO,new LongConstantPoolUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.DOUBLE_INFO,new DoubleConstantPoolUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.CLASS_INFO,new ClassConstantPoolUnitResolve());
    }

    @Override
    public ConstantPoolUnitResolve doSelector(Integer tag) {
        return constantPoolUnitResolveHolder.get(tag);
    }
}
