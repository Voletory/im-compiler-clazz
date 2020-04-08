package com.zpp.compile.core;

import com.sun.tools.javac.util.Assert;
import com.zpp.compile.ClassStructHold;
import com.zpp.compile.Resource;
import com.zpp.compile.common.ByteUtils;

/**
 * @author steven.zhu 2020/3/27 12:30.
 * @类描述： class文件结构
 * type:  eg:u1,u2,u4,u8来代表1个字节
 * ,2个字节,4个字节,8个字节的无符号数,表是由多个无符号数或者其他表作为数据项构成的
 * 复合数据类型，为了便于区分，所有的表的命名都习惯性以_info结尾
 * name:  类型名称，方便认知
 * number: 该类型的数量
 *
 * eg u4 magic  1 代表4个字节的magic 重复一次
 * 整个class文件本质上也可以视作一张表，这张表由下面数据项按照严格顺序排列构成
 * ---------------------|---------------------|---------------------|
 *          type        |       name          |       number        |
 * ---------------------|---------------------|---------------------|
 *          u4          |       magic         |         1           |
 * ---------------------|---------------------|---------------------|
 *          u2          |   minor_version     |         1           |
 * ---------------------|---------------------|---------------------|
 *          u2          |    major_version    |         1           |
 * ---------------------|---------------------|---------------------|
 *          u2          | constant_pool_count |         1           |
 * ---------------------|---------------------|---------------------|
 *         cp_info      |   constant_pool     |constant_pool_count-1|
 * ---------------------|---------------------|---------------------|
 *          u2          |   access_flags      |         1           |
 * ---------------------|---------------------|---------------------|
 *          u2          |   this_class        |         1           |
 * ---------------------|---------------------|---------------------|
 *          u2          |   super_class       |         1           |
 * ---------------------|---------------------|---------------------|
 *          u2          |   interfaces_count  |         1           |
 * ---------------------|---------------------|---------------------|
 *          u2          |   interfaces        |   interfaces_count  |
 * ---------------------|---------------------|---------------------|
 *          u2          |   fields_count      |         1           |
 * ---------------------|---------------------|---------------------|
 *      field_info      |       fields        |     field_count     |
 * ---------------------|---------------------|---------------------|
 *          u2          |   methods_count     |         1           |
 * ---------------------|---------------------|---------------------|
 *      method_info     |       methods       |    methods_count    |
 * ---------------------|---------------------|---------------------|
 *          u2          |   attributes_count  |         1           |
 * ---------------------|---------------------|---------------------|
 *    attribute_info    |   attributes        |   attributes_count  |
 * ---------------------|---------------------|---------------------|
 *
 */
public final class ClassStruct {

    private Resource resource;

    ClassStructHold magic;

    ClassStructHold minorVersion;

    ClassStructHold major_version;

    ClassStructHold constantPool;

    ClassStructHold access_flags;

    ClassStructHold thisClazz;

    ClassStructHold superClazz;

    ClassStructHold interfaces;

    ClassStructHold fields;

    ClassStructHold methods;

    ClassStructHold attributes;

     public void setResource(Resource resource) {
        this.resource = resource;
     }

}
