package com.zpp.compile.core.constantpool;

import com.zpp.compile.core.ConstantPoolUnit;

import java.util.List;

/**
 * @author steven.zhu 2020/4/11 12:14.
 * @类描述：
 */
public class FieldRefConstantPoolUnit extends ConstantPoolUnit<List<Integer>> {

    private ConstantPoolMultiUnit constantPoolMultiUnit = new ConstantPoolMultiIndexUnit(ConstantPoolType.FIELD_REF_INFO,"CONSTANT_FIELDREF_INFO","filedRef的值");

    public FieldRefConstantPoolUnit(Integer tag, String constantPoolType, String description) {
        super(tag, constantPoolType, description);
    }

    @Override
    public Object constantValue() {
        return constantPoolMultiUnit;
    }

    @Override
    public void fullValue(List<Integer> value) {
        constantPoolMultiUnit.fullValue(value);
    }
}
