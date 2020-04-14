package com.zpp.compile.core.constantpool;

import com.sun.tools.javac.util.Assert;

/**
 * @author steven.zhu 2020/4/13 12:33.
 * @类描述：
 */
public class MethodHandleInfo {
    /**
     * 值必须在[1,9]中,他决定了方法句柄的类型，方法句柄类型的值
     * 表示方法句柄的字节码行为
     */
    private Integer referenceKind;

    /**
     * 常量池索引
     */
    private Integer referenceIndex;

    public MethodHandleInfo(Integer referenceKind, Integer referenceIndex) {
        Assert.check(referenceKind >= 1 &&  referenceKind <= 9,"" +
                "Method handle reference kind must in range of [1,9]");
        this.referenceKind = referenceKind;
        this.referenceIndex = referenceIndex;
    }

    public Integer getReferenceKind() {
        return referenceKind;
    }

    public void setReferenceKind(Integer referenceKind) {
        Assert.check(referenceKind >= 1 &&  referenceKind <= 9,"" +
                "Method handle reference kind must in range of [1,9]");
        this.referenceKind = referenceKind;
    }

    public Integer getReferenceIndex() {
        return referenceIndex;
    }

    public void setReferenceIndex(Integer referenceIndex) {
        this.referenceIndex = referenceIndex;
    }
}
