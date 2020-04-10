package com.zpp.compile.core;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.ClassStructHold;
import com.zpp.compile.common.ByteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author steven.zhu 2020/4/8 13:02.
 * @类描述：
 */
public class MajorVersionResolve extends ClassStructHold {

    private Logger logger = LoggerFactory.getLogger(MajorVersionResolve.class);
    public MajorVersionResolve() {
        setName(ClassStructName.MAJOR_VERSION);
    }

    @Override
    protected void doDecode(ClassPathReader classPathReader) {
        byte[] bytes = classPathReader.allocByteResource(2);
        Integer minorVersion = ByteUtils.parseByteArrayToInteger(bytes);
        logger.info("MAJOR_VERSION:" + minorVersion);
        fullResource(bytes);
    }

    @Override
    protected void propertyClassStruce(ClassStruct classStruct) {
        classStruct.major_version = this;
    }
}
