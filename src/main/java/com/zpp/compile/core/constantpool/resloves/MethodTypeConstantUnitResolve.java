package com.zpp.compile.core.constantpool.resloves;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.common.ByteUtils;
import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.ConstantPoolUnitResolve;
import com.zpp.compile.core.constantpool.ConstantPoolType;
import com.zpp.compile.core.constantpool.MethodHandleConstantUnit;

/**
 * @author steven.zhu 2020/4/14 12:16.
 * @类描述：
 */
public class MethodTypeConstantUnitResolve implements ConstantPoolUnitResolve<Integer> {

    private ConstantPoolUnit constantPoolUnit = new MethodHandleConstantUnit(ConstantPoolType.METHOD_TYPE_INFO,"CONSTANT_METHOD_TYPE_INFO","方法的类型");

    @Override
    public ConstantPoolUnit getConstantUnit() {
        return constantPoolUnit;
    }

    @Override
    public Integer doDecode(ClassPathReader classPathReader) {
        byte[] indexByteArray = classPathReader.allocByteResource(2);
        Integer index = ByteUtils.parseByteArrayToInteger(indexByteArray);
        logger.info("method type index: {}",index);
        return index;
    }
}
