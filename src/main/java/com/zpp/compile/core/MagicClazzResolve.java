package com.zpp.compile.core;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.ClassStructHold;
import com.zpp.compile.common.Assert;

import java.io.IOException;

/**
 * @author steven.zhu 2020/4/3 12:26.
 * @类描述：u4 长度  默认为cafebabe
 */
public class MagicClazzResolve extends ClassStructHold {

    private static final int MAGIC_VALUE = 0xCAFEBABE;

    public MagicClazzResolve() {
        setName(ClassStructName.MAGIC);
    }

    /**
     * first magic number
     *
     * @param classPathReader
     */
    @Override
    protected void doDecode(ClassPathReader classPathReader) {
        // magic 4个字符长度
        byte[] nextResource = classPathReader.allocByteResource(4);
        Assert.isTrue(nextResource[0] == (byte) (MAGIC_VALUE >>> 24)
                && nextResource[1] == (byte) (MAGIC_VALUE >>> 16)
                && nextResource[2] == (byte) (MAGIC_VALUE >>> 8)
                && nextResource[3] == (byte) (MAGIC_VALUE), "文件解析失败");
        fullResource(nextResource);
    }

    @Override
    protected void propertyClassStruce(ClassStruct classStruct) {
        if (classStruct != null) classStruct.magic = this;
    }
}
