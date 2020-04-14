package com.zpp.compile.core.constantpool;

import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.constantpool.bean.ConstantPoolMultiIndexUnit;

import java.util.List;

/**
 * @author steven.zhu 2020/4/11 13:14.
 * @类描述：
 */
public class NameAndTypeConstantUnit extends ConstantPoolUnit<List<Integer>> {

    private ConstantPoolMultiIndexUnit constantPoolMultiIndexUnit = new ConstantPoolMultiIndexUnit(getTag(),getConstantPoolType(),getDescription());

    public NameAndTypeConstantUnit(Integer tag, String constantPoolType, String description) {
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
