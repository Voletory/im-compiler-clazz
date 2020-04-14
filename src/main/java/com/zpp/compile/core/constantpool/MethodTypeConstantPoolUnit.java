package com.zpp.compile.core.constantpool;

import com.zpp.compile.core.ConstantPoolUnit;

/**
 * @author steven.zhu 2020/4/14 12:10.
 * @类描述：
 */
public class MethodTypeConstantPoolUnit extends ConstantPoolUnit<Integer> {

    /**
     * 必须是 CONSTANT_UTF8_INFO结构的常量池引用
     */
    private Integer index;

    public MethodTypeConstantPoolUnit(Integer tag, String constantPoolType, String description) {
        super(tag, constantPoolType, description);
    }

    @Override
    public Object constantValue() {
        return index;
    }

    @Override
    public void fullValue(Integer value) {
        index = value;
    }
}
