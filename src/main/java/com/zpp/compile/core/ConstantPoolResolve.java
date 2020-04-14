package com.zpp.compile.core;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.ClassStructHold;
import com.zpp.compile.common.ByteUtils;
import com.zpp.compile.core.constantpool.ConstantPoolMultiIndexUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author steven.zhu 2020/4/8 13:35.
 * @类描述：
 */
public class ConstantPoolResolve extends ClassStructHold {

    private Logger logger = LoggerFactory.getLogger(ConstantPoolResolve.class);
    /**
     * 常量池的计数值是从1而不是0开始的，设计者将第0项常量空出来是有特殊考虑的，
     * 这样做的目在于，如果后面某些指向常量池的索引值的数据在特定情况下需要表达
     * "不引用任何一个常量池项目"的含义，可以把索引值设置为0来表示
     */
    private Integer constantPoolCount;

    private ConstantPoolUnit[] constantPoolSet;

    private ConstantPoolUnitDelegate constantPoolUnitDelegate;

    public ConstantPoolResolve() {
        setName(ClassStructName.CONSTANT_POOL);
    }

    @Override
    protected void doDecode(ClassPathReader classPathReader) {
        // 查询常量数量
        byte[] bytes = classPathReader.allocByteResource(2);
        Integer constantPoolCount = ByteUtils.parseByteArrayToInteger(bytes);
        this.constantPoolCount = constantPoolCount;
        // 数量为count - 1
        constantPoolSet = new ConstantPoolUnit[constantPoolCount - 1];
        logger.info("constant pool total:" + (constantPoolCount - 1));
        for (int i = 0; i < constantPoolCount - 1; i++) {
            // 特殊包含多个constant_index的需要特殊处理
            constantPoolSet[i] = createConstantPool(classPathReader, this);
        }
        // prepareConstantPoolValue
//        logger.debug("----------------------constant value set ---------------------------");
//        for (int i = 0; i < constantPoolCount - 1; i++) {
//            ConstantPoolUnit constantPoolUnit = constantPoolSet[i];
//            Object o = constantPoolUnit.constantValue();
//            String message = "";
//            if (o instanceof Integer) {
//                message += "#" + o + "   //";
//            }
//            message += decodeConstantValue(o);
//            logger.debug("constant #{} = {}            " + message, i + 1, constantPoolUnit.getConstantPoolType());
//        }
    }

    private String decodeConstantValue(Object value) {
        if (value instanceof Integer) {
            ConstantPoolUnit constant = getConstant((Integer) value);
            return decodeConstantValue(constant.constantValue());
        } else if (value instanceof String) {
            return (String) value;
        } else if (value instanceof ConstantPoolMultiIndexUnit) {
            Object listObject = ((ConstantPoolMultiIndexUnit) value).constantValue();
            List<Integer> indexs = (List<Integer>) listObject;
            String indexValue = "";
            String valueString = "";
            for (Integer index : indexs) {
                indexValue += "#" + index + ":";
                valueString += decodeConstantValue(index) + ":";
            }
            return indexValue + valueString;
        } else {
            return "ssss";
        }
    }

    private ConstantPoolUnit createConstantPool(ClassPathReader classPathReader, ConstantPoolResolve constantPoolResolve) {
        return loadConstantDelegate().resolve(classPathReader, constantPoolResolve);
    }

    private ConstantPoolUnitDelegate loadConstantDelegate() {
        if (constantPoolUnitDelegate == null) {
            synchronized (this) {
                if (this.constantPoolUnitDelegate == null) {
                    constantPoolUnitDelegate = new ConstantPoolUnitDelegate();
                }
            }
        }
        return constantPoolUnitDelegate;
    }

    public Object getConstantValue(Integer index) {
        return getConstant(index).constantValue();
    }

    public ConstantPoolUnit getConstant(Integer index) {
        return constantPoolSet[index - 1];
    }

    @Override
    protected void propertyClassStruce(ClassStruct classStruct) {
        classStruct.constantPool = this;
    }
}
