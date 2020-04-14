package com.zpp.compile.core.constantpool.resloves;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.common.ByteUtils;
import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.ConstantPoolUnitResolve;
import com.zpp.compile.core.constantpool.ConstantPoolType;
import com.zpp.compile.core.constantpool.DynamicConstantBean;
import com.zpp.compile.core.constantpool.DynamicConstantPoolUnit;

/**
 * @author steven.zhu 2020/4/14 12:24.
 * @类描述：
 */
public class DynamicConstantPoolUnitResolve implements ConstantPoolUnitResolve<DynamicConstantBean> {

    private ConstantPoolUnit constantPoolUnit = new DynamicConstantPoolUnit(ConstantPoolType.DYNAMIC_INFO,"DYNAMIC_INFO","动态计算常量");

    @Override
    public ConstantPoolUnit getConstantUnit() {
        return constantPoolUnit;
    }

    @Override
    public DynamicConstantBean doDecode(ClassPathReader classPathReader) {
        DynamicConstantBean dynamicConstantBean =new DynamicConstantBean();
        byte[] bootstrapIndex = classPathReader.allocByteResource(2);
        byte[] nameAndTypeIndex = classPathReader.allocByteResource(2);
        Integer bootStrap = ByteUtils.parseByteArrayToInteger(bootstrapIndex);
        Integer nameAndType = ByteUtils.parseByteArrayToInteger(nameAndTypeIndex);
        dynamicConstantBean.setBoostrapIndex(bootStrap);
        dynamicConstantBean.setNameAndTypeIndex(nameAndType);
        logger.info("dynamic bootstrap index: " + bootStrap + " nameAndTypeIndex: " + nameAndType);
        return dynamicConstantBean;
    }
}
