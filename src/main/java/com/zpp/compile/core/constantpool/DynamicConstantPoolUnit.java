package com.zpp.compile.core.constantpool;

import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.constantpool.bean.DynamicConstantBean;

/**
 * @author steven.zhu 2020/4/14 12:19.
 * @类描述：
 */
public class DynamicConstantPoolUnit extends ConstantPoolUnit<DynamicConstantBean> {

    private DynamicConstantBean dynamicConstantBean;

    public DynamicConstantPoolUnit(Integer tag, String constantPoolType, String description) {
        super(tag, constantPoolType, description);
    }

    @Override
    public Object constantValue() {
        return dynamicConstantBean;
    }

    @Override
    public void fullValue(DynamicConstantBean value) {
        dynamicConstantBean = value;
    }
}
