package com.zpp.compile;

import com.sun.tools.javac.util.Assert;
import com.zpp.compile.common.ClassUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author steven.zhu 2020/4/1 20:02.
 * @类描述：
 */
public class ClassDecodeResolves {

    private final List<String> RESOLVES_LIST = new LinkedList<>();

    public ClassDecodeResolves() {
        RESOLVES_LIST.add("com.zpp.compile.core.MagicClazzResolve");
        RESOLVES_LIST.add("com.zpp.compile.core.MinorVersionResolve");
        RESOLVES_LIST.add("com.zpp.compile.core.MajorVersionResolve");
        RESOLVES_LIST.add("com.zpp.compile.core.ConstantPoolResolve");
    }

    private volatile Integer CURRENT_INDEX = 0;

    public DecodeResolve getResolve() {
        synchronized (RESOLVES_LIST) {
            try {
                Assert.check(CURRENT_INDEX < RESOLVES_LIST.size(), "out of range");
                String clazzName = RESOLVES_LIST.get(CURRENT_INDEX++);
                Class<?> aClass = ClassUtils.forName(clazzName, this.getClass().getClassLoader());
                Object o = aClass.newInstance();
                return (DecodeResolve) o;
            } catch (ClassNotFoundException e) {
                // nothing
            } catch (IllegalAccessException e) {
            } catch (InstantiationException e) {
            }
        }
        return null;
    }

    public boolean hasNextResolve() {
        return CURRENT_INDEX < RESOLVES_LIST.size();
    }
}
