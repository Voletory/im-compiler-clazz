package com.zpp.compile.core;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.common.ByteUtils;

/**
 * @author steven.zhu 2020/4/9 12:21.
 * @类描述：
 */
public class ConstantPoolUnitDelegate {

    private ConstantPoolUnitResolveSelector constantPoolUnitResolveSelector;

    public ConstantPoolUnit resolve(ClassPathReader classPathReader) {
        byte[] tagByte = classPathReader.allocByteResource(1);
        Integer tag = ByteUtils.parseByteArrayToInteger(tagByte);
        return constantPoolUnitResolveSelector.selector(tag).decode(classPathReader);
    }
}
