package com.zpp.compile.common;

/**
 * @author steven.zhu 2020/4/2 17:46.
 * @类描述：
 */
public abstract class ByteUtils {

    public static byte[] extractByteArray(byte[] context, Integer startIndex, Integer endIndex) {
        byte[] extractByteArray = new byte[endIndex - startIndex];
        System.arraycopy(context, startIndex, extractByteArray, 0, endIndex - startIndex);
        return extractByteArray;
    }


    /**
     * bytes转为整形支持  4个字节bytes转换
     * 若首位为1  则不能转换为无符号整形，只能转为long类型
     *
     * @param bytes
     * @return
     */
    public static Integer parseByteArrayToInteger(byte[] bytes) {
        Integer num = null;
        if (bytes != null && bytes.length > 0 && bytes.length < 5) {
            for (int i = 0; i < bytes.length; i++) {
                num = num == null ? bytes[i] & 0xFF << (bytes.length - i - 1) * 8 : num | bytes[i] & 0xFF << (bytes.length - i - 1) * 8;
            }
        }
        return num;
    }

    public static Float parseByteArrayToFloat(byte[] floatValue) {
        Integer intValue = parseByteArrayToInteger(floatValue);
        float floatV = Float.intBitsToFloat(intValue);
        return floatV;
    }

    /**
     * 默认大端存储
     * @param input
     * @return
     */
    public static long parseByteArrayToLong(byte[] input) {
        return parseByteArrayToLong(input,0,false);
    }

    /**
     * 将字节数组转为long<br>
     * 如果input为null,或offset指定的剩余数组长度不足8字节则抛出异常
     *
     * @param input
     * @param littleEndian 输入数组是否小端模式
     * @return
     */
    public static long parseByteArrayToLong(byte[] input,boolean littleEndian) {
        return parseByteArrayToLong(input,0,littleEndian);
    }

    /**
     * 将字节数组转为long<br>
     * 如果input为null,或offset指定的剩余数组长度不足8字节则抛出异常
     *
     * @param input
     * @param offset       起始偏移量
     * @param littleEndian 输入数组是否小端模式
     * @return
     */
    public static long parseByteArrayToLong(byte[] input, int offset, boolean littleEndian) {
        long value = 0;
        // 循环读取每个字节通过移位运算完成long的8个字节拼装
        for (int count = 0; count < 8; ++count) {
            int shift = (littleEndian ? count : (7 - count)) << 3;
            value |= ((long) 0xff << shift) & ((long) input[offset + count] << shift);
        }
        return value;
    }

    /**
     * byte转double
     * @param doubleByteArray
     * @return
     */
    public static Double parseByteArrayToDouble(byte[] doubleByteArray) {
        long l = parseByteArrayToLong(doubleByteArray);
        double doubleValue = Double.longBitsToDouble(l);
        return doubleValue;
    }
}
