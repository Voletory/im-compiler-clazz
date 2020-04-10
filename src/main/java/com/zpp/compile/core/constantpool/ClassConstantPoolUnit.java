package com.zpp.compile.core.constantpool;

import com.zpp.compile.core.ConstantPoolUnit;

/**
 * @author steven.zhu 2020/4/10 13:06.
 * @类描述：
 */
public class ClassConstantPoolUnit extends ConstantPoolUnit<Integer> {

    private Integer index;

    public ClassConstantPoolUnit(Integer tag, String constantPoolType, String description) {
        super(tag, constantPoolType, description);
    }

    @Override
    public Object constantValue() {
        return getConstantPoolResolve().getConstantValue(index);
    }

    @Override
    public void fullValue(Integer value) {
        index = value;
    }
}
