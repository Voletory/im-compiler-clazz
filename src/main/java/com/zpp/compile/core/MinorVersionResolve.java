package com.zpp.compile.core;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.ClassStructHold;
import com.zpp.compile.common.ByteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.zpp.compile.core.ClassStructName.MINOR_VERSION;

/**
 * @author steven.zhu 2020/4/8 12:31.
 * @类描述： u2 长度 代表小版本号   jdk1.4之后就不使用 一搬为0
 */
public class MinorVersionResolve extends ClassStructHold {

    private Logger logger = LoggerFactory.getLogger(MinorVersionResolve.class);
    public MinorVersionResolve() {
        setName(MINOR_VERSION);
    }

    @Override
    protected void doDecode(ClassPathReader classPathReader) {
        byte[] bytes = classPathReader.allocByteResource(2);
        Integer minorVersion = ByteUtils.parseByteArrayToInteger(bytes);
        logger.info("MINOR_VERSION:" + minorVersion);
        fullResource(bytes);
    }

    @Override
    protected void propertyClassStruce(ClassStruct classStruct) {
        classStruct.minorVersion = this;
    }
}
