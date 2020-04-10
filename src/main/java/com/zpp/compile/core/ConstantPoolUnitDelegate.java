package com.zpp.compile.core;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.common.Assert;
import com.zpp.compile.common.ByteUtils;

/**
 * @author steven.zhu 2020/4/9 12:21.
 * @类描述：
 */
public class ConstantPoolUnitDelegate {

    /**
     *  默认 常量池选择器 可修改
     */
    private ConstantPoolUnitResolveSelector constantPoolUnitResolveSelector = new DefaultConstantPoolUnitResolveSelector();


    public void setConstantPoolUnitResolveSelector(ConstantPoolUnitResolveSelector selector) {
        Assert.notNull(selector,"select not be null");
        constantPoolUnitResolveSelector = selector;
    }

    public ConstantPoolUnit resolve(ClassPathReader classPathReader,ConstantPoolResolve constantPoolResolve) {
        byte[] tagByte = classPathReader.allocByteResource(1);
        Integer tag = ByteUtils.parseByteArrayToInteger(tagByte);
        return constantPoolUnitResolveSelector.selector(tag).decode(classPathReader,constantPoolResolve);
    }
}
