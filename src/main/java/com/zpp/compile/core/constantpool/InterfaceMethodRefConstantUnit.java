package com.zpp.compile.core.constantpool;

import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.constantpool.bean.ConstantPoolMultiIndexUnit;

import java.util.List;

/**
 * @author steven.zhu 2020/4/11 13:01.
 * @类描述：
 */
public class InterfaceMethodRefConstantUnit extends ConstantPoolUnit<List<Integer>> {

    private ConstantPoolMultiIndexUnit constantPoolMultiIndexUnit = new ConstantPoolMultiIndexUnit(getTag(),getConstantPoolType(),getDescription());

    public InterfaceMethodRefConstantUnit(Integer tag, String constantPoolType, String description) {
        super(tag, constantPoolType, description);
    }

    @Override
    public Object constantValue() {
        return constantPoolMultiIndexUnit;
    }

    @Override
    public void fullValue(List<Integer> value) {
        constantPoolMultiIndexUnit.fullValue(value);
    }
}
