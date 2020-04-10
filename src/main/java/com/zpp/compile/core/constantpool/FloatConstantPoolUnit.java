package com.zpp.compile.core.constantpool;

import com.zpp.compile.core.ConstantPoolUnit;

/**
 * @author steven.zhu 2020/4/9 19:39.
 * @类描述：
 */
public class FloatConstantPoolUnit extends ConstantPoolUnit<Float> {
    private Float constantValue;

    public FloatConstantPoolUnit(Integer tag, String constantPoolType, String description) {
        super(tag, constantPoolType, description);
    }

    @Override
    public Object constantValue() {
        return constantValue;
    }

    @Override
    public void fullValue(Float value) {
        constantValue = value;
    }
}
