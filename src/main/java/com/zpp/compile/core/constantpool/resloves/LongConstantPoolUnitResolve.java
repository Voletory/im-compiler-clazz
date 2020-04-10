package com.zpp.compile.core.constantpool.resloves;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.common.ByteUtils;
import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.ConstantPoolUnitResolve;
import com.zpp.compile.core.constantpool.LongCanstantPoolUnit;

/**
 * @author steven.zhu 2020/4/10 12:48.
 * @类描述：
 */
public class LongConstantPoolUnitResolve implements ConstantPoolUnitResolve<Long> {

    private ConstantPoolUnit constantPoolUnit = new LongCanstantPoolUnit(5,"CONSTANT_LONG_INFO","长整型字面量");

    @Override
    public ConstantPoolUnit getConstantUnit() {
        return constantPoolUnit;
    }

    @Override
    public Long doDecode(ClassPathReader classPathReader) {
        byte[] longByteArray = classPathReader.allocByteResource(8);
        Long longValue = ByteUtils.parseByteArrayToLong(longByteArray);
        return longValue;
    }
}
