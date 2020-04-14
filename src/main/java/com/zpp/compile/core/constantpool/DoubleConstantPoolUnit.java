package com.zpp.compile.core.constantpool;

import com.zpp.compile.core.ConstantPoolUnit;

/**
 * @author steven.zhu 2020/4/10 13:00.
 * @类描述：
 */
public class DoubleConstantPoolUnit extends ConstantPoolUnit<Double> implements SimpleConstantPoolUnit {

    private Double constantValue;

    public DoubleConstantPoolUnit(Integer tag, String constantPoolType, String description) {
        super(tag, constantPoolType, description);
    }

    @Override
    public Object constantValue() {
        return constantValue;
    }

    @Override
    public void fullValue(Double value) {
        constantValue = value;
    }
}
