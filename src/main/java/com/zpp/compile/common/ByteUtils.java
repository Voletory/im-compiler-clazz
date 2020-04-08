package com.zpp.compile.common;

/**
 * @author steven.zhu 2020/4/2 17:46.
 * @类描述：
 */
public class ByteUtils {

    public static byte[] extractByteArray(byte[] context, Integer startIndex, Integer endIndex) {
        byte[] extractByteArray = new byte[endIndex - startIndex];
        System.arraycopy(context, startIndex, extractByteArray, 0, endIndex - startIndex);
        return extractByteArray;
    }


    /**
     * bytes转为整形支持  4个字节bytes转换
     * 若首位为1  则不能转换为无符号整形，只能转为long类型
     * @param bytes
     * @return
     */
    public static Integer parseByteArrayToInteger(byte[] bytes) {
        Integer num = null;
        if (bytes != null && bytes.length > 0 && bytes.length < 5) {
            for (int i = 0;i < bytes.length;i++) {
                num = num == null?bytes[i] & 0xFF << (bytes.length  - i - 1) * 8 : num | bytes[i] & 0xFF << (bytes.length  - i - 1) * 8;
            }
        }
        return num;
    }

}
