package com.zpp.compile.core.constantpool;

import com.zpp.compile.core.ConstantPoolUnit;

/**
 * @author steven.zhu 2020/4/9 12:28.
 * @类描述：
 */
public class UTF8ConstantPoolUnit extends ConstantPoolUnit {
    private String constantValue;

    public UTF8ConstantPoolUnit(Integer tag, String constantPoolType, String description) {
        super(tag, constantPoolType, description);
    }

    public String getConstantValue() {
        return constantValue;
    }

    public void setConstantValue(String constantValue) {
        this.constantValue = constantValue;
    }
}
