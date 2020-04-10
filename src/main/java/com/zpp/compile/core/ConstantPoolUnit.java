package com.zpp.compile.core;

/**
 * @author steven.zhu 2020/4/9 12:12.
 * @类描述：
 */
public abstract class ConstantPoolUnit<T> {
    private Integer tag;
    private String constantPoolType;
    private String description;
    private ConstantPoolResolve constantPoolResolve;


    public ConstantPoolUnit(Integer tag,String constantPoolType,String description) {
        this.tag = tag;
        this.constantPoolType = constantPoolType;
        this.description = description;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getConstantPoolType() {
        return constantPoolType;
    }

    public void setConstantPoolType(String constantPoolType) {
        this.constantPoolType = constantPoolType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract Object constantValue();

    public abstract void fullValue(T value);

    public void setConstantPoolResolve(ConstantPoolResolve constantPoolResolve) {
        this.constantPoolResolve = constantPoolResolve;
    }

    public ConstantPoolResolve getConstantPoolResolve() {
        return constantPoolResolve;
    }
}
