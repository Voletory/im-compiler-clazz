package com.zpp.compile.core;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.ClassStructHold;

/**
 * @author steven.zhu 2020/4/8 13:35.
 * @类描述：
 */
public class ConstantPoolResolve extends ClassStructHold {

    public ConstantPoolResolve() {
        setName(ClassStructName.MAJOR_VERSION);
    }

    @Override
    protected void doDecode(ClassPathReader classPathReader) {

    }

    @Override
    protected void propertyClassStruce(ClassStruct classStruct) {
        classStruct.constantPool = this;
    }
}
