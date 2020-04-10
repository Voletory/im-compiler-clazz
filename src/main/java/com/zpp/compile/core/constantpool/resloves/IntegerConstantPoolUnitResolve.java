package com.zpp.compile.core.constantpool.resloves;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.common.ByteUtils;
import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.ConstantPoolUnitResolve;
import com.zpp.compile.core.constantpool.IntegerConstantPoolUnit;

/**
 * @author steven.zhu 2020/4/9 19:21.
 * @类描述：
 */
public class IntegerConstantPoolUnitResolve implements ConstantPoolUnitResolve<Integer> {

    private ConstantPoolUnit constantPoolUnit = new IntegerConstantPoolUnit(3,"CONSTANT_INTEGER_INFO","整型字面量");

    @Override
    public ConstantPoolUnit getConstantUnit() {
        return constantPoolUnit;
    }

    @Override
    public Integer doDecode(ClassPathReader classPathReader) {
        byte[] bytes = classPathReader.allocByteResource(4);
        Integer constantValue = ByteUtils.parseByteArrayToInteger(bytes);
        logger.info("Integer constant:" + constantValue);
        return constantValue;
    }

}
