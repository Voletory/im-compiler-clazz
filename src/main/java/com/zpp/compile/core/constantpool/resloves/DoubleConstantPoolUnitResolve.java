package com.zpp.compile.core.constantpool.resloves;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.common.ByteUtils;
import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.ConstantPoolUnitResolve;
import com.zpp.compile.core.constantpool.ConstantPoolType;
import com.zpp.compile.core.constantpool.DoubleConstantPoolUnit;

/**
 * @author steven.zhu 2020/4/10 12:59.
 * @类描述：
 */
public class DoubleConstantPoolUnitResolve implements ConstantPoolUnitResolve<Double> {

    private DoubleConstantPoolUnit constantPoolUnit = new DoubleConstantPoolUnit(ConstantPoolType.DOUBLE_INFO,"CONSTANT_DOUBLE_INFO","双精度浮点型字面量");
    @Override
    public ConstantPoolUnit getConstantUnit() {
        return constantPoolUnit;
    }

    @Override
    public Double doDecode(ClassPathReader classPathReader) {
        byte[] doubleByteArray = classPathReader.allocByteResource(8);
        Double constantValue = ByteUtils.parseByteArrayToDouble(doubleByteArray);
        System.out.println("Double constant:" + constantValue);
        return constantValue;
    }
}
