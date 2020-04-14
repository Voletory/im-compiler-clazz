package com.zpp.compile.core.constantpool;

import com.zpp.compile.core.ConstantPoolUnit;

/**
 * @author steven.zhu 2020/4/10 18:11.
 * @类描述：
 */
public class StringConstantPoolUnit extends ConstantPoolUnit<Integer> {

    private Integer index;

    public StringConstantPoolUnit(Integer tag, String constantPoolType, String description) {
        super(tag, constantPoolType, description);
    }

    @Override
    public Object constantValue() {
        return getConstantPoolResolve().getConstant(index).constantValue();
    }

    @Override
    public void fullValue(Integer value) {
        index = value;
    }
}
