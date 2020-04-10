package com.zpp.compile.core.constantpool.resloves;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.common.ByteUtils;
import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.ConstantPoolUnitResolve;
import com.zpp.compile.core.constantpool.ClassConstantPoolUnit;
import com.zpp.compile.core.constantpool.ConstantPoolType;

/**
 * @author steven.zhu 2020/4/10 13:23.
 * @类描述：
 */
public class ClassConstantPoolUnitResolve implements ConstantPoolUnitResolve<Integer> {

    private ConstantPoolUnit constantPoolUnit = new ClassConstantPoolUnit(ConstantPoolType.CLASS_INFO,"CONSTANT_CLASS_INFO","class索引");

    @Override
    public ConstantPoolUnit getConstantUnit() {
        return constantPoolUnit;
    }

    @Override
    public Integer doDecode(ClassPathReader classPathReader) {
        byte[] bytes = classPathReader.allocByteResource(2);
        Integer index = ByteUtils.parseByteArrayToInteger(bytes);
        return index;
    }
}
