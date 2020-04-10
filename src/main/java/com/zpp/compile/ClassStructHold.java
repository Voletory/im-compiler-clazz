package com.zpp.compile;

import com.zpp.compile.common.Assert;
import com.zpp.compile.core.ClassStruct;

/**
 * @author steven.zhu 2020/4/3 12:21.
 * @类描述：
 */
public abstract class ClassStructHold extends AbstractDecodeResolve {
    protected String name;
    protected byte[] resource;

    @Override
    public void decodeClazz(ClassPathReader classPathReader,ClassStruct classStruct) {
        Assert.notNull(classPathReader,"classResource is null,resource path may be error!");
        doDecode(classPathReader);
        propertyClassStruce(classStruct);
    }

    protected abstract void doDecode(ClassPathReader classPathReader);

    public void setName(String name) {
        this.name = name;
    }

    public void fullResource(byte[] bytes) {
        Assert.noNullElements(bytes,"bytes con't be null");
        this.resource = bytes;
    }

    protected abstract void propertyClassStruce(ClassStruct classStruct);

}
