package com.zpp.compile.core.constantpool.resloves;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.common.ByteUtils;
import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.ConstantPoolUnitResolve;
import com.zpp.compile.core.constantpool.ConstantPoolType;
import com.zpp.compile.core.constantpool.NameAndTypeConstantUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author steven.zhu 2020/4/11 13:16.
 * @类描述：
 */
public class NameAndTypeConstantUnitResolve implements ConstantPoolUnitResolve<List<Integer>> {

    private ConstantPoolUnit constantPoolUnit = new NameAndTypeConstantUnit(ConstantPoolType.NAME_AND_TYPE_INFO,"CONSTANT_NAMEANDTYPE_info","字段或方法的部分描述");

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
        logger.info("name and type index:" + indexs.get(0) + " and " + indexs.get(1));
        return indexs;
    }
}
