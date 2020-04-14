package com.zpp.compile.core.constantpool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author steven.zhu 2020/4/11 12:19.
 * @类描述：
 */
public class ConstantPoolMultiIndexUnit extends ConstantPoolMultiUnit<List<Integer>> {

    private List<Integer> indexs = new ArrayList<>();

    public ConstantPoolMultiIndexUnit(Integer tag, String constantPoolType, String description) {
        super(tag, constantPoolType, description);
    }

    @Override
    public Object constantValue() {
        return indexs;
    }

    @Override
    public void fullValue(List<Integer> indexList) {
        indexs.addAll(indexList);
    }

    public Object constantValue(Integer index) {
        return indexs;
    }
}
