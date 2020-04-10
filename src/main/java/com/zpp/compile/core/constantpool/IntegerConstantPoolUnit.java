package com.zpp.compile.core.constantpool;

import com.zpp.compile.core.ConstantPoolUnit;

/**
 * @author steven.zhu 2020/4/9 18:59.
 * @类描述：
 */
public class IntegerConstantPoolUnit extends ConstantPoolUnit<Integer> {

    private Integer constantValue;


    public IntegerConstantPoolUnit(Integer tag, String constantPoolType, String description) {
        super(tag, constantPoolType, description);
    }

    @Override
    public Object constantValue() {
        return constantValue;
    }

    @Override
    public void fullValue(Integer value) {
        constantValue = value;
    }


}
