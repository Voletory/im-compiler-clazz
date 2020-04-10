package com.zpp.compile.core.constantpool;

import com.zpp.compile.core.ConstantPoolUnit;

/**
 * @author steven.zhu 2020/4/9 12:28.
 * @类描述：
 */
public class UTF8ConstantPoolUnit extends ConstantPoolUnit<String> {
    private String constantValue;

    public UTF8ConstantPoolUnit(Integer tag, String constantPoolType, String description) {
        super(tag, constantPoolType, description);
    }

    @Override
    public Object constantValue() {
        return this.constantValue;
    }

    @Override
    public void fullValue(String value) {
        constantValue = value;
    }

}
