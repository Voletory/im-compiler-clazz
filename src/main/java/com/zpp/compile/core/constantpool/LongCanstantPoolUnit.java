package com.zpp.compile.core.constantpool;

import com.zpp.compile.core.ConstantPoolUnit;

/**
 * @author steven.zhu 2020/4/10 12:46.
 * @类描述：
 */
public class LongCanstantPoolUnit extends ConstantPoolUnit<Long> implements SimpleConstantPoolUnit {

    private Long constantValue;

    public LongCanstantPoolUnit(Integer tag, String constantPoolType, String description) {
        super(tag, constantPoolType, description);
    }

    @Override
    public Object constantValue() {
        return constantValue;
    }

    @Override
    public void fullValue(Long value) {
        constantValue = value;
    }
}
