package com.zpp.compile.core.constantpool.resloves;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.common.ByteUtils;
import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.ConstantPoolUnitResolve;
import com.zpp.compile.core.constantpool.ConstantPoolType;
import com.zpp.compile.core.constantpool.MethodRefConstantUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author steven.zhu 2020/4/11 12:41.
 * @类描述：
 */
public class MethodRefConstantPoolUnitResolve implements ConstantPoolUnitResolve<List<Integer>> {

    private ConstantPoolUnit constantPoolUnit = new MethodRefConstantUnit(ConstantPoolType.METHOD_REF_INFO,"CONSTANT_METHOD_REF_INFO","类中方法的符号索引");
    @Override
    public ConstantPoolUnit getConstantUnit() {
        return constantPoolUnit;
    }

    @Override
    public List<Integer> doDecode(ClassPathReader classPathReader) {
        List<Integer> indexs = new ArrayList<>();
        byte[] classOfMethod = classPathReader.allocByteResource(2);
        indexs.add(ByteUtils.parseByteArrayToInteger(classOfMethod));
        byte[] nameOfMethod = classPathReader.allocByteResource(2);
        indexs.add(ByteUtils.parseByteArrayToInteger(nameOfMethod));
        logger.info("method ref index:" + indexs.get(0) + " and " + indexs.get(1));
        return indexs;
    }
}
