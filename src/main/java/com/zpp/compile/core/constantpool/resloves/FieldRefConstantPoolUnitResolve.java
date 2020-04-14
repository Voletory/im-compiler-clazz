package com.zpp.compile.core.constantpool.resloves;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.common.ByteUtils;
import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.ConstantPoolUnitResolve;
import com.zpp.compile.core.constantpool.ConstantPoolType;
import com.zpp.compile.core.constantpool.FieldRefConstantPoolUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author steven.zhu 2020/4/11 12:30.
 * @类描述：
 */
public class FieldRefConstantPoolUnitResolve implements ConstantPoolUnitResolve<List<Integer>> {

    private ConstantPoolUnit constantPoolUnit = new FieldRefConstantPoolUnit(ConstantPoolType.FIELD_REF_INFO, "CONSTANT_FIELD_REF_INFO", "字段的符号引用");

    @Override
    public ConstantPoolUnit getConstantUnit() {
        return constantPoolUnit;
    }

    @Override
    public List<Integer> doDecode(ClassPathReader classPathReader) {
        List<Integer> indexs = new ArrayList<>();
        byte[] class4Field = classPathReader.allocByteResource(2);
        indexs.add(ByteUtils.parseByteArrayToInteger(class4Field));
        byte[] name4Field = classPathReader.allocByteResource(2);
        indexs.add(ByteUtils.parseByteArrayToInteger(name4Field));
        logger.info("field ref index:" + indexs.get(0) + " and " + indexs.get(1));
        return indexs;
    }
}
