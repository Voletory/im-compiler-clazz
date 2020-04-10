package com.zpp.compile.core.constantpool.resloves;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.common.ByteUtils;
import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.ConstantPoolUnitResolve;
import com.zpp.compile.core.constantpool.ConstantPoolType;
import com.zpp.compile.core.constantpool.StringConstantPoolUnit;

/**
 * @author steven.zhu 2020/4/10 18:13.
 * @类描述：
 */
public class StringConstantPoolUnitResolve implements ConstantPoolUnitResolve<Integer> {

    private ConstantPoolUnit constantPoolUnit = new StringConstantPoolUnit(ConstantPoolType.STRING_INFO,"CONSTANT_STRING_INFO","字符串字面量索引");
    @Override
    public ConstantPoolUnit getConstantUnit() {
        return constantPoolUnit;
    }

    @Override
    public Integer doDecode(ClassPathReader classPathReader) {
        byte[] bytes = classPathReader.allocByteResource(2);
        Integer index = ByteUtils.parseByteArrayToInteger(bytes);
        logger.info("String index:" + index);
        return index;
    }
}
