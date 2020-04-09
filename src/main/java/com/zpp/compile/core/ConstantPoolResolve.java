package com.zpp.compile.core;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.ClassStructHold;
import com.zpp.compile.common.ByteUtils;

/**
 * @author steven.zhu 2020/4/8 13:35.
 * @类描述：
 */
public class ConstantPoolResolve extends ClassStructHold {

    /**
     * 常量池的计数值是从1而不是0开始的，设计者将第0项常量空出来是有特殊考虑的，
     * 这样做的目在于，如果后面某些指向常量池的索引值的数据在特定情况下需要表达
     * "不引用任何一个常量池项目"的含义，可以把索引值设置为0来表示
     */
    private Integer constantPoolCount;

    private ConstantPoolUnit[] constantPoolSet;

    public ConstantPoolResolve() {
        setName(ClassStructName.MAJOR_VERSION);
    }

    @Override
    protected void doDecode(ClassPathReader classPathReader) {
        // 查询常量数量
        byte[] bytes = classPathReader.allocByteResource(2);
        Integer constantPoolCount = ByteUtils.parseByteArrayToInteger(bytes);
        this.constantPoolCount = constantPoolCount;
        // 数量为count - 1
        constantPoolSet = new ConstantPoolUnit[constantPoolCount - 1];
        for (int i = 0; i < constantPoolCount - 1; i++) {
            constantPoolSet[i] = createConstantPool(classPathReader);
        }
    }

    private ConstantPoolUnit createConstantPool(ClassPathReader classPathReader) {
        return new ConstantPoolUnitDelegate().resolve(classPathReader);
    }

    @Override
    protected void propertyClassStruce(ClassStruct classStruct) {
        classStruct.constantPool = this;
    }
}
