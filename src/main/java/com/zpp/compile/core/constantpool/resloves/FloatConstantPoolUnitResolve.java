package com.zpp.compile.core.constantpool.resloves;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.common.ByteUtils;
import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.ConstantPoolUnitResolve;
import com.zpp.compile.core.constantpool.FloatConstantPoolUnit;

/**
 * @author steven.zhu 2020/4/9 19:41.
 * @类描述：
 */
public class FloatConstantPoolUnitResolve implements ConstantPoolUnitResolve<Float> {

    private ConstantPoolUnit FloatConstantPoolUnit = new FloatConstantPoolUnit(4, "CONSTANT_FLOAT_INFO", "浮点型字面量，高位在前");

    @Override
    public ConstantPoolUnit getConstantUnit() {
        return FloatConstantPoolUnit;
    }

    @Override
    public Float doDecode(ClassPathReader classPathReader) {
        byte[] floatValue = classPathReader.allocByteResource(4);
        Float constantFloat = ByteUtils.parseByteArrayToFloat(floatValue);
        System.out.println("Float constant:" + constantFloat);
        return constantFloat;
    }

}
