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

    private Map<Integer,ConstantPoolUnitResolve> constantPoolUnitResolveHolder;

    @Override
    public void init() {
        if (constantPoolUnitResolveHolder == null) constantPoolUnitResolveHolder = new HashMap<>();
        constantPoolUnitResolveHolder.put(ConstantPoolType.UTF_8_INFO,new UTF8ConstantPoolUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.INTEGER_INFO,new IntegerConstantPoolUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.FLOAT_INFO,new FloatConstantPoolUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.LONG_INFO,new LongConstantPoolUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.DOUBLE_INFO,new DoubleConstantPoolUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.CLASS_INFO,new ClassConstantPoolUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.FIELD_REF_INFO,new FieldRefConstantPoolUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.METHOD_REF_INFO,new MethodRefConstantPoolUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.STRING_INFO,new StringConstantPoolUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.INTERFACE_METHOD_REF_INFO,new InterfaceMethodRefConstantUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.NAME_AND_TYPE_INFO,new NameAndTypeConstantUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.METHOD_HANDLE_INFO,new MethodHandleConstantPoolUnitResolve());

        constantPoolUnitResolveHolder.put(ConstantPoolType.METHOD_TYPE_INFO,new MethodTypeConstantUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.DYNAMIC_INFO,new DynamicConstantPoolUnitResolve());
        constantPoolUnitResolveHolder.put(ConstantPoolType.INVOKE_DYNAMIC_INFO,new InvokeDynamicConstantUnitResolve());
        // 暂时不做  jdk12之后才有  module模块  jdk无才参数
//        constantPoolUnitResolveHolder.put(ConstantPoolType.MODULE_INFO,new MethodHandleConstantPoolUnitResolve());
//        constantPoolUnitResolveHolder.put(ConstantPoolType.PACKAGE_INFO,new MethodHandleConstantPoolUnitResolve());

    }

    @Override
    public ConstantPoolUnitResolve doSelector(Integer tag) {
        return constantPoolUnitResolveHolder.get(tag);
    }
}
