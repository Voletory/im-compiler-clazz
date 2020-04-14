package com.zpp.compile.core;

import com.zpp.compile.core.constantpool.ConstantPoolType;
import com.zpp.compile.core.constantpool.resloves.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author steven.zhu 2020/4/9 17:53.
 * @类描述：
 */
public class DefaultConstantPoolUnitResolveSelector extends ConstantPoolUnitResolveSelector {

    private Map<Integer,Class<? extends ConstantPoolUnitResolve>> constantPoolUnitResolveHolder;

    @Override
    public void init() {
        if (constantPoolUnitResolveHolder == null) constantPoolUnitResolveHolder = new HashMap<>();
        constantPoolUnitResolveHolder.put(ConstantPoolType.UTF_8_INFO,UTF8ConstantPoolUnitResolve.class);
        constantPoolUnitResolveHolder.put(ConstantPoolType.INTEGER_INFO, IntegerConstantPoolUnitResolve.class);
        constantPoolUnitResolveHolder.put(ConstantPoolType.FLOAT_INFO, FloatConstantPoolUnitResolve.class);
        constantPoolUnitResolveHolder.put(ConstantPoolType.LONG_INFO, LongConstantPoolUnitResolve.class);
        constantPoolUnitResolveHolder.put(ConstantPoolType.DOUBLE_INFO, DoubleConstantPoolUnitResolve.class);
        constantPoolUnitResolveHolder.put(ConstantPoolType.CLASS_INFO, ClassConstantPoolUnitResolve.class);
        constantPoolUnitResolveHolder.put(ConstantPoolType.FIELD_REF_INFO, FieldRefConstantPoolUnitResolve.class);
        constantPoolUnitResolveHolder.put(ConstantPoolType.METHOD_REF_INFO, MethodRefConstantPoolUnitResolve.class);
        constantPoolUnitResolveHolder.put(ConstantPoolType.STRING_INFO, StringConstantPoolUnitResolve.class);
        constantPoolUnitResolveHolder.put(ConstantPoolType.INTERFACE_METHOD_REF_INFO, InterfaceMethodRefConstantUnitResolve.class);
        constantPoolUnitResolveHolder.put(ConstantPoolType.NAME_AND_TYPE_INFO, NameAndTypeConstantUnitResolve.class);
        constantPoolUnitResolveHolder.put(ConstantPoolType.METHOD_HANDLE_INFO, MethodHandleConstantPoolUnitResolve.class);

        constantPoolUnitResolveHolder.put(ConstantPoolType.METHOD_TYPE_INFO, MethodTypeConstantUnitResolve.class);
        constantPoolUnitResolveHolder.put(ConstantPoolType.DYNAMIC_INFO, DynamicConstantPoolUnitResolve.class);
        constantPoolUnitResolveHolder.put(ConstantPoolType.INVOKE_DYNAMIC_INFO, InvokeDynamicConstantUnitResolve.class);
        // 暂时不做  jdk12之后才有  module模块  jdk无才参数
//        constantPoolUnitResolveHolder.put(ConstantPoolType.MODULE_INFO,new MethodHandleConstantPoolUnitResolve());
//        constantPoolUnitResolveHolder.put(ConstantPoolType.PACKAGE_INFO,new MethodHandleConstantPoolUnitResolve());

    }

    @Override
    public ConstantPoolUnitResolve doSelector(Integer tag) {
        Class<? extends ConstantPoolUnitResolve> aClass = constantPoolUnitResolveHolder.get(tag);
        if (aClass == null) return null;
        ConstantPoolUnitResolve constantPoolUnitResolve = null;
        try {
            constantPoolUnitResolve = aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return constantPoolUnitResolve;
    }
}
