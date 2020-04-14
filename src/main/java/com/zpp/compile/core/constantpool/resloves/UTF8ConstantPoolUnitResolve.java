package com.zpp.compile.core.constantpool.resloves;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.common.ByteUtils;
import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.ConstantPoolUnitResolve;
import com.zpp.compile.core.constantpool.UTF8ConstantPoolUnit;

import java.nio.charset.Charset;

/**
 * @author steven.zhu 2020/4/9 12:34.
 * @类描述：
 */
public class UTF8ConstantPoolUnitResolve implements ConstantPoolUnitResolve<String> {

    private ConstantPoolUnit utf8ConstantPoolUnit = new UTF8ConstantPoolUnit(1, "CONSTANT_Utf8_info", "UTF-8编码的字符串");

    @Override
    public ConstantPoolUnit getConstantUnit() {
        return utf8ConstantPoolUnit;
    }

    @Override
    public String  doDecode(ClassPathReader classPathReader) {
        byte[] constantValueLengthByte = classPathReader.allocByteResource(2);
        Integer constantValueLength = ByteUtils.parseByteArrayToInteger(constantValueLengthByte);
        byte[] constantValueByte = classPathReader.allocByteResource(constantValueLength);
        String constantPoolValue = resolveConstantPoolValue(constantValueByte);
        logger.info("UTF8 constantValue:  " + constantPoolValue);
        return constantPoolValue;
    }

    /**
     * 解析字符串 utf-8
     * 如果 1-127的ascii码，使用一个字节表示
     * 如果 从 \u0080 - \u07ff 使用两个字节表示
     * 如果 从 \u0800 - \uffff 使用三个字节表示
     *
     * @param constantByte
     * @return
     */
    public String resolveConstantPoolValue(byte[] constantByte) {
        String resolveConstantValue = new String(constantByte,Charset.forName("UTF-8"));
        return resolveConstantValue;
    }

}
