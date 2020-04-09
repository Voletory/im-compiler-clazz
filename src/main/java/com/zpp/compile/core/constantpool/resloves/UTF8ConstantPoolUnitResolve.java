package com.zpp.compile.core.constantpool.resloves;

import com.zpp.compile.ClassPathReader;
import com.zpp.compile.common.ByteUtils;
import com.zpp.compile.core.ConstantPoolUnit;
import com.zpp.compile.core.ConstantPoolUnitResolve;
import com.zpp.compile.core.constantpool.UTF8ConstantPoolUnit;

/**
 * @author steven.zhu 2020/4/9 12:34.
 * @类描述：
 */
public class UTF8ConstantPoolUnitResolve implements ConstantPoolUnitResolve {

    private UTF8ConstantPoolUnit utf8ConstantPoolUnit = new UTF8ConstantPoolUnit(1, "CONSTANT_Utf8_info", "UTF-8编码的字符串");

    @Override
    public ConstantPoolUnit decode(ClassPathReader classPathReader) {
        byte[] constantValueLengthByte = classPathReader.allocByteResource(2);
        Integer constantValueLength = ByteUtils.parseByteArrayToInteger(constantValueLengthByte);
        byte[] constantValueByte = classPathReader.allocByteResource(constantValueLength);
        String constantPoolValue = resolveConstantPoolValue(constantValueByte);
        utf8ConstantPoolUnit.setConstantValue(constantPoolValue);
        return utf8ConstantPoolUnit;
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
        StringBuilder constantValueBuilder = new StringBuilder();
        for (int i = 0; i < constantByte.length; i++) {
            if ((constantByte[i] & 0xFF) < 128) {
                constantValueBuilder.append((char) constantByte[i]);
            } else if ((constantByte[i] & 0xFF) < 2048) {
//                constantValueBuilder.append();
            }
        }
        return null;
    }
}
