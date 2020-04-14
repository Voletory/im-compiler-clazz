package com.zpp.compile.core.constantpool.bean;

/**
 * @author steven.zhu 2020/4/14 12:20.
 * @类描述：
 */
public class DynamicConstantBean {
    /**
     * 当前class文件引导方法表的bootstrap_methods[]数组的有效索引
     */
    private Integer boostrapIndex;

    /**
     * 当前常量池的有效索引，类型必须为nameAndType
     */
    private Integer nameAndTypeIndex;


    public Integer getBoostrapIndex() {
        return boostrapIndex;
    }

    public void setBoostrapIndex(Integer boostrapIndex) {
        this.boostrapIndex = boostrapIndex;
    }

    public Integer getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(Integer nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
}
