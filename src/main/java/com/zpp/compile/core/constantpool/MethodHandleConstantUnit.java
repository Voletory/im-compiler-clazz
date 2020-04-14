package com.zpp.compile.core.constantpool;

import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.constantpool.bean.MethodHandleInfo;

/**
 * @author steven.zhu 2020/4/13 12:30.
 * @类描述：
 */
public class MethodHandleConstantUnit extends ConstantPoolUnit<MethodHandleInfo> {

    private MethodHandleInfo methodHandleInfo;

    public MethodHandleConstantUnit(Integer tag, String constantPoolType, String description) {
        super(tag, constantPoolType, description);
    }

    @Override
    public Object constantValue() {
        return methodHandleInfo;
    }

    @Override
    public void fullValue(MethodHandleInfo value) {
        methodHandleInfo = value;
    }
}
