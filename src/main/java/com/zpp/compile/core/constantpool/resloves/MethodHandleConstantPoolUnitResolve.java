package com.zpp.compile.core.constantpool.resloves;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.common.ByteUtils;
import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.ConstantPoolUnitResolve;
import com.zpp.compile.core.constantpool.ConstantPoolType;
import com.zpp.compile.core.constantpool.MethodHandleConstantUnit;
import com.zpp.compile.core.constantpool.MethodHandleInfo;

/**
 * @author steven.zhu 2020/4/13 12:56.
 * @类描述：
 */
public class MethodHandleConstantPoolUnitResolve implements ConstantPoolUnitResolve<MethodHandleInfo> {

    private ConstantPoolUnit constantPoolUnit = new MethodHandleConstantUnit(ConstantPoolType.METHOD_HANDLE_INFO, "CONSTANT_METHOD_HANDLE_INFO", "method句柄描述");

    @Override
    public ConstantPoolUnit getConstantUnit() {
        return constantPoolUnit;
    }

    @Override
    public MethodHandleInfo doDecode(ClassPathReader classPathReader) {
        byte[] methodHandleKindByte = classPathReader.allocByteResource(1);
        Integer methodKind = ByteUtils.parseByteArrayToInteger(methodHandleKindByte);
        byte[] methodHandleConstantIndexByte = classPathReader.allocByteResource(2);
        Integer methodHandleConstantIndex = ByteUtils.parseByteArrayToInteger(methodHandleConstantIndexByte);
        return new MethodHandleInfo(methodKind, methodHandleConstantIndex);
    }
}
