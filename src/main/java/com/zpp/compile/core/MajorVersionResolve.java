package com.zpp.compile.core;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.ClassStructHold;
import com.zpp.compile.common.ByteUtils;

/**
 * @author steven.zhu 2020/4/8 13:02.
 * @类描述：
 */
public class MajorVersionResolve extends ClassStructHold {
    public MajorVersionResolve() {
        setName(ClassStructName.MAJOR_VERSION);
    }

    @Override
    protected void doDecode(ClassPathReader classPathReader) {
        byte[] bytes = classPathReader.allocByteResource(2);
        Integer minorVersion = ByteUtils.parseByteArrayToInteger(bytes);
        System.out.println("MAJOR_VERSION:" + minorVersion);
        fullResource(bytes);
    }

    @Override
    protected void propertyClassStruce(ClassStruct classStruct) {
        classStruct.major_version = this;
    }
}
